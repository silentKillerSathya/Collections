package sms;


public class Submission {
  String submissionDate;
  String submissionText;
  Student forWhichStudentSubmitThis;
  Assignments forWhichAssignment;
  static String[] ass = {};
  
  Submission(String submissionDate, String submissionText, Student forWhichStudentSubmitThis, Assignments forWhichAssignment){
	  this.submissionDate = submissionDate;
	  this.submissionText = submissionText;
	  this.forWhichStudentSubmitThis = forWhichStudentSubmitThis;
	  this.forWhichAssignment = forWhichAssignment;
  }
public String getSubmissionDate() {
	return submissionDate;
}

public String getSubmissionText() {
	return submissionText;
}

public Student getForWhichStudentSubmitthis() {
	return forWhichStudentSubmitThis;
}

public Assignments getForWhichAssignment() {
	return forWhichAssignment;
}
  
}
