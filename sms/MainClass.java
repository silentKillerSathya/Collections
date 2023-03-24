package sms;
import java.util.Arrays;
import java.text.*;
import java.util.Scanner;
import linkedList.*;

public class MainClass {
	
	static Student[] studentsList = new Student[10];
	static Teacher[] teachersList = new Teacher[2];
	
	public Student createAStudentObject(String sName, int sId, String scl, String classRoomName) {
		LinkedList<String[]> totalAss = new LinkedList<String[]>();
		LinkedList<String[]> submittedAssignments = new LinkedList<String[]>();
		Student studObj = new Student(sName, sId, scl, classRoomName, totalAss, submittedAssignments);
		return studObj;
	}
	
	public Teacher createATeacherObject(String teacherEmail, String tName, String dept, int experience, String[] subjHandled) {
		LinkedList<String[]> totalAssList = new LinkedList<String[]>();
		Teacher teacherObj = new Teacher(teacherEmail, tName, dept, experience, subjHandled, totalAssList);	
		return teacherObj;
	}
	
	public void createStudents() {
		
		Student esakki =  createAStudentObject("Esakkiammal", 293, "Tech", "Porunai");
		Student mani =  createAStudentObject("Manimegala", 333, "Tech", "Thamirabarani");
		Student kp =  createAStudentObject("Krishna Priya", 245, "Tech", "Thamirabarani");
		Student abitha = createAStudentObject("Abitha", 280, "Tech", "Porunai");
		Student deepi = createAStudentObject("Deepika", 273, "Tech", "Thamirabarani");
		Student tawfiq = createAStudentObject("Mohammed Tawfiq", 322, "Tech", "Porunai");
		Student akash = createAStudentObject("Akash", 218, "Tech", "Porunai");
		Student sakthi = createAStudentObject("Sakthi Mari", 319, "Tech", "Porunai");
		Student pn = createAStudentObject("Parvathi Nathan", 290, "Tech", "Thamirabarani");
		Student sameen = createAStudentObject("Sameen Sait", 336, "Tech", "Thamirabarani");
		
		studentsList[0] = esakki;
		studentsList[1] = mani;
		studentsList[2] = kp;
		studentsList[3] = abitha;
		studentsList[4] = deepi;
		studentsList[5] = tawfiq;
		studentsList[6] = akash;
		studentsList[7] = sakthi;
		studentsList[8] = pn;
		studentsList[9] = sameen;
	}
		
	public void createTeachers() {
		
		String[] santhiSanSubjects = {"scratch", "java", "maths"};
		String[] aarthiSanSubjects = {"java","javascript"};
		Teacher santhiSan =  createATeacherObject("santhi@zohocorp.com", "Santhi", "Testing", 10, santhiSanSubjects);
		Teacher aarthiSan =  createATeacherObject("aarthi@zohocorp.com", "Aarthi", "Backend", 8, aarthiSanSubjects);
		teachersList[0] = santhiSan;
		teachersList[1] = aarthiSan;
	}
	
	public static void main(String[] args) throws SMSException, ParseException{
		
		MainClass main = new MainClass();
		main.createStudents();
		main.createTeachers();
		
		Scanner sc = new Scanner(System.in);
		
		myloop:
		while(true) {
			
		System.out.println("Are you a teacher or a student?");
		System.out.println("Press (T) : Teacher");
		System.out.println("Press (S) : Student");
		String choice = sc.nextLine();
		
		if(choice.equalsIgnoreCase("T")) {
			
			Teacher loggedInTeacher = null;
			while(true) {
			System.out.print("Please enter your name: ");
			String nameOfATeacher = sc.nextLine();
			
			
			for(int i=0; i<teachersList.length; i++) {
				Teacher currTeacher = teachersList[i];
				if(currTeacher.getTeacherName().equalsIgnoreCase(nameOfATeacher)) {
					loggedInTeacher = currTeacher;
					break;
				}
			}
			try {
			if(loggedInTeacher == null) {
				throw new SMSException("Please enter a proper name for the teacher");
				
			}
			break;
			}
			catch(SMSException ex) {
				System.out.println(ex.getMessage());
				System.out.println();
				continue;
			}

			}
			
			
			while(true) {
				System.out.println();
			System.out.println("What would you like to do today?");
			System.out.println("Press (1) : 'MARK ATTENDANCE'");
			System.out.println("Press (2) : 'GAVE ASSIGNMENT'");
			System.out.println("Press (3) : 'SEE THE ASSIGNMENTS'");
			System.out.println("Press (4) : 'EXIT'");
			String work = sc.nextLine();
			
			
			switch(work) {
			 case "1":
				 Student attendanceForThisStudent = null;
				   while(true) {
				     System.out.print("Please enter the student name for mark attendance: ");
				     String studName = sc.nextLine();
				     
				     for(int i=0; i<studentsList.length; i++) {
						 Student currStudent = studentsList[i];
						 if(currStudent.getStudentName().equalsIgnoreCase(studName)) {
							 attendanceForThisStudent = currStudent;
							 break;
						 }
					 }
				     try {
					 if(attendanceForThisStudent == null) {
						 throw new SMSException("Please enter the proper name for the student!");
					 }
					 break;
				     }
				     catch(SMSException ex) {
				    	 System.out.println(ex.getMessage());
				    	 System.out.println();
				    	 continue;
				     }			 
				   }
			     System.out.print("Please enter a className: ");
				 String classname = sc.nextLine();
				
				 String atd = null;
				 while(true) {
		         System.out.print("Was the Student Present / Absent ? Press (P) for Present or Press (A) for Absent.");
				 String attend = sc.nextLine();  
				 
				 if(attend.equalsIgnoreCase("P")) {
					 atd = "PRESENT";
					 break;
				 }
				 else if(attend.equalsIgnoreCase("A")) {
					 atd = "ABSENT";
					 break;
				 }
				 else {
					 System.out.println("Your input is invalid. Please enter a proper input!");
					 System.out.println();
					 continue;
				 }
				 }			 
				 
				 loggedInTeacher.markAttendance(atd, classname, attendanceForThisStudent, loggedInTeacher);
				 System.out.println("Mark attendance successfully!");
				 System.out.println();
				 continue myloop;
				
			 case "2":
				 String[] assDetails = new String[4];
				 String sbj = null;
				 while(true) {
				 System.out.print("Please select the associated subject "+ Arrays.toString(loggedInTeacher.getSubjectsHandled())+ " :");
				 sbj = sc.nextLine();
				 boolean s = false;
				 for(int i=0; i<loggedInTeacher.getSubjectsHandled().length; i++) {
					 if(loggedInTeacher.getSubjectsHandled()[i].equalsIgnoreCase(sbj)) {
						 s = true;
					 }
				 }
				 try {
				 if(!s) {
					 throw new SMSException("Please enter a valid subject!");
				 }
				 break;
				 }
				 catch(SMSException ex) {
					 System.out.println(ex.getMessage());
					 System.out.println();
					 continue; 
				 }
				 }
				 String date = null;
				 while(true) {
				 System.out.print("Please enter the assignment date :");
				 String d = sc.nextLine();
				 try {
					 try {
						 SimpleDateFormat dd=new SimpleDateFormat("dd/MM/yyyy");
						 System.out.println(dd.format(dd.parse(d)));
						 date = dd.format(dd.parse(d));
						 }
						 catch(ParseException ex) {
							 throw new SMSException("Please Enter a Valid Date!");
						 }
				 }
				 catch(SMSException ex) {
					 System.out.println(ex.getMessage());
					 continue;
				 }
				 break;
				 }
				 assDetails[0] = date;
				 assDetails[1] = sbj;
				 System.out.print("Please enter the Assignment title : ");
				 String title = sc.nextLine();
				 assDetails[2] = title;
				 System.out.print("Please enter your Assignment description : ");
				 String descrptn = sc.nextLine();
				 assDetails[3] = descrptn;
				 LinkedList<String[]> t_assign = loggedInTeacher.getTotalAssignments();
				 t_assign.insertData(assDetails);
				 loggedInTeacher.setTotalAssignments(t_assign); 
				 int t_list_length = loggedInTeacher.getLengthOfTheAssList();
				 loggedInTeacher.setLengthOfTheAssList(t_list_length+1);
				 System.out.println();
				 Student[] studentsListForAssignment;
				 while(true) {
				 System.out.println("To which students would you like to assign this?");
				 String stdnts = sc.nextLine();
				 String[] studentsNameListForAssignment = stdnts.split(", ");
				 studentsListForAssignment = new Student[studentsNameListForAssignment.length];
				 int a = 0;
				 
				 try {
				 for(int i=0; i<studentsList.length; i++) {
					 for(int j=0; j<studentsNameListForAssignment.length; j++) {
						 if(studentsList[i].getStudentName().equalsIgnoreCase(studentsNameListForAssignment[j])) {
							 studentsListForAssignment[j] = studentsList[i];
							 a++;
							 String[] assDetls = new String[4];
							 assDetls[0] = date;
							 assDetls[1] = sbj;
							 assDetls[2] = title;
							 assDetls[3] = descrptn;
							 LinkedList<String[]> s_assign = studentsListForAssignment[j].getAssignmentList();
							 s_assign.insertData(assDetls);
							 studentsListForAssignment[j].setAssignmentList(s_assign);
							 int len = studentsListForAssignment[j].getLength();
							 studentsListForAssignment[j].setLength(len+1);
						 }
					 }
				 }
				 if(a != studentsNameListForAssignment.length) {
					 throw new SMSException("Please enter correct students name for gave assignment!");
				 }
				 break;
				 }
				 catch(SMSException ex) {
					 System.out.println(ex.getMessage());
					 continue;
				 }
				 }
				 loggedInTeacher.giveAssignment(descrptn, sbj, loggedInTeacher, studentsListForAssignment);
				 System.out.println("Gave assignment successfully!");
				 System.out.println();
				 continue myloop;
				
				 
			 case "3":	
				 if(loggedInTeacher.getLengthOfTheAssList() == 0) {
					 System.out.println("Sorry. No assignments here!");
					 System.out.println();
					 continue;
				 }
				 System.out.println();
				 for(int i=0; i<loggedInTeacher.getLengthOfTheAssList(); i++) {	
					 System.out.println("Assignment no "+(i+1));
						 System.out.println("Date        : " + loggedInTeacher.getTotalAssignments().getElement(i)[0]);
						 System.out.println("Subject     : " + loggedInTeacher.getTotalAssignments().getElement(i)[1]);
						 System.out.println("Title       : " + loggedInTeacher.getTotalAssignments().getElement(i)[2]);
						 System.out.println("Description : " + loggedInTeacher.getTotalAssignments().getElement(i)[3]);
						 System.out.println();
				 }
				 continue myloop;
				 
			 case "4":
				 continue myloop;
				 
			 default:
				System.out.println("Please enter a valid choice!");	
				System.out.println();
				continue;
			}
			
			}		
		}	
			
		 else if(choice.equalsIgnoreCase("S")) {
			Student currStdnt = null;
			while(true) {
			System.out.print("Please enter your name: ");
			String sName = sc.nextLine();
			for(int i=0; i<studentsList.length; i++) {
				if(studentsList[i].getStudentName().equalsIgnoreCase(sName)) {
					currStdnt = studentsList[i];
				}
			}
			try {
				if(currStdnt == null) {
					throw new SMSException("Please enter the proper name for the student");
				}
				break;
			}
			catch(SMSException ex) {
				System.out.println(ex.getMessage());
				System.out.println();
				continue;
			}
			}
			while(true) {
			System.out.println("What would you like to do?");
			System.out.println("Press (1) : 'SUBMIT YOUR ASSIGNMENT'");
			System.out.println("Press (2) : 'SEE THE PENDING ASSIGNMENTS'");
			System.out.println("Press (3) : 'SEE YOUR SUBMITTED ASSIGNMENTS'");
			System.out.println("Press (4) : 'EXIT'");
			String option = sc.nextLine();
			switch(option) {
			   case "1":
				    System.out.print("Please enter your submission date: ");
					String submitDate = sc.nextLine();
					String submittedDate = null;
					try {
						 SimpleDateFormat dd=new SimpleDateFormat("dd/MM/yyyy");
						 submittedDate = dd.format(dd.parse(submitDate));
						 }
						 catch(ParseException ex) {
							 throw new SMSException("Please Enter a Valid Date!");
						 }
				    if(currStdnt.getLength() == 0) {
					  System.out.println("Sorry. You have no pending assignments!");
					  continue;
					}
				   for(int i=0; i<currStdnt.getLength(); i++) {
					   System.out.println((i+1) +". "+ currStdnt.getAssignmentList().getElement(i)[2]);
				   }
				   while(true) {
				    System.out.print("Which assignment? (Please enter the title of your assignment in the given list) :");
					String assn = sc.nextLine();
					boolean correctTitle = false;
					for(int i=0; i<currStdnt.getLength(); i++) {
						if(assn.equalsIgnoreCase(currStdnt.getAssignmentList().getElement(i)[2])) {
							correctTitle = true;
							String[] submittedAssignment = currStdnt.getAssignmentList().getElement(i);
							LinkedList<String[]> submitted = currStdnt.getSubmittedAss();
							submittedAssignment[0] = submittedDate;
							submitted.insertData(submittedAssignment);						
							currStdnt.setSubmittedAss(submitted);
							int submLen = currStdnt.getSubmittedLength();
							currStdnt.setSubmittedLength(submLen+1);
							LinkedList<String[]> pendingAss = currStdnt.getAssignmentList();
							pendingAss.deleteElement(submittedAssignment);
							currStdnt.setAssignmentList(pendingAss);
							int currLen = currStdnt.getLength();
							currStdnt.setLength(currLen-1);
							break;
						}
					}
					try {
					if(!correctTitle) {
						throw new SMSException("Please enter a valid title for that assignment!");
					}
					break;
					}
					catch(SMSException ex) {
						System.out.println(ex.getMessage());
						System.out.println();
						continue;
					}
				   }
					System.out.print("Please enter your Submission text: ");
					String text = sc.nextLine();
					System.out.println();
					System.out.println("Succesfully assignment submitted!");
					System.out.println();
					break;
					
			   case "2":
				   if(currStdnt.getLength() == 0) {
					   System.out.println("Sorry. You have no pending Assignment!");
					   System.out.println();
					   continue;
				   }
				   for(int i=0; i<currStdnt.getLength(); i++) {
					   System.out.println("Assignment no "+ (i+1));
					   System.out.println("Date        : " + currStdnt.getAssignmentList().getElement(i)[0]);
					   System.out.println("Subject     : " + currStdnt.getAssignmentList().getElement(i)[1]);
					   System.out.println("Title       : " + currStdnt.getAssignmentList().getElement(i)[2]);
					   System.out.println("Description : " + currStdnt.getAssignmentList().getElement(i)[3]);
					   System.out.println();
				   }
				   break;
				   
			   case "3":
				   if(currStdnt.getSubmittedLength() == 0) {
					   System.out.println("Sorry. You have no submitted assignment!");
					   System.out.println();
					   continue;
				   }
				   for(int i=0; i<currStdnt.getSubmittedLength(); i++) {
					   System.out.println("Assignment no "+ (i+1));
					   System.out.println("Submission Date    : " + currStdnt.getAssignmentList().getElement(i)[0]);
					   System.out.println("Subject            : " + currStdnt.getAssignmentList().getElement(i)[1]);
					   System.out.println("Title              : " + currStdnt.getAssignmentList().getElement(i)[2]);
					   System.out.println("Description        : " + currStdnt.getAssignmentList().getElement(i)[3]);
				   }
				   System.out.println();
				   break;
				   
			   case "4":
				   System.out.println();
				   continue myloop;
				   
			   default:
				    System.out.println("Please enter a valid choice!");	
					System.out.println();
					continue;   
			}
			}
		 }
				
		else {
			System.out.println("Please enter a valid choice!");
			System.out.println();
			continue myloop;
		}
		
	  }
	}
}
	

	
