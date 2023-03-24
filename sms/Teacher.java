package sms;
import linkedList.LinkedList;

public class Teacher {
  String teacherEmailId;
  String teacherName;
  String department;
  int yearsOfExperience;
  String[] subjectsHandled; 
  LinkedList<String[]> totalAssignments;
  int lengthOfTheAssList;
  
  
  Teacher(String teacherEmailId, String teacherName, String department, int yearsOfExperience, String[] subjectsHandled, LinkedList<String[]> totalAssignments) {
	  this.teacherEmailId = teacherEmailId;
	  this.teacherName = teacherName;
	  this.department = department;
	  this.yearsOfExperience = yearsOfExperience;
	  this.subjectsHandled = subjectsHandled;
	  this.totalAssignments = totalAssignments;	 
  }
  
public LinkedList<String[]> getTotalAssignments() {
	return totalAssignments;
}

public void setTotalAssignments(LinkedList<String[]> totalAssignments) {
	this.totalAssignments = totalAssignments;
  }

public String getTeacherEmailId() {
	return teacherEmailId;
}

public String getTeacherName() {
	return teacherName;
}

public String getDepartment() {
	return department;
}

public int getYearsOfExperience() {
	return yearsOfExperience;
}

public String[] getSubjectsHandled() {
	return subjectsHandled;
}

public int getLengthOfTheAssList() {
	return lengthOfTheAssList;
}

public void setLengthOfTheAssList(int lengthOfTheAssList) {
	this.lengthOfTheAssList = lengthOfTheAssList;
}

public void markAttendance(String atnd, String className, Student stud, Teacher teach) {	
	Attendance todayAttendance = new Attendance(atnd, className, stud, this);
}

public void giveAssignment(String desc, String subj, Teacher teach, Student[] forWhichStudents) {
	Assignments assignment = new Assignments(desc, subj, this, forWhichStudents);
}

}
