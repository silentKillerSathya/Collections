package sms;

public class Assignments {
	
  String assignmentDesc;
  String subject;
  Teacher whichFacultyGaveThisAssignment;
  Student[] theStudentsWhoGetThisAssignment;
  
  Assignments(String assignmentDesc, String subject, Teacher whichFacultyGaveThisAssignment, Student[] theStudentsWhoGetThisAssignment) {
	  this.assignmentDesc = assignmentDesc;
	  this.subject = subject;
	  this.whichFacultyGaveThisAssignment = whichFacultyGaveThisAssignment;
	  this.theStudentsWhoGetThisAssignment = theStudentsWhoGetThisAssignment;
  }
  
public String getAssignmentDesc() {
	return assignmentDesc;
}

public String getSubject() {
	return subject;
}

public Teacher getWhichFacultyGaveThisAssignment() {
	return whichFacultyGaveThisAssignment;
}

public Student[] getTheStudentsWhogetthisAssignment() {
	return theStudentsWhoGetThisAssignment;
}
  
}
