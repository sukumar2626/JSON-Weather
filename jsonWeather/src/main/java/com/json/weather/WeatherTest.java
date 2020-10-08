package com.json.weather;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class WeatherTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JSONParser jp = new JSONParser();          //Creat json parser object
		
		try{
			FileReader read = new FileReader("weather.json");         //read the file
			Object ob=jp.parse(read);
			//JSONArray jarray=(JSONArray) ob;			//casting the object into json array
			
			//fetch whole data
			JSONObject jo =(JSONObject) ob;
//			System.out.println(jo);
			
			//fetch json weather data
			 
			JSONArray ja =(JSONArray) jo.get("WeatherData");
//			System.out.println(ja);
			
//			JSONObject j =(JSONObject) ja.get(1);
//			System.out.println(j);
	
			
			//for each value calling the findvalue function using lambda 
			//		ja.forEach(a->findValue((JSONObject)a));
			
			
			
			
			System.out.println(String.format("NO of date => %d", ja.size()));
			
			//fetch all json arrey data
			
			for (int i = 0; i < ja.size(); i++) {
	            JSONObject obj1 = (JSONObject) ja.get(i);
	          //  System.out.println(obj1);
	            
	            //print date
	            String date =(String) obj1.get("date");
	    		System.out.println("\nDATE:" +date);
	    		JSONArray city =(JSONArray) obj1.get("City");
	    		double maxTemp=0;
	    		int aa=0;
	    		
	    		for (int j = 0; j < city.size(); j++)
	    				{
	    					JSONObject c = (JSONObject) city.get(j);
	    				
	    					//fetch city name
	    					String cname =(String) c.get("name");
	    					System.out.println("\tCity Name:  " +cname);
	    					
	    					//fetch weather details
	    					JSONObject weather =(JSONObject) c.get("weather");

	    					
	    					
	    					//fetch humidity
	    					long humidity =(long) weather.get("humidity");
	    					if(humidity>=90)
	    						System.out.println("\t\tHumidity: "+humidity+"%"+"\tChances of Rain : HIGH  ");
	    					else if(humidity>80 && humidity<90)
	    						System.out.println("\t\tHumidity: "+humidity+"%"+"\tChances of Rain : MEDIUM  ");
	    					else
	    						System.out.println("\t\tHumidity: "+humidity+"%"+"\tChances of Rain : LOW  ");
	    					
	    					//fetch maximum temp
	    					double temp=(double) weather.get("temp_max");
	    					
	    					if(temp>maxTemp)
	    					{
	    						maxTemp=temp;
	    						aa+=1;
	    					}
	    					
	    				}
	    		if(aa == 1)
	    			System.out.println("\tHotest City : KOLKATA (Temp:"+maxTemp+")");
	    		else if(aa==2)
	    			System.out.println("\tHotest City : MUMBAI (Temp:"+maxTemp+")");
			}

		}catch(FileNotFoundException e)
		{
			System.out.println("FileNotFoundException found");
			e.printStackTrace();
		}
		catch(ParseException e)
		{
			System.out.println("ParseException found");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException found");
			e.printStackTrace();
		}
		
	    
//******************************* ANOTHER WAY***************************
		
		


	}

/*	private static void findValue(JSONObject a) {
		
		
		String date =(String) a.get("date");
		System.out.println("\nDATE:" +date);
		
		//fetch city array
		JSONArray city =(JSONArray) a.get("City");
		//System.out.println(city);
		
		//fetch all city's value

		city.forEach(c -> findEachCityValue((JSONObject)c));

		
	}

	private static void findEachCityValue(JSONObject c) {
		
		//fetch city name
		String cname =(String) c.get("name");
		System.out.println("\tCity Name:  " +cname);
		
		//fetch weather details
		JSONObject weather =(JSONObject) c.get("weather");
//		System.out.println("\t\tweather:  " +weather);
		
	
		//fetch humidity
		long humidity =(long) weather.get("humidity");
		if(humidity>=90)
			System.out.println("\t\tHumidity: "+humidity+"%"+"\tChances of Rain : HIGH  ");
		else if(humidity>80 && humidity<90)
			System.out.println("\t\tHumidity: "+humidity+"%"+"\tChances of Rain : MEDIUM  ");
		else
			System.out.println("\t\tHumidity: "+humidity+"%"+"\tChances of Rain : LOW  ");

	}*/

}
