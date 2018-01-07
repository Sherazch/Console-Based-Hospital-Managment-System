package ConsoleApplication;

import java.util.Scanner;

public class MainMenu {
	public static Scanner s=new Scanner(System.in);
	public static int choice;
	MainMenu(){

		System.out.println("	****** Select from menu below : ******\n");
		System.out.println("(1): Patient\n(2): Doctor\n(3): Surgery Admin\n(4): Exit\n");
		choice=s.nextInt();
		switch(choice){
		case 1:
			new Patient();
		case 2:
			new Doctor();
		case 3:
			new SurgeryAdmin();
		case 4:
			System.exit(0);
		}
	}
		public static void main( String args[] ){	
		//new AccessConnection();
		new MainMenu();
		
	}
	
	
}
