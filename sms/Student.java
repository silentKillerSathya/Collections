package sms;
import linkedList.*;

public class Student {
  String studentName;
  int studentId;
  String school;
  String classRoomName;
  LinkedList<String[]> assignmentList;
  LinkedList<String[]> submittedAss;
  int length;
  int submittedLength;
  
  Student(String studentName, int studentId, String school, String classRoomName, LinkedList<String[]> assignmentList, LinkedList<String[]> submittedAss) {
	  this.studentName = studentName;
	  this.studentId = studentId;
	  this.school = school;
	  this.classRoomName = classRoomName;
	  this.assignmentList = assignmentList;
	  this.submittedAss = submittedAss;
  }
  
public String getStudentName() {
	return studentName;
}

public int getStudentId() {
	return studentId;
}

public LinkedList<String[]> getAssignmentList() {
	return assignmentList;
}

public void setAssignmentList(LinkedList<String[]> assignmentList) {
	this.assignmentList = assignmentList;
}

public LinkedList<String[]> getSubmittedAss(){
	return submittedAss;
}

public void setSubmittedAss(LinkedList<String[]> submittedAss) {
	this.submittedAss = submittedAss;
}

public String getSchool() {
	return school;
}

public String getClassName() {
	return classRoomName;
}

public int getLength() {
	return length;
}

public void setLength(int length) {
	this.length = length;
}

public int getSubmittedLength() {
	return submittedLength;
}

public void setSubmittedLength(int submittedLength) {
	this.submittedLength = submittedLength;
}

}
