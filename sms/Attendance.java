package sms;
//import java.util.Date;

public class Attendance {
  String attendance;
  String className;
  Student forWhichStudent;
  Teacher markedByFaculty;
  
  public Attendance(String attendance, String className, Student stdnt, Teacher faculty) {
	  this.attendance = attendance;
	  this.className = className;
	  forWhichStudent = stdnt;
	  markedByFaculty = faculty;
	  
	  System.out.println();
	  System.out.println("Today's Attendance");
	  System.out.println();
	  System.out.println("Student Name: " + forWhichStudent.getStudentName());
	  System.out.println("        Date: " + java.time.LocalDate.now());
	  System.out.println("       Class: " + className);
	  System.out.println("  Attendance: " + attendance);
	  System.out.println("  Markded By: " + markedByFaculty.getTeacherName());
	  System.out.println();
  }

public String getAttendance() {
	return attendance;
}

public String getClassName() {
	return className;
}

public Student getForWhichStudent() {
	return forWhichStudent;
}

public Teacher getMarkedByFaculty() {
	return markedByFaculty;
}


}
