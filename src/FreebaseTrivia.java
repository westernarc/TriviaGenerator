import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.jayway.jsonpath.JsonPath;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.text.BreakIterator;
import java.util.Locale;
/*
Electron


 */
public class FreebaseTrivia {
	static class Question {
		public String questionText;
		public String[] answers;
		public int correctAnswer;
		public Question() {
		
		}
		public Question(String qt, String[] ans, int ca) {
			questionText = qt;
			answers = ans;
			correctAnswer = ca;
		}
		public Question(String qt) {
			questionText = qt;
		}
	}

		public static void main(String[] args) throws UnsupportedEncodingException {
			FreebaseTrivia ft = new FreebaseTrivia();
			
			ArrayList<Question> questions = new ArrayList<Question>();
			String[] strQuestions = ft.getQuestion(1);
			for(String s : strQuestions) {
				questions.add(ft.buildQuestion("Electron"));
			}
			
			for(Question q : questions) {
				System.out.println(q.questionText);
				for(String ans : q.answers) {
					System.out.println(ans);
				}
				
				System.out.println();
			}
		}
	  public Question buildQuestion(String value) {
		  ArrayList<String> falseAnswers = new ArrayList<String>();
		  String notable = "";
		  String mid = "";
		  String id = "";
		  String name = "";
		  
		  Question question = new Question();
		  falseAnswers.add(value);
		  try {
			  HttpTransport httpTransport = new NetHttpTransport();
			  HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
			  JSONParser parser = new JSONParser();
			  
			  GenericUrl url = new GenericUrl("https://www.googleapis.com/freebase/v1/search");
			  url.put("query", value);
			  url.put("limit", "1");
			  HttpRequest request = requestFactory.buildGetRequest(url);
			  HttpResponse httpResponse = request.execute();
			  JSONObject response = (JSONObject)parser.parse(httpResponse.parseAsString());
			  JSONArray results = (JSONArray)response.get("result");
			  debug(results.toString());
			  for (int i = 0; i < results.size(); i++) {
				  JSONObject result = (JSONObject)results.get(i);
				  id = JsonPath.read(result,"$.id").toString();
			      notable = JsonPath.read(result,"$.notable.id").toString();
			      mid = JsonPath.read(result,"$.mid").toString();
			      name = JsonPath.read(result,"$.name").toString();
			  }
			  
			  //Get Text
			  url = new GenericUrl("https://www.googleapis.com/freebase/v1/topic" + mid);
			  request = requestFactory.buildGetRequest(url);
			  httpResponse = request.execute();
			  response = (JSONObject)parser.parse(httpResponse.parseAsString());
			  question.questionText = JsonPath.read(response,"$.property['/common/topic/description'].values[0].value").toString();
			  
			  //Trim question text to first 3 sentences
			  BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
			  iterator.setText(question.questionText);
			  int limit = iterator.first();
			  for(int i = 0; i < 2; i++) {
				  limit = iterator.next();
			  }
			  question.questionText = question.questionText.substring(0,limit);
			  
			  //Replace all occurrences of topic name in question text
			  question.questionText = question.questionText.replaceAll("(?i)" + name, "???"); 
			 
			  
			  //Get related terms
			  url = new GenericUrl("https://www.googleapis.com/freebase/v1/search");
			  //url.put("query", value);
			  url.put("filter", "(all notable:"+notable+")");
			  url.put("limit", "4");
			  request = requestFactory.buildGetRequest(url);
			  httpResponse = request.execute();
			  response = (JSONObject)parser.parse(httpResponse.parseAsString());
			  results = (JSONArray)response.get("result");
			  for (int i = 0; i < results.size(); i++) {
				  JSONObject result = (JSONObject)results.get(i);
				  if(!JsonPath.read(result,"$.name").toString().equals(name)) {
					  falseAnswers.add(JsonPath.read(result,"$.name").toString());
				  }
			  }
			  Collections.shuffle(falseAnswers);
			} catch (Exception ex) {
			  ex.printStackTrace();
			}
		  String[] arrAnswers = new String[falseAnswers.size()];
		  question.answers = falseAnswers.toArray(arrAnswers);
		  return question;
	  }
	  public String[] getQuestion(int size) {
		  String[] questions = new String[size];
		  ArrayList<String> arrQuestions = new ArrayList<String>();
		  try {
			  HttpTransport httpTransport = new NetHttpTransport();
			  HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
			  GenericUrl url = new GenericUrl("http://en.wikipedia.org/w/api.php?action=query&list=random&rnnamespace=0&rnlimit="+size+"&format=xml");
			  HttpRequest request = requestFactory.buildGetRequest(url);
			  HttpResponse httpResponse = request.execute();
			  String[] strResponse = httpResponse.parseAsString().split("<");
			  for(int i = 0; i < strResponse.length; i++) {
				  int indexStart = strResponse[i].indexOf("title=\"");
				  int indexEnd = strResponse[i].indexOf("\" />");
				  if(indexStart > 0 && indexEnd > 0) {
					  arrQuestions.add(strResponse[i].substring(indexStart+7, indexEnd));
				  }
			  }
			} catch (Exception ex) {
			  ex.printStackTrace();
			}
		  questions = arrQuestions.toArray(questions);
		  return questions;
	  }
	  boolean isDebug = true;
	  private void debug(String str) {
		  if(isDebug) {
			  System.out.println(str);
		  }
	  }
	  
}

