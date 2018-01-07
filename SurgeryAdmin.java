package ConsoleApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class SurgeryAdmin {
	Scanner s = new Scanner(System.in);

	SurgeryAdmin() {
		
		adminmenu();
	}

	public void adminmenu() {
		System.out.println("\t****** Admin's Menu ******");
		System.out
				.println("\n(1): List Doctors                      \t(2): List waiting patients \n"
						+ "(3):  List drugs prescribed by doctor   \t(4): List drugs prescribed to patient \n"
						+ "(5):  List Patient visit                \t(6): Delete Doctor   \n"
						+ "(7):  Delete Patient                    \t(8): Update surgery hours of doctor \n"
						+ "(9):  Update oncall hours of doctor     \t(10): Add visit to outpatient \n"
						+ "(11): Add Doctor                        \t(12): Add Patient \n"
						+ "(13): Exit");

		int adminchoice = s.nextInt();
		int pid, did, srg_hrs, oncall_hrs;
		String name, p, address, doc_choice,date,password,name1;

		switch (adminchoice) {
		case 1:
			// query to show all the doctors from doctortable
			AdminOperations.displayall();
			done();
		case 2:
			// query to show all patients from surgicalwaitinglist
			AdminOperations.displayallwaiting();
			done();
		case 3:
			// query to enlist drugs by a specific doctor from drugstable
			System.out.println("Enter doctor's ID :");
			did = s.nextInt();
			DoctorOperations.showdrugs(did);
			done();
		case 4:
			// query to enlist drugs for a specific patient
			if (Patient.privacy == false) {
				System.out.println("Enter Patient's ID :");
				pid = s.nextInt();
				PatientOperations.showdrugprescription(pid);
			} else {
				System.out.println(
						"You are not allowed to access this information"+
						"\nAccess Denied ");
			}
			done();
		case 5:
			// enlist patient visit from surgeryvisittable
			System.out.println("Enter Patient's ID :");
			pid = s.nextInt();
			PatientOperations.showpreviousvisits(pid);
			done();
		case 6:
			// Delete Doctor from doctors table
			System.out.println("Enter doctor's ID :");
			did = s.nextInt();
			AdminOperations.deletedoc(did);
			done();
		case 7:
			// Delete patient from patienttable
			System.out.println("Enter patient's ID :");
			pid = s.nextInt();
			AdminOperations.deletepatient(pid);
			done();
		case 8:
			// query to update surgery hours from doctortable
			System.out.println("Enter doctor's ID :");
			did = s.nextInt();
			AdminOperations.updatesrghrs(did);
			done();
		case 9:
			// query to update Oncall hours from doctortable
			System.out.println("Enter doctor's ID :");
			did = s.nextInt();
			AdminOperations.updateoncallhrs(did);
			done();
		case 10:
			// query to update patient's visit in outpatienttable
			System.out.println("Enter patient's ID :");
			pid = s.nextInt();
			System.out.println("Enter Doctor's ID :");
			did = s.nextInt();
			System.out.println("Enter Visiting Date : [2017-09-23]");
			date = s.nextLine();
			AdminOperations.insertoutpatient(pid, did, date);
			done();
		case 11:
			// query to add doctor into doctortable
			System.out.println("Enter doctor's ID:");
			did = s.nextInt();
			System.out.println("Enter doctor's Name:");
			name1 = s.next();
			System.out.println("Enter doctor's Address:");
			address = s.next();
			System.out.println("Enter doctor's surgery hours:");
			srg_hrs = s.nextInt();
			System.out.println("Enter doctor's Oncall hours:");
			oncall_hrs = s.nextInt();
			System.out.println("Set new Password :");
			password = s.next();
			AdminOperations.adddoctor(did, name1, address, srg_hrs, oncall_hrs);
			AdminOperations.store(did, password);
			done();
		case 12:
			// query to add patient into patienttable
			System.out.println("Enter patient's ID:");
			pid = s.nextInt();
			System.out.println("Enter patient's Name:");
			name = s.next();
			System.out.println("Enter patient's Address:");
			address = s.nextLine();
			System.out.println("Enter patient's Doctor-choice:");
			doc_choice = s.nextLine();
			System.out.println("Set new Password :");
			password = s.next();
			AdminOperations.addpatient(pid, name, address, doc_choice);
			AdminOperations.store(pid, password);
			done();
		case 13:
			System.exit(0);

		}
	}

	public void done() {
		int ch;
		System.out.println("Done!\n(1): Logout\t(2): Menu");
		ch = s.nextInt();
		if (ch == 1) {
			new MainMenu();
		} else
			adminmenu();
	}

	
}
