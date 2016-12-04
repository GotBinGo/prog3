
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.*;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.*;
public class Toplist {
	private ArrayList<ScoreRecord> arr;
	private String filename = "toplist.txt";
	
	public void addRecord(ScoreRecord s)
	{
		arr.add(s);
	}
	
	public ArrayList<ScoreRecord> getArray()
	{
		ArrayList<ScoreRecord>arrayB = new ArrayList<ScoreRecord>();
		arrayB.addAll(arr);
		return arrayB;
	}
	
	public void readList() 
	{
		arr = new ArrayList<ScoreRecord>();
		try
		{
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(filename));
			JSONArray list = (JSONArray)obj;
			Iterator<String> iterator = list.iterator();
			while (iterator.hasNext()) {
				String line = iterator.next();
				String[] ws = line.split(";");
	            arr.add(new ScoreRecord(ws[0],Integer.parseInt(ws[1]),Long.parseLong(ws[2])));
			}
			/*
			  Scanner linReader = new Scanner(new File(filename));

		        while (linReader.hasNext())
		        {
		            String line = linReader.nextLine();
		            String[] ws = line.split(";");
		            (new ScoreRecord(ws[0],Integer.parseInt(ws[1]),Long.parseLong(ws[2])));
		        }
		        linReader.close();
		        */
		}
		catch(Exception e)
		{
			System.out.println("toplist read error - operating with empty list");
		}
	}
	
	public void writeList()
	{
		try
		{
			FileWriter file = new FileWriter(filename);
			JSONArray list = new JSONArray();
			for(ScoreRecord a : arr)
			{
				list.add(a.toString(";"));
			}
			
			file.write(list.toJSONString());
			file.flush();
			file.close();
			/*
			PrintWriter out = new PrintWriter(filename);
			for(ScoreRecord a : arr)
			{
				out.println(a.toString(";"));
			}
			out.close();
			*/
		}
		catch(Exception e)
		{
			System.out.println("toplist read error - operating with empty list");
		}
	}
	
	
	
}
