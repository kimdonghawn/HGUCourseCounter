package edu.handong.analysis.datamodel;

import java.util.ArrayList;
import java.util.HashMap;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.utils.*;

public class Student 
{
	
	private String studentId;
	private ArrayList<Course> coursesTaken; // ÇÐ»ý ¼ö¾÷¸ñ·Ï
	private HashMap<String,Integer> semestersByYearAndSemester; 
	                                                         // key: Year-Semester
	                                                       
	public Student(String studentId) 
	{
		this.studentId = studentId;
		this.coursesTaken = new ArrayList<Course>();
		this.semestersByYearAndSemester = new HashMap<String,Integer>();
	}

	public void addCourse(Course newRecord)
	{
		
		coursesTaken.add(newRecord);
		
	}
	
	
	//
	
	public HashMap<String,Integer> getSemestersByYearAndSemester()
	{
		int check=1;
		
		for(Course co: coursesTaken)
		{
				String Cos =co.getYearTaken() + "-"+ co.getSemesterCourseTaken();
				if(semestersByYearAndSemester.containsKey(Cos)) 
				{
					continue;
				}
				else 
				{
					semestersByYearAndSemester.put(Cos, check++);
				}
				
		}
		return this.semestersByYearAndSemester;
	}
	
	//
	public int getNumCourseInNthSementer(int semester) 
	{

		
		int count=0;
		
		String YSemester= new String();
		for(String key : semestersByYearAndSemester.keySet()) {
			if(semestersByYearAndSemester.get(key) == semester) {
				YSemester = key;
			}
				
		}
		for(Course cou : coursesTaken) {
			String St = new String();
			St =cou.getYearTaken() + "-" + cou.getSemesterCourseTaken();
			if(St.equals(YSemester)) {
				count ++;
			}
		}
		
		return count;
	}
		
		
		
	
	//

	public String getStudentId() 
	{
		return this.studentId;
	}
	
	public void setStudentId(String student_Id) 
	{
		this.studentId = student_Id;
	}
	


	
}
