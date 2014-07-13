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
	private ArrayList<Question> createBatch1() {
		//June 30
		ArrayList<Question> questions = new ArrayList<Question>();
		questions.add(this.buildQuestion("Electron"));
		questions.add(this.buildQuestion("The ??? of a function of a real variable measures the sensitivity to change of a quantity which is determined by another quantity. It is a fundamental tool of calculus. ","Derivative","Integral","Logarithm","Volatility",0));
		questions.add(this.buildQuestion("Sputnik"));
		questions.add(this.buildQuestion("ISS"));
		questions.add(this.buildQuestion("A nanoparticle characterized by a spherical geometry and hollow interior that is comprised of 60 carbon atoms. This configuration is the most common type of fullerene.","Dichlorobenzene","Dodecahedrane","Buckminsterfullerene","Nanotube",2));
		questions.add(this.buildQuestion("Hadron"));
		questions.add(this.buildQuestion("Mount Everest"));
		questions.add(this.buildQuestion("Mount McKinley"));
		questions.add(this.buildQuestion("??? is a landlocked country in east-central Asia. It is bordered by Russia to the north and China to the south, east and west. ","North Korea","Mongolia","Laos","Bangladesh",1));
		questions.add(this.buildQuestion("Io"));
		questions.add(this.buildQuestion("Ares"));
		questions.add(this.buildQuestion("??? of Syracuse was an ancient Greek mathematician, physicist, engineer, inventor, and astronomer. Although few details of his life are known, he is regarded as one of the leading scientists in classical antiquity. ","Pythagoras","Galileo","Aristotle","Archimedes",3));
		
		questions.add(this.buildQuestion("Galapagos Islands"));
		questions.add(this.buildQuestion("???s are marine arthropods of the family Limulidae and order Xiphosura or Xiphosurida, that live primarily in and around shallow ocean waters on soft sandy or muddy bottoms. They occasionally come onto shore to mate. ","Horseshoe Crab","Northern Lobster","Rock Crab","Brine Shrimp",0));
		questions.add(this.buildQuestion("???, known in some English-speaking countries as ???, is a large grain plant domesticated by indigenous peoples in Mesoamerica in prehistoric times. The leafy stalk produces ears which contain the grain, which are seeds called kernels. ","Coconut","Maize","Oil Palm","Barley",1));
		questions.add(this.buildQuestion("??? is one of the best known mythological creatures in Greek mythology. He is a winged divine stallion usually depicted as pure white in color. ","Centaur","Griffin","Sphinx","Pegasus",3));
		questions.add(this.buildQuestion("Florence"));
		questions.add(this.buildQuestion("The ???, sometimes referred to as simply the ???, is a historic fortified complex at the heart of Moscow, overlooking the Moskva River to the south, Saint Basil's Cathedral and Red Square to the east, and the Alexander Garden to the west. It is the best known of ???s and includes five palaces, four cathedrals, and the enclosing ??? Wall with ??? towers. ","St Peter's Cathedral","Moscow Kremlin","Krasnaya Gorka Fort","Derbent",1));
		questions.add(this.buildQuestion("??? is the capital of the Democratic People's Republic of Korea and the largest city in the country. ??? is located on the Taedong River and, according to preliminary results from the 2008 population census, has a population of 3,255,388. ","Incheon","Busan","Seoul","Pyongyang",3));
		questions.add(this.buildQuestion("The ??? is a starchy, tuberous crop from the perennial nightshade Solanum tuberosum L. The word '???' may refer either to the plant itself or the edible tuber. ","Maize","Potato","Artichoke","Carrot",1));
		questions.add(this.buildQuestion("??? is the larger and closer of the two natural satellites of Mars. Both moons were discovered in 1877.","Triton","Deimos","Io","Phobos",3));
		questions.add(this.buildQuestion("Christopher Columbus"));
		questions.add(this.buildQuestion("???, in commerce also spelter, is a metallic chemical element; it has the symbol Zn and atomic number 30. It is the first element of group 12 of the periodic table. ","Zirconium","Xenon","Zinc","Tungsten",2));
		questions.add(this.buildQuestion("??? is a chemical element with the symbol Zr, atomic number 40 and atomic mass of 91.224. The name of ??? is taken from the mineral zircon, the most important source of ???, and from the Persian word 'zargun - ?????', meaning 'gold colored'. ","Zinc","Aluminium","Sodium","Zirconium",3));
		return questions;
	}
	private ArrayList<Question> createBatch2() {
		//July 1
		ArrayList<Question> questions = new ArrayList<Question>();
		/*
		questions.add(this.buildQuestion("Angel Falls"));
		questions.add(this.buildQuestion("Niagara Falls"));
		questions.add(this.buildQuestion("Mount Fuji"));
		questions.add(this.buildQuestion("Chimborazo"));
		questions.add(this.buildQuestion("??? is the saturated fatty acid with an 18-carbon chain and has the IUPAC name octadecanoic acid. It is a waxy solid, and its chemical formula is CH3(CH2)16CO2H. ","Lactic Acid","Stearic acid","Acetic Acid","Benzoic Acid",1));
		questions.add(this.buildQuestion("??? is a naturally occurring, yellow-to-black liquid found in geologic formations beneath the Earth's surface, which is commonly refined into various types of fuels. It consists of hydrocarbons of various molecular weights and other liquid organic compounds. ","Petroleum","Gasoline","Kerosene","Propane",0));
		questions.add(this.buildQuestion("Delphi"));
		questions.add(this.buildQuestion("The ??? is the world's largest coral reef system composed of over 2,900 individual reefs and 900 islands stretching for over 2,300 kilometres over an area of approximately 344,400 square kilometres. The reef is located in the Coral Sea, off the coast of Queensland, Australia.","Red Sea Coral Reef","Great Barrier Reef","Zhongsha Islands","Florida Reef",1));
		questions.add(this.buildQuestion("Angkor Wat"));
		questions.add(this.buildQuestion("Tsunami"));
		questions.add(this.buildQuestion("Artemis"));
		questions.add(this.buildQuestion("Poseidon"));
		//36
		questions.add(this.buildQuestion("Mimas"));
		questions.add(this.buildQuestion("Americium"));
		questions.add(this.buildQuestion("Hermes"));
		questions.add(this.buildQuestion("Hyperion"));
		questions.add(this.buildQuestion("???s are flowering plants of the genus ??? in the family Asteraceae. They are native to Asia and northeastern Europe. ","Amaranthus","Delphinium","Snapdragon","Chrysanthemum",3));
		questions.add(this.buildQuestion("Trafalgar Square"));
		questions.add(this.buildQuestion("Aquila"));
		questions.add(this.buildQuestion("Big Dipper"));
		questions.add(this.buildQuestion("??? is a tumor composed of atypical neoplastic, often pleomorphic cells that invade other tissues. ???s often metastasize to distant anatomic sites and may recur after excision. ","Adenomas","Lipomas","Malignant Neoplasm","Fibromas",2));
		questions.add(this.buildQuestion("??? is the eighth and farthest planet from the Sun in the Solar System. It is the fourth-largest planet by diameter and the third-largest by mass. ","Neptune","Saturn","Uranus","Pluto",0));
		questions.add(this.buildQuestion("Big Ben"));
		questions.add(this.buildQuestion("???, also known as nopales or paddle cactus, is a genus in the cactus family, Cactaceae. Currently, only prickly pears are included in this genus of about 200 species distributed throughout most of the Americas. ","Eucalyptus","Opuntia","Obregonia","Carnegiea",1));
		//48
		 
		questions.add(this.buildQuestion("Brooklyn Bridge"));
		questions.add(this.buildQuestion("Yellowstone"));
		questions.add(this.buildQuestion("Circus Maximus"));
		questions.add(this.buildQuestion("Pantheon"));
		questions.add(this.buildQuestion("Hagia Sophia"));
		questions.add(this.buildQuestion("The ??? is a 553.33 m-high concrete communications and observation tower in Downtown Toronto, Ontario, Canada. Built on the former Railway Lands, it was completed in 1976, becoming the world's tallest free-standing structure and world's tallest tower at the time. ","Sears Tower","Toronto Tower","Space Needle","CN Tower",3));
		questions.add(this.buildQuestion("Black Sea"));
		questions.add(this.buildQuestion("The ??? is an annual film festival held in France, which previews new films of all genres, including documentaries, from around the world. Founded in 1946, it is the most prestigious and publicised film festival in the world. ","Sundance Film Festival","Contemporary Film Conference","Cannes Film Festival","European International Film Festival",2));
		questions.add(this.buildQuestion("Hokkaido"));
		questions.add(this.buildQuestion("The ??? is a major north-flowing river in northeastern Africa, generally regarded as the longest river in the world. It is 6,853 km long. ","Congo River","Zambezi","Nile","Niger River",2));
		questions.add(this.buildQuestion("Olympus Mons"));
		questions.add(this.buildQuestion("Northern Red Sea"));
		
		//60
		questions.add(this.buildQuestion("Sir ??? was an English physicist and mathematician who is widely recognised as one of the most influential scientists of all time and as a key figure in the scientific revolution. His book Philosophiæ Naturalis Principia Mathematica, first published in 1687, laid the foundations for classical mechanics. ","Isaac Newton","Albert Einstein","René Descartes","Benjamin Franklin",0));
		questions.add(this.buildQuestion("??? was an American inventor and businessman. He developed many devices that greatly influenced life around the world, including the phonograph, the motion picture camera, and a long-lasting, practical electric light bulb. ","Benjamin Franklin","Thomas Edison","Isaac Newton","Alexander Graham Bell",1));
		questions.add(this.buildQuestion("Buzz Aldrin"));
		questions.add(this.buildQuestion("Orson Scott Card"));
		questions.add(this.buildQuestion("Charles John Huffam Dickens"));
		questions.add(this.buildQuestion("??? was an English scientist who contributed to the fields of electromagnetism and electrochemistry. His main discoveries include those of electromagnetic induction, diamagnetism and electrolysis.","Thomas Edison","Benjamin Franklin","Michael Faraday","Isaac Newton",2));
		questions.add(this.buildQuestion("James Clerk Maxwell"));
		questions.add(this.buildQuestion("Frankfurt"));
		questions.add(this.buildQuestion("Alan Turing"));
		questions.add(this.buildQuestion("Douglas Carl Engelbart"));
		questions.add(this.buildQuestion("Janis Lyn Joplin"));
		questions.add(this.buildQuestion("John von Neumann"));
		//72
		questions.add(this.buildQuestion("??? was a Soviet pilot and cosmonaut. He was the first human to journey into outer space, when his Vostok spacecraft completed an orbit of the Earth on 12 April 1961.","Vladimir Komarov","Yuri Gagarin","Pavel Popovich","Gherman Titov",1));
		questions.add(this.buildQuestion("John Herschel Glenn, Jr."));
		questions.add(this.buildQuestion("??? is one of the five Great Lakes of North America. It is bounded on the north and southwest by the Canadian province of Ontario, and on the south and east by the American state of New York. ","Lake Michigan","Lake Ontario","Lake Superior","Hudson Lake",1));
		questions.add(this.buildQuestion("??? is one of the African Great Lakes. The lake was named by explorer John Hanning Speke, who was the first European to discover it. ","Lake Malawi","Lake Albert","Lake Edward","Lake Victoria",3));
		questions.add(this.buildQuestion("??? is the largest of the Great Lakes of North America. The lake is bounded by Ontario and Minnesota to the north and west, and Wisconsin and Michigan to the south. ","Lake Ontario","Lake Michigan","Dead Sea","Lake Superior",3));
		questions.add(this.buildQuestion("Lake Huron"));
		questions.add(this.buildQuestion("K2"));
		questions.add(this.buildQuestion("Nanga Parbat"));
		questions.add(this.buildQuestion("Leonhard Euler"));
		questions.add(this.buildQuestion("??? was a Greco-Egyptian writer of Alexandria, known as a mathematician, astronomer, geographer, astrologer, and poet of a single epigram in the Greek Anthology. He lived in the city of Alexandria in the Roman province of Egypt, wrote in Greek, and held Roman citizenship. ","Euler","Copernicus","Ptolemy","Socrates",2));
		questions.add(this.buildQuestion("Plutonium"));
		questions.add(this.buildQuestion("??? is the temporary name of a synthetic superheavy element in the periodic table that has the temporary symbol Uup and has the atomic number 115.It is placed as a heavier homologue to bismuth and the heaviest member of group 15. ","Ununseptium","Ununpentium","Ununpaladium","Uranium",1));
		//84
		questions.add(this.buildQuestion("The ??? is a museum in Philadelphia, Pennsylvania, and one of the oldest centers of science education and development in the United States, dating to 1824.","Neues Museum","Guggenheim Museum","Franklin Institute","Smithsonian Institution",2));
		questions.add(this.buildQuestion("??? was a French aristocrat and military officer born in Chavaniac, in the province of Auvergne in south central France. ??? was a general in the American Revolutionary War and a leader of the Garde nationale during the French Revolution.","Napoleon Bonaparte","Marquis de Lafayette","Suleiman the Magnificent","Charles de Gaulle",1));
		questions.add(this.buildQuestion("??? was a French military and political leader who rose to prominence during the latter stages of the French Revolution and its associated wars in Europe.As ??? I, he was Emperor of the French from 1804 to 1814 and again in 1815. ","Henry IV","Lafayette","Joan of Arc","Napoleon Bonaparte",3));
		questions.add(this.buildQuestion("??? is a 1925 novel written by American author F. Scott Fitzgerald that follows a cast of characters living in the fictional town of West Egg on prosperous Long Island in the summer of 1922. ","Of Mice And Men","The Great Gatsby","The Catcher in the Rye","To Kill A Mockingbird",1));
		questions.add(this.buildQuestion("??? is an inflammatory condition of the lung affecting primarily the microscopic air sacs known as alveoli. It is usually caused by infection with viruses or bacteria and less commonly other microorganisms, certain drugs and other conditions such as autoimmune diseases.","Asthma","Bronchitis","Pneumonia","Tuberculosis",2));
		questions.add(this.buildQuestion("??? was a prolific and influential composer of the Classical era.  ??? showed prodigious ability from his earliest childhood. ","Mozart","Vivaldi","Handel","Bach",0));
		questions.add(this.buildQuestion("??? was a German composer and pianist. A crucial figure in the transition between the Classical and Romantic eras in Western art music, he remains one of the most famous and influential of all composers. ","Vivaldi","Bach","Chopin","Beethoven",3));
		questions.add(this.buildQuestion("??? is the medical term for an event commonly known as a heart attack. It occurs when blood stops flowing properly to a part of the heart, and the heart muscle is injured because it is not receiving enough oxygen. ","Cardiomyopathy","Cor pulmonale","Cardiac dysrhythmias","Myocardial infarction",3));
		questions.add(this.buildQuestion("??? was a German composer and musician of the Baroque period. He enriched established German styles through his skill in counterpoint, harmonic and motivic organisation, and the adaptation of rhythms, forms, and textures from abroad, particularly from Italy and France. ","Chopin","Beethoven","Mozart"," Bach",3));
		questions.add(this.buildQuestion("??? is a bitter, white crystalline xanthine alkaloid and a stimulant drug. ??? is found in varying quantities in the seeds, leaves, and fruit of some plants, where it acts as a natural pesticide that paralyzes and kills certain insects feeding on the plants, as well as enhancing the reward memory of pollinators. ","Methamphetamine","Ecstacy (MDMA)","Amphetamine","Caffeine",3));
		questions.add(this.buildQuestion("A ??? is a flexible woven material consisting of a network of natural or artificial fibres often referred to as thread or yarn. Yarn is produced by spinning raw fibres of wool, flax, cotton, or other material to produce long strands. ","Canvas","Paper","Textile","Polymer",2));
		questions.add(this.buildQuestion("The ??? is a mediterranean sea located between Central and Northern Europe, from 53°N to 66°N latitude and from 10°E to 30°E longitude. It is bounded by the Swedish part of the Scandinavian Peninsula, the mainland of Europe, and the Danish islands. ","Mediterranean Sea","Caribbean Sea","Baltic Sea","Black Sea",2));
		//96
		 */
		questions.add(this.buildQuestion("Coral Reef"));
		questions.add(this.buildQuestion("Maple"));
		questions.add(this.buildQuestion("Oak"));
		questions.add(this.buildQuestion("Deuterium"));
		questions.add(this.buildQuestion("Tritium"));
		questions.add(this.buildQuestion("Quartz"));
		questions.add(this.buildQuestion("In mineralogy, ??? is a metastable allotrope of carbon, where the carbon atoms are arranged in a variation of the face-centered cubic crystal structure called a ??? lattice. ??? is less stable than graphite, but the conversion rate from ??? to graphite is negligible at standard conditions. ","Amethyst","Gypsum","Aragonite","Diamond",3));
		questions.add(this.buildQuestion("??? is an academic and applied discipline that involves the scientific study of mental functions and behaviors. ??? has the immediate goal of understanding individuals and groups by both establishing general principles and researching specific cases, and by many accounts it ultimately aims to benefit society. ","Physiology","Psychology","Philosophy","Sociology",1));
		questions.add(this.buildQuestion("??? is a gemstone variety of the mineral corundum, an aluminium oxide. Trace amounts of other elements such as iron, titanium, chromium, copper, or magnesium can give corundum blue, yellow, purple, orange, or a greenish color. ","Topaz","Aquamarine","Sapphire","Quartz",2));
		questions.add(this.buildQuestion("??? is an alloy of iron and carbon that is widely used in construction and other applications because of its hardness and tensile strength. Carbon, other elements, and inclusions within iron act as hardening agents that prevent the movement of dislocations that naturally exist in the iron atom crystal lattices. ","Titanium","Bronze","Brass","Steel",3));
		questions.add(this.buildQuestion("Willow"));
		questions.add(this.buildQuestion("??? is a metal found in Middle-earth as described in the fantasy writings of J.R.R. Tolkien. ","Orichalcum","Mithril","Conundrum","Adamantium",1));/*
		//108
		questions.add(this.buildQuestion("Cambridge"));
		questions.add(this.buildQuestion("Acropolis"));
		questions.add(this.buildQuestion("Capacitor"));
		questions.add(this.buildQuestion("Neuschwanstein"));
		questions.add(this.buildQuestion("Vacuum Tube"));
		questions.add(this.buildQuestion("Easter Island"));
		questions.add(this.buildQuestion("Manneken Pis"));
		questions.add(this.buildQuestion("St Peter's Cathedral"));
		questions.add(this.buildQuestion("Mount Rushmore"));
		questions.add(this.buildQuestion("Mismi"));
		questions.add(this.buildQuestion("Mount Vesuvius"));
		questions.add(this.buildQuestion("Mount Kilimanjaro"));
		//120
		questions.add(this.buildQuestion("Yellowstone Supervolcano"));
		questions.add(this.buildQuestion("Krakatau"));
		questions.add(this.buildQuestion("Mount Etna"));
		questions.add(this.buildQuestion("Yosemite National Park"));
		questions.add(this.buildQuestion("Ursa Minor"));
		questions.add(this.buildQuestion("Faraday Shield"));
		questions.add(this.buildQuestion("SQL"));
		questions.add(this.buildQuestion("Eucalyptus"));
		questions.add(this.buildQuestion("Hibiscis"));
		questions.add(this.buildQuestion("Hera"));
		questions.add(this.buildQuestion("Demeter"));
		questions.add(this.buildQuestion("Hephaestus"));
		//132
		questions.add(this.buildQuestion("Python"));
		questions.add(this.buildQuestion("JavaScript"));
		questions.add(this.buildQuestion("Pancake"));
		questions.add(this.buildQuestion("Kebab"));
		questions.add(this.buildQuestion("Croissant"));
		questions.add(this.buildQuestion("Rome"));
		questions.add(this.buildQuestion("???, originally called Number Place, is a logic-based, combinatorial number-placement puzzle. The objective is to fill a 9×9 grid with digits so that each column, each row, and each of the nine 3×3 sub-grids that compose the grid contains all of the digits from 1 to 9. ", "Mahjong","Crossword Puzzle","Magic Box","Sudoku",3));
		questions.add(this.buildQuestion("Milan"));
		questions.add(this.buildQuestion("Venice"));
		questions.add(this.buildQuestion("Donut"));
		questions.add(this.buildQuestion("??? or jellies are the major non-polyp form of individuals of the phylum Cnidaria. They are typified as free-swimming marine animals consisting of a gelatinous umbrella-shaped bell and trailing tentacles. ", "Squid","Jellyfish","Octopus","Sea Cucumber",1));
		questions.add(this.buildQuestion("The ??? is the second-largest living fish, after the whale shark, and one of three plankton-eating sharks besides the whale shark and megamouth shark. It is a cosmopolitan migratory species, found in all the world's temperate oceans. ", "Blue Whale", "Basking Shark", "Nurse Shark", "Great White Shark", 1));
		//144
		questions.add(this.buildQuestion("The ???, also known as lepatata Mambu (its Tswana name), is a plastic horn, about 65 centimetres (2 ft) long, which produces a loud monotone note, typically around the B-flat below middle C","Vuvuzela","Kazoo","Makarapa","Shofar",0));
		questions.add(this.buildQuestion("???, also known as Ayers Rock and officially gazetted as ??? / Ayers Rock, is a large sandstone rock formation in the southern part of the Northern Territory in central Australia. It lies 335 km south west of the nearest large town, Alice Springs, 450 km by road.","Kata Tjuta","Mount Augustus","Plymouth Rock","Uluru",3));
		questions.add(this.buildQuestion("The ??? is a wind instrument developed by Indigenous Australians of northern Australia around 1,500 years ago and still in widespread use today both in Australia and around the world. It is sometimes described as a natural wooden trumpet or 'drone pipe'.","Didgeridoo","Kazoo","Stone Flute","Brigalow",0));
		questions.add(this.buildQuestion("The ??? is a musical instrument that adds a 'buzzing' timbral quality to a player's voice when the player vocalizes into it. The ??? is a type of mirliton, which is a membranophone, one of a class of instruments which modifies its player's voice by way of a vibrating membrane.","Saxophone","Reed Pipe","Kazoo","Clarinet",2));
		questions.add(this.buildQuestion("??? is the common name of Allium schoenoprasum, the smallest species of the edible onion genus. A perennial plant, it is native to Europe, Asia and North America. ","Scallion","Shallot","Chive","Leek",2));
		questions.add(this.buildQuestion("???, a member of the grass family, is a major cereal grain. It was one of the first cultivated grains and is now grown widely. ","Buckwheat","Barley","Quinoa","Wattleseed",1));
		questions.add(this.buildQuestion("Fresco"));
		questions.add(this.buildQuestion("The ??? tree, is a member of the family Arecaceae. It is the only accepted species in the genus Cocos. ","Coconut","Coquito Palm","Doum palm","Palmettos",0));
		questions.add(this.buildQuestion("The ??? is a fruit regarded by many people in southeast Asia as the 'king of fruits'. The ??? is distinctive for its large size, strong odour, and formidable thorn-covered husk. ","Prickly Pear","Durian","Jackfruit","Rambutan",1));
		questions.add(this.buildQuestion("The ??? is a species of tree in the Artocarpus genus of the mulberry family. It is native to parts of South and Southeast Asia, and is believed to have originated in the southwestern rain forests of India, in present-day Kerala,in Tamil Nadu, coastal Karnataka and Maharashtra.","Pineapple","White Mulberry","Jackfruit","Durian",2));
		questions.add(this.buildQuestion("???s are conifer trees in the family Pinaceae. They are the only genus in the subfamily Pinoideae. ","Oak Tree", "Spruce Tree","Cedar Tree","Pine Tree",3));
		questions.add(this.buildQuestion("??? is an organic chemical compound with the molecular formula C6H6. Its molecule is composed of 6 carbon atoms joined in a ring, with 1 hydrogen atom attached to each carbon atom. ","Benzene","Hydrazine","Ethyne","Methane",0));
		*/
		//156
		return questions;
	}
	private ArrayList<Question> createBatch3() {
		//July 2
		ArrayList<Question> questions = new ArrayList<Question>();
		
		questions.add(this.buildQuestion("Deep Blue"));
		questions.add(this.buildQuestion("Titanic"));
		questions.add(this.buildQuestion("USS Intrepid"));
		questions.add(this.buildQuestion("Warsaw"));
		questions.add(this.buildQuestion("Treaty of Versaille"));
		questions.add(this.buildQuestion("Orchid"));
		questions.add(this.buildQuestion("Holland"));
		questions.add(this.buildQuestion("Rhinoplasty"));
		questions.add(this.buildQuestion("Lepton"));
		questions.add(this.buildQuestion("Large Hadron Collider"));
		questions.add(this.buildQuestion("Boron"));
		questions.add(this.buildQuestion("Ebola"));
		//168
		questions.add(this.buildQuestion("Ngorogoro Crater"));
		questions.add(this.buildQuestion("Paria Canyon"));
		questions.add(this.buildQuestion("Mount Roraima"));
		questions.add(this.buildQuestion("Yosemite National Park"));
		questions.add(this.buildQuestion("Old Faithful"));
		questions.add(this.buildQuestion("Mayon Volcano"));
		questions.add(this.buildQuestion("Henry David Thoreau"));
		questions.add(this.buildQuestion("John Adams"));
		questions.add(this.buildQuestion("Max Planck"));
		questions.add(this.buildQuestion("Charles Robert Darwin"));
		questions.add(this.buildQuestion("Louis Pasteur"));
		questions.add(this.buildQuestion("Johannes Kepler"));
		//180
		questions.add(this.buildQuestion("Jeju Island Lava Tubes"));
		questions.add(this.buildQuestion("Skaftafell National Park"));
		questions.add(this.buildQuestion("Lake Titicaca"));
		questions.add(this.buildQuestion("Puerto Princesa Subterranean River"));
		questions.add(this.buildQuestion("Plitvice Lakes"));
		questions.add(this.buildQuestion("Mount Bromo"));
		questions.add(this.buildQuestion("Cueva de los Cristales/Cave of Crystals"));
		questions.add(this.buildQuestion("The Bay of Fundy"));
		questions.add(this.buildQuestion("??? is a UNESCO World Heritage Site, and a popular travel destination, in Quang Ninh Province, Vietnam. Administratively, the bay belongs to a City of the same name, Cam Pha town, and part of Vân Don District. ","World Ocean","Ha Long Bay","Mediterranean Sea","Atlantic Ocean",1));
		questions.add(this.buildQuestion("Salyut"));
		questions.add(this.buildQuestion("Lake Baikal"));
		questions.add(this.buildQuestion("Mir"));
		//192			 
		questions.add(this.buildQuestion("Harpsichord"));
		questions.add(this.buildQuestion("Clarinet"));
		questions.add(this.buildQuestion("Oboe"));
		questions.add(this.buildQuestion("Bassoon"));
		questions.add(this.buildQuestion("Calliope"));
		questions.add(this.buildQuestion("Bugle"));
		questions.add(this.buildQuestion("Trombones"));
		questions.add(this.buildQuestion("Ukulele"));
		questions.add(this.buildQuestion("Mandolin"));
		questions.add(this.buildQuestion("Lute"));
		questions.add(this.buildQuestion("Lake Baikal"));
		questions.add(this.buildQuestion("Meritocracy"));
		//204
		//July 2
		return questions;
	}
	private ArrayList<Question> createBatch4() {
		//July 4
		ArrayList<Question> questions = new ArrayList<Question>();
		questions.add(this.buildQuestion("??? is the name given to a series of storms on Neptune similar in appearance to those on Jupiter. The first one was observed in 1989 by NASA's Voyager 2 spaceprobe. ","Great Red Spot","Cydonia","Tycho","The Great Dark Spot",3));
		questions.add(this.buildQuestion("Tycho"));
		questions.add(this.buildQuestion("Heliocentric orbit"));
		questions.add(this.buildQuestion("The ???s are the five positions in an orbital configuration where a small object affected only by gravity can theoretically be part of a constant-shape pattern with two larger objects. They mark positions where the combined gravitational pull of the two large masses provides precisely the centripetal force required to orbit with them. ","Geostationary orbit","Inclined orbit","Parabolic trajectory","Lagrangian point",3));
		questions.add(this.buildQuestion("Cirrocumulus"));
		questions.add(this.buildQuestion("Contrail"));
		questions.add(this.buildQuestion("Altostratus"));
		questions.add(this.buildQuestion("Altocumulus"));
		questions.add(this.buildQuestion("Stratus"));
		questions.add(this.buildQuestion("Cumulonimbus calvus"));
		questions.add(this.buildQuestion("Nimbostratus"));
		questions.add(this.buildQuestion("A ??? is a dense cumuliform cloud associated with fire or volcanic activity. A ??? is similar dynamically in some ways to a firestorm, and the two phenomena may occur in conjunction with each other. ","Wildfire","Pyrocumulus","Conflagration","Stratus",1));
		
		//216
		questions.add(this.buildQuestion("Catadioptric"));
		questions.add(this.buildQuestion("Gravitational-wave detector"));
		questions.add(this.buildQuestion("Radio telescope"));
		questions.add(this.buildQuestion("A ??? is a type of solar telescope designed by George Ellery Hale in 1924 to allow the Sun to be viewed in a selected wavelength of light.","Spectrohelioscope","Herschelian telescope","Pfund telescope","Dobsonian telescope",0));
		questions.add(this.buildQuestion("Cygnus A"));
		questions.add(this.buildQuestion("Crab Nebula"));
		questions.add(this.buildQuestion("WAV"));
		questions.add(this.buildQuestion("The ??? is a bitmap image format that was introduced by CompuServe in 1987 and has since come into widespread usage on the World Wide Web due to its wide support and portability.The format supports up to 8 bits per pixel for each image, allowing a single image to reference its own palette of up to 256 different colors chosen from the 24-bit RGB color space. ","SVG","JPEG","TIF","GIF",3));
		questions.add(this.buildQuestion("???, is a raster graphics file format that supports lossless data compression. ??? was created as an improved, non-patented replacement for Graphics Interchange Format, and is the most used lossless image compression format on the Internet.","PNG","JPEG","BMP","RGF",0));
		questions.add(this.buildQuestion("??? is a raster graphics file format created by Truevision Inc.. It was the native format of the first graphic cards for IBM-compatible PCs to support Highcolor/truecolor display. ","TGA","BMP","GIF","JPEG",0));
		questions.add(this.buildQuestion("??? is a family of database server products developed by IBM. These products all support the relational model, but in recent years some products have been extended to support object-relational features and non-relational structures, in particular XML.","Microsoft SQL Server","DB2","Oracle","Interbase",1));
		questions.add(this.buildQuestion("??? is the world's second most widely used open-source relational database management system. It is named after co-founder Michael Widenius's daughter. ","Netezza","MySQL","Teradata","Sybase",1));
		//228
		questions.add(this.buildQuestion("??? is the standard markup language used to create web pages. ??? is written in the form of ??? elements consisting of tags enclosed in angle brackets. ","Flash","SQL","HTML","Java",2));
		questions.add(this.buildQuestion("??? is a simple mechanism for adding style (e.g.fonts, colors, spacing) to Web documents.  While most often used to style web pages and interfaces written in HTML and XHTML, the language can be applied to any kind of XML document. ","Layout Document","Cascading Style Sheets","Formatting Standards File","Web Config Specification",1));
		questions.add(this.buildQuestion("The American Standard Code for Information Interchange is a character-encoding scheme originally based on the English alphabet that encodes 128 specified characters - the numbers 0-9, the letters a-z and A-Z, some basic punctuation symbols, some control codes that originated with Teletype machines, and a blank space - into the 7-bit binary integers.??? codes represent text in computers, communications equipment, and other devices that use text. ","ASCII","ANSI","Unicode","UTF-8",0));
		questions.add(this.buildQuestion("In electronic systems and computing, ??? is the combination of persistent memory and program code and data stored in it. Typical examples of devices containing ??? are embedded systems, computers, computer peripherals, mobile phones, and digital cameras. ","Operating System","Control Panel","Firmware","Flash Settings",2));
		questions.add(this.buildQuestion("In computer networks, a ??? is a server that acts as an intermediary for requests from clients seeking resources from other servers. A client connects to the ???, requesting some service, such as a file, connection, web page, or other resource available from a different server and the ??? evaluates the request as a way to simplify and control its complexity. ","Router","Proxy server","Localhost","Hosting Service",1));
		questions.add(this.buildQuestion("??? is the fourth version in the development of the Internet Protocol Internet, and routes most traffic on the Internet. ","Transport Layer Security v4","IP v4","Ethernet v4","IPTV v4",1));
		questions.add(this.buildQuestion("A ??? is a computer network that interconnects computers within a limited area such as a home, school, computer laboratory, or office building, using network media. The defining characteristics of ???s, in contrast to wide area networks, include their smaller geographic area, and non-inclusion of leased telecommunication lines.","Private Area Network","Philosophy","","Local Area Network",3));
		questions.add(this.buildQuestion("Ethernet"));
		questions.add(this.buildQuestion("A ??? is a device that forwards data packets between computer networks. This creates an overlay internetwork, as a ??? is connected to two or more data lines from different networks. ","Router","Modem","Network Card","Cable Box",0));
		questions.add(this.buildQuestion("??? is one of the first practicable public-key cryptosystems and is widely used for secure data transmission. In such a cryptosystem, the encryption key is public and differs from the decryption key which is kept secret. ","AES","Code Switching","RSA","Caesar Cipher",2));
		questions.add(this.buildQuestion("??? is a local area wireless technology that allows an electronic device to exchange data or connect to the internet using 2.4 GHz UHF and 5 GHz SHF radio waves. The name is a trademark name, and is a play on a similar sounding audiophile term. ","WPA","PAN","WiFi","LAN",2));
		questions.add(this.buildQuestion("A ??? is a computer networking device that is used to connect devices together on a computer network by performing a form of packet switching. A switch is considered more advanced than a hub because a switch will only send a message to the device that needs or requests it, rather than broadcasting the same message out of each of its ports.","Gateway","Router","Network Switch","Multiplexer",2));
		//240
		questions.add(this.buildQuestion("??? is an object-relational database management system produced and marketed by a company founded by Larry Ellison and two friends and former co-workers, Bob Miner and Ed Oates.  They started a consultancy called Software Development Laboratories in 1977. ","MySQL","Microsoft SQL Server","PostgreSQL","Oracle Database",3));
		questions.add(this.buildQuestion("??? is a white or colorless soft solid derivable from petroleum, coal or shale, that consists of a mixture of hydrocarbon molecules containing between twenty and forty carbon atoms. It is solid at room temperature and begins to melt above approximately 37 °C; its boiling point is >370 °C. ","Styrofoam","Polyethylene","Paraffin","Polystyrene",2));
		questions.add(this.buildQuestion("A ??? is a type of rigid airship named after a German Count who pioneered rigid airship development at the beginning of the 20th century. His ideas were first formulated in 1874 and developed in detail in 1893. ","Blimp","Helicopter","Hot Air Balloon","Zeppelin",3));
		questions.add(this.buildQuestion("Concorde"));
		questions.add(this.buildQuestion("??? is an aircraft manufacturing division formerly named the European Aeronautic Defence and Space Company.  It is based in Blagnac, France. ","Airbus","Aerospatiale-BAC","Boeing","Alenia Aeronautica",0));
		questions.add(this.buildQuestion("??? is an American multinational corporation that designs, manufactures, and sells fixed-wing aircraft, rotorcraft, rockets and satellites. It was founded in Chicago in 1916 and is the largest exporter in the USA by dollar value.","Lockheed Martin","Airbus","Douglas","Boeing",3));
		questions.add(this.buildQuestion("??? is a cross-language, multi-platform application programming interface for rendering 2D and 3D vector graphics. The API is typically used to interact with a graphics processing unit, to achieve hardware-accelerated rendering.","OpenGL","Unreal Engine","DirectX","nVidia",0));
		questions.add(this.buildQuestion("FORTRAN"));
		questions.add(this.buildQuestion("??? is a Russian joint stock company founded in 1939. It is a military aircraft design bureau, primarily designing fighter aircraft such as the 'Foxbat','Flogger', and 'Fulcrum'.","Sukhoi","Mil","Tupelov","Mikoyan Gurevich",3));
		questions.add(this.buildQuestion("ARM"));
		questions.add(this.buildQuestion("??? Company is a major Russian aircraft manufacturer, headquartered in Begovoy District, Northern Administrative Okrug, Moscow, famous for its fighters. It was founded by Pavel ??? in 1939 as the ??? Design Bureau.","Sukhoi","Mikoyan","Tupelov","Ilyushin",0));
		questions.add(this.buildQuestion("??? is a leading global provider of innovative processing solutions in the computing, graphics and consumer electronics markets. Created the Athlon, Sempron, and Phenom processor lines, as well as the Radeon graphics card line.","Advanced Micro Devices","Renesas Electronics","ATI Technologies","Infineon Technologies",0));
		//252
		
		
		questions.add(this.buildQuestion("The ??? is a single-seat, twin-engine, all weather stealth tactical fighter developed for the United States Air Force. The result of the USAF's Advanced Tactical Fighter program, the aircraft was designed primarily as an air superiority fighter, but has additional capabilities including ground attack, electronic warfare, and signals intelligence roles. ","F-105 Starfighter","F-35 Lightning","F-22 Raptor","F-16 Falcon",2));
		questions.add(this.buildQuestion("The ??? is a family of single-seat, single-engine, fifth-generation multirole fighters under development to perform ground attack, reconnaissance, and air defense missions with stealth capability. The F-35 has three main models; the conventional takeoff and landing variant, the short take-off and vertical-landing variant, and a carrier-based variant.","Chengdu Super-10","F-4 Phantom","F-35 Lightning","A-10 Warthog",2));
		questions.add(this.buildQuestion("The ???, also known as the Stealth Bomber, is an American strategic bomber, featuring low observable stealth technology designed for penetrating dense anti-aircraft defenses; it is able to deploy both conventional and nuclear weapons. The Northrop Grumman developed bomber has a crew of two and can drop up to sixteen 2,400 lb B83 nuclear bombs. ","PAK-DA","F-117 Nighthawk","B-52 Stratofortress","B-2 Spirit",3));
		questions.add(this.buildQuestion("The Lockheed ??? was an advanced, long-range, Mach 3+ strategic reconnaissance aircrathis. It was developed as a black project from the Lockheed A-12 reconnaissance aircraft in the 1960s by Lockheed and its Skunk Works division. ","X-44 Manta","EC-121 Warning Star","SR-71 Blackbird","U-2 Dragon Lady",2));
		questions.add(this.buildQuestion("??? is a Buddhist temple in Ikaruga, Nara Prefecture, Japan. Its full name is 'Learning Temple of the Flourishing Law'; the complex serving as both a seminary and monastery.","Horyu-ji","Kiyomizu-dera","Shaolin Monastery","Borobudur",0));
		questions.add(this.buildQuestion("The ??? is a long-range, subsonic, jet-powered strategic bomber. The ??? was designed and built by Boeing, which has continued to provide support and upgrades. ","B-52 Stratofortress","B-17 Flying Fortress","B-70 Valkyrie","B-1 Lancer",0));
		questions.add(this.buildQuestion("The ??? is a suspension bridge spanning a strait of the same name, a mile-wide, three-mile-long channel between San Francisco Bay and the Pacific Ocean. The structure links the U.S. city of San Francisco, on the northern tip of the San Francisco Peninsula, to Marin County. ","San Fransisco Bridge","Tower Bridge","Golden Gate Bridge","George Washington Bridge",2));
		questions.add(this.buildQuestion("The ??? flows through southern England. It is the longest river entirely in England and the second longest in the United Kingdom, after the River Severn. ","Seine River","Thames River","Tyne River","Avon River",1));
		questions.add(this.buildQuestion("The ??? is a 776 km long river and an important commercial waterway within the Paris Basin in the north of France. It rises at Source-???, 30 kilometers northwest of Dijon in northeastern France in the Langres plateau, flowing through Paris and into the English Channel at Le Havre. ","Seine River","Thames River","Loire River","Rhone River",0));
		questions.add(this.buildQuestion("The ??? is a cable-stayed bridge that spans the valley of the River Tarn in southern France. Designed by the French structural engineer Michel Virlogeux and British architect Norman Foster, it is the tallest bridge in the world with one mast's summit at 343.0 metres above the base of the structure. ","Millau Viaduct","Severn Bridge","Penang Second Bridge","Pont d'Aquitaine",0));
		questions.add(this.buildQuestion("The ??? is a Medieval stone closed-spandrel segmental arch bridge over the Arno River, in Florence, Italy, noted for still having shops built along it, as was once common. Butchers initially occupied the shops; the present tenants are jewelers, art dealers and souvenir sellers. ","Ponte Vecchio","Ponte alle Grazie","Pons Sublicius","Ponte Amerigo Vespucci",0));
		questions.add(this.buildQuestion("Cologne"));
		//264
		//July 4
		return questions;
	}
	static String USERKEY="AIzaSyC1-X0QZvebUzAoB2WW5iN4P5V1JZjR-3k";
		public static void main(String[] args) throws Exception {
			FreebaseTrivia ft = new FreebaseTrivia();
			
			ArrayList<Question> questions = new ArrayList<Question>();
			//questions.addAll(ft.createBatch1());
			questions.addAll(ft.createBatch2());
			//questions.addAll(ft.createBatch3());	
			//questions.addAll(ft.createBatch4());	

			
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
		public Question buildQuestion(String questionText, String ans1, String ans2, String ans3, String ans4, int correctAnswer) {
			String[] answers = new String[] {ans1,ans2,ans3,ans4};
			return new Question(questionText,answers, correctAnswer);
		}
	  public Question buildQuestion(String value) {
		  ArrayList<String> falseAnswers = new ArrayList<String>();
		  String notable = "";
		  String mid = "";
		  String id = "";
		  String name = "";
		  String debugStr = "questions.add(ft.buildQuestion(\"";

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
			  debugStr = debugStr + question.questionText + "\",";
			  
			  
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
		  for(String a : arrAnswers) {
			  debugStr = debugStr + "\""+a+"\",";
		  }
		  debugStr = debugStr + question.correctAnswer + "));";
		  System.out.println(debugStr);
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

