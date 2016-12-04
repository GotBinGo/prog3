import java.io.*;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.*;

public class Settings {
	private String filename = "settings.txt";
	private int maxtime = 10;
	
	public int getMaxtime()
	{
		return maxtime;
	}
	
	public void setMaxtime(int mt)
	{
		maxtime = mt;
	}
	
	public void readSettings() 
	{

		try
		{
			  Scanner linReader = new Scanner(new File(filename));

		        while (linReader.hasNext())
		        {
		            String line = linReader.nextLine();
		            String[] ws = line.split(";");
		            if(ws[0].equals("maxtime"))
		            	maxtime = Integer.parseInt(ws[1]);
		        }
		        linReader.close();
		}
		catch(Exception e)
		{
			System.out.println("settings read error - operating with default settings");
		}
	}
	
	public void writeSettings()
	{
		try
		{
			PrintWriter out = new PrintWriter(filename);

			out.println("maxtime;"+maxtime);
			
			out.close();
		}
		catch(Exception e)
		{
			System.out.println("settings read error - operating with default settings");
		}
	}
	
	
}
