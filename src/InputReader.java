import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import util.Hotel;
import util.Sentiment;
import util.Sentiment_Phrase;

public class InputReader {

	public void readReviews(String path, ArrayList<Hotel> hotels)
	{
		Gson gson = new Gson();
		try {
			Hotel m_hotel = null;
			File folder = new File(path);
			File[] listOfFiles = folder.listFiles();
//read reviews one by one from given path
			    for (int i = 0; i < listOfFiles.length; i++) {
			      if (listOfFiles[i].isFile()) {
					m_hotel = gson.fromJson(new FileReader(listOfFiles[i].getPath()), Hotel.class);
					hotels.add(m_hotel);

			      } else if (listOfFiles[i].isDirectory()) {
			        System.out.println("Directory " + listOfFiles[i].getName());
			      }
			    }
			
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}
	public void readSemantics(String path,Sentiment s){
		
		Gson gson = new Gson();
		
		try {
			s = gson.fromJson(new FileReader(path), Sentiment.class);
            System.out.println("-------------");
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public HashMap<String, String[]> createTopicMap(String path) {
		HashMap<String, String[]> topics =new HashMap<String, String[]>();
////String[]sleep ={"bed","sleep quality","mattresses","linens"};
//topics.put("sleep", sleep);
//String[]
return topics;
	}
}
