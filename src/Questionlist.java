import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Questionlist {
	private ArrayList<Question> arr;
	private String filename = "questionlist.txt";
	
	public ArrayList<Question> getArray()
	{
		ArrayList<Question>arrayB = new ArrayList<Question>();
		arrayB.addAll(arr);
		return arrayB;
	}
	
	public void readList() 
	{
		arr = new ArrayList<Question>();
		try
		{
			  Scanner linReader = new Scanner(new File(filename));

		        while (linReader.hasNext())
		        {
		            String line = linReader.nextLine();
		            String[] ws = line.split(";");
		            arr.add(new Question(ws[0],ws[1],ws[2],ws[3]));
		        }
		        linReader.close();
		}
		catch(Exception e)
		{
			System.out.println("questions read error - operating with empty list");
		}
	}
}
