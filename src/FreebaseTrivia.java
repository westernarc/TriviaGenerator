import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.jayway.jsonpath.JsonPath;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
	static String USERKEY="AIzaSyC1-X0QZvebUzAoB2WW5iN4P5V1JZjR-3k";
		public static void main(String[] args) throws Exception {
			FreebaseTrivia ft = new FreebaseTrivia();
			
			ArrayList<Question> questions = new ArrayList<Question>();
			//String[] strQuestions = ft.getQuestion(1);
			
			questions.add(ft.buildQuestion("Electron"));
			questions.add(ft.buildQuestion("Derivative"));
			questions.add(ft.buildQuestion("Sputnik"));
			questions.add(ft.buildQuestion("ISS"));
			questions.add(ft.buildQuestion("Buckminsterfullerene"));
			questions.add(ft.buildQuestion("Hadron"));
			questions.add(ft.buildQuestion("Mount Everest"));
			questions.add(ft.buildQuestion("Mount McKinley"));
			questions.add(ft.buildQuestion("Mongolia"));
			questions.add(ft.buildQuestion("Io"));
			questions.add(ft.buildQuestion("Ares"));
			questions.add(ft.buildQuestion("Archimedes"));
			
			questions.add(ft.buildQuestion("Galapagos Islands"));
			questions.add(ft.buildQuestion("Horseshoe Crab"));
			questions.add(ft.buildQuestion("London Heathrow Airport"));
			questions.add(ft.buildQuestion("Pegasus"));
			questions.add(ft.buildQuestion("Florence"));
			questions.add(ft.buildQuestion("Kremlin"));
			questions.add(ft.buildQuestion("Pyongyang"));
			questions.add(ft.buildQuestion("Eiffel Tower"));
			questions.add(ft.buildQuestion("Phobos"));
			questions.add(ft.buildQuestion("Christopher Columbus"));
			questions.add(ft.buildQuestion("Zinc"));
			questions.add(ft.buildQuestion("Zirconium"));
			
			//Write question file
			
			File file = new File("C:/Unity/Labyrinth/Assets/QuestionList.cs");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("using UnityEngine;\n"); bw.newLine();
			bw.write("using System.Collections;"); bw.newLine();
			bw.write("using System.Collections.Generic;"); bw.newLine();
			bw.write("public class QuestionList {"); bw.newLine();
			bw.write("public static Main.Question[] questions = new Main.Question[] {"); bw.newLine();
			
			for(Question q : questions) {
				bw.write("new Main.Question(\""+q.questionText+"\", new string[] {");
				ft.debug(q.questionText);
				for(String ans : q.answers) {
					ft.debug(ans);
					bw.write("\""+ans+"\", ");
				}
				
				ft.debug("");
				bw.write("}," + q.correctAnswer + "),");
				bw.newLine();
			}
			bw.write("};");
			bw.newLine();
			bw.write("}");
			bw.close();
		}
	  public Question buildQuestion(String value) {
		  ArrayList<String> falseAnswers = new ArrayList<String>();
		  String notable = "";
		  String mid = "";
		  String id = "";
		  String name = "";
		  
		  Question question = new Question();
		  try {
			  HttpTransport httpTransport = new NetHttpTransport();
			  HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
			  JSONParser parser = new JSONParser();
			  
			  GenericUrl url = new GenericUrl("https://www.googleapis.com/freebase/v1/search");
			  url.put("query", value);
			  url.put("limit", "1");
			  url.put("key", USERKEY);
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
			  falseAnswers.add(name);
			  
			  //Get Text
			  url = new GenericUrl("https://www.googleapis.com/freebase/v1/topic" + mid);
			  url.put("key", USERKEY);
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
			  question.questionText = question.questionText.replaceAll("(?i)" + value, "???");
			  //Replace new lines
			  question.questionText = question.questionText.replaceAll("\n", "");
			  //Replace all double quotes
			  question.questionText = question.questionText.replaceAll("\"", "'");
			  
			  //Get related terms
			  url = new GenericUrl("https://www.googleapis.com/freebase/v1/search");
			  url.put("filter", "(all notable:"+notable+")");
			  url.put("limit", "4");
			  url.put("key", USERKEY);
			  request = requestFactory.buildGetRequest(url);
			  httpResponse = request.execute();
			  response = (JSONObject)parser.parse(httpResponse.parseAsString());
			  results = (JSONArray)response.get("result");
			  int ansCount = 0;
			  for (int i = 0; i < results.size(); i++) {
				  JSONObject result = (JSONObject)results.get(i);
				  debug(result.toString());
				  debug(JsonPath.read(result,"$.mid").toString() + " = " + mid + "?" + (JsonPath.read(result,"$.mid").toString().equals(mid)));
				  if(!JsonPath.read(result,"$.mid").toString().equals(mid) && ansCount < 3) {
					  falseAnswers.add(JsonPath.read(result,"$.name").toString());
					  ansCount++;
				  }
			  }
			  debug("");
			  Collections.shuffle(falseAnswers);
			} catch (Exception ex) {
			  ex.printStackTrace();
			}
		  String[] arrAnswers = new String[falseAnswers.size()];
		  question.answers = falseAnswers.toArray(arrAnswers);
		  question.correctAnswer = falseAnswers.indexOf(name);
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
	  boolean isDebug = false;
	  private void debug(String str) {
		  if(isDebug) {
			  System.out.println(str);
		  }
	  }
	  
}

