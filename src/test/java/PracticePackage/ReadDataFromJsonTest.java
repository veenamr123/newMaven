package PracticePackage;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonTest {

	public static void main(String[] args) throws IOException, ParseException {
		FileReader filepath = new FileReader(".\\src\\test\\resources\\Jsonreader.json");
		
    //json parser is used to read/write from json formatted file
	JSONParser jsonp = new JSONParser();
	Object obj = jsonp.parse(filepath);
	
	//read data from file
	JSONObject map=(JSONObject) obj;
	
	System.out.println(map.get("browser"));
	System.out.println(map.get("url"));
	System.out.println(map.get("un"));
	System.out.println(map.get("pwd"));
	
	}

}
