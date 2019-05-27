package edu.handong.analysis.utils;


import  java.util.ArrayList ;
import  edu.handong.analysis.utils.NotEnoughArgumentException ;
import  java.io. * ;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {

	public static ArrayList<String> getLines(String file, boolean removeHeader)
	{
		
		ArrayList<String> string = new ArrayList<String>();
		String n;
		try {
			BufferedReader scan = new BufferedReader(new FileReader(file));
			if(removeHeader)
			{
				scan.readLine();
			}
			while ((n = scan.readLine()) != null)
			{
				string.add(n);
			}
			scan.close();
	}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		
		return string;
				 
	}
	public static void writeAFile(ArrayList<String> lines, String targetFileName) 
	{
		
		File file = new File(targetFileName);
		
		if(!file.exists())
		{
			try 
		{
			file.mkdirs();
		}
	
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		File file2= new File(targetFileName);
		try {

			
		
			
			
			PrintWriter scanw = new PrintWriter(new FileWriter(file));
		
			file2.createNewFile();
			
			
			scanw.println("StudentID, TotalNumberOfSemestersRegistered, Semester, NumCoursesTakenInTheSemester");
			for (String str : lines)
				scanw.println(str);
			scanw.close();
			}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	
	}
}