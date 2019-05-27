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
		PrintWriter outputStream = null;
		String Name = targetFileName;
		try {
				File theDir = new File(Name);
				if (!theDir.getParentFile().exists()) {
					theDir.getParentFile().mkdirs();
				}
				outputStream = new PrintWriter(Name);
		}
	

		catch(FileNotFoundException e)
		{
			
			System.out.println(e.getMessage());
			System.exit(0);
		}
		for(String line : lines) {
			outputStream.println(line);
		}
		outputStream.close();
	}
	
}
