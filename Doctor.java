package ConsoleApplication;

import java.util.Scanner;

public class Doctor {
	Operations op=new Operations();
	Scanner s=new Scanner(System.in);
Doctor(){
	PatientOperations.verify();
	doctormenu();
}
public void doctormenu() {
	System.out.println("\t****** Doctor's Menu ******");
	System.out
			.println("\n(1): Prescribe drugs to patient      \t(2): List Outpatient calls made by me \n"
					+  "(3): List drugs prescribed by me     \t(4): Exit");
					
	
	int doctorschoice=s.nextInt();
	int pid,did,dgid;
	String name,dgname;
	switch(doctorschoice){
	case 1:
		//query for insert drugs into drug table
		System.out.println("Enter your ID :");
		did=s.nextInt();
		System.out.println("Enter patient's ID :");
		pid=s.nextInt();
		System.out.println("Enter Drug ID :");
		dgid=s.nextInt();
		System.out.println("Enter Drug Name :");
		dgname=s.nextLine();
		DoctorOperations.insertdrug(did, pid, dgid, dgname);
		done();
	case 2:
		//query to show record from outpatienttable
		System.out.println("Enter your ID :");
		did=s.nextInt();
		DoctorOperations.showoutpatient(did);
		done();
	case 3:
		//query to show drugs record from drugtable
		System.out.println("Enter your ID :");
		did=s.nextInt();
		DoctorOperations.showdrugs(did);
		done();
	case 4:
		System.exit(0);
	}
}
public void done(){
	int ch;
	System.out.println("\n\nDone!\n(1): Logout\t(2): Menu");
	ch=s.nextInt();
	if(ch==1){new MainMenu();}
	else doctormenu();
}
}