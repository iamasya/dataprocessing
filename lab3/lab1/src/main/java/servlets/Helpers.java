package servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import jakarta.servlet.http.HttpServletRequest;
import Instruments.instrument;

public class Helpers {
	
	public static JsonElement bodyParse(HttpServletRequest request) {
		JsonElement jsonElement=null;	
		
		try {
			jsonElement = JsonParser.parseReader(request.getReader());
		} catch (JsonIOException | JsonSyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonElement;
	}
	
	public static instrument instrumentParse(HttpServletRequest request) {
		
		instrument instrument = new instrument();
		JsonElement jsonElement = bodyParse(request);
		instrument.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
		instrument.setTitle(jsonElement.getAsJsonObject().get("title").getAsString());
		instrument.setInfo(jsonElement.getAsJsonObject().get("info").getAsString());
		instrument.setPrice(jsonElement.getAsJsonObject().get("price").getAsFloat());
		
		
		return instrument;
		
	}
	
	public static int getNextId(List<instrument> list) {
		int maxId = 0;
		
		Iterator<instrument> iterator = list.iterator();
		while(iterator.hasNext()) {
			int currentId = iterator.next().getId();
			if(currentId>maxId) maxId=currentId;
		}
		
		return maxId+1;
	}
	
	public static int getIndexByinstrumentId(int Id,List<instrument> list) {
		
		int listId = Id;
		
		Iterator<instrument> iterator = list.iterator();
		while(iterator.hasNext()) {
			instrument temp =iterator.next();
			if(temp.getId()==listId) { 
				listId=list.indexOf(temp);
				break;
			}
		}
		return listId;
		
	}
	
}
