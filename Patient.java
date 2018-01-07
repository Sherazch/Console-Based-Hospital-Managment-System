package ConsoleApplication;

import java.util.Scanner;

public class Patient {
	
	public static Scanner s=new Scanner(System.in);
	public static boolean privacy=false;

	Patient() {
	//	Operations.verification();
		PatientOperations.verify();
	patientmenu();
	}

	public static void patientmenu() {
		System.out.println("\t****** Patient's Menu ******");
		System.out
				.println("\n(1): Add into Surgical waiting  \t(2): Request Outpatient call \n"
						+  "(3): Change choice doctor       \t(4): Show Outpatient calls      \n"
						+ " (5): Show drugs prescribtion    \t(6): Show previous visits       \n"
						+ " (7): Privacy settings           \t(8): Exit");
		
		int patientchoice=s.nextInt();
		int pid,did;
		String name,p;
		
		switch(patientchoice){
		case 1:
			//query to insert into surgicalwaitinglist table
			System.out.println("Enter your ID :");
			pid=s.nextInt();
			PatientOperations.insertwaiting(pid);
			done();
			
		case 2:
			//query to insert into outpatientrequest table
			System.out.println("Enter your ID :");
			pid=s.nextInt();
			PatientOperations.insertoutpatientrequest(pid);
			done();
			
		case 3:
			//query to update doctor choice in patienttable
			System.out.println("Enter your ID :");
			pid=s.nextInt();
			System.out.println("Enter doctor's name :");
			name=s.nextLine();
			PatientOperations.updatedocchoice(pid, name); 
			done();
			
		case 4:
			//query to show all outpatient calls in outpatienttable
			System.out.println("Enter your ID :");
			pid=s.nextInt();
			PatientOperations.showalloutpatients(pid);
			done();
			
		case 5:
			//query to show drugs prescription from drugtable
			System.out.println("Enter your ID :");
			pid=s.nextInt();
			PatientOperations.showdrugprescription(pid);
			done();
			
		case 6:
			//query to show previous visits from surgeryvisittable 
			System.out.println("Enter your ID :");
			pid=s.nextInt();
			PatientOperations.showpreviousvisits(pid);
			done();
		case 7:
			System.out.println("Do you want to allow admin to access your record? [y/n]");
			p=s.next();
			if(p.matches("n")){privacy=true;}
			else {privacy=false;}
			done();
			
		case 8:
			System.exit(0);
		}
		
	}
	public static void done(){
		int ch;
		System.out.println("Done!\n(1): Logout\t(2): Menu");
		ch=s.nextInt();
		if(ch==1){new MainMenu();}
		else patientmenu();
	}
}
