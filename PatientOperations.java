package ConsoleApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class PatientOperations {
	public static Scanner s=new Scanner(System.in);
	PatientOperations() {
	}

	// For Case 1:
	public static void insertwaiting(int a) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (Exception e) {
			System.out.println("ERROR :: " + e.getMessage());
		}

		try {
			String host = "jdbc:mysql://localhost/surgerydatabase";
			String username = "root";
			String password = "";
			Connection con = DriverManager.getConnection(host, username,
					password);
			Statement st = (Statement) con.createStatement();
			st.executeUpdate("INSERT INTO surgicalwaitinglist(PID)"
					+ " Values (" + a + ")");
			con.close();
		} catch (Exception e) {
			System.out.println("ERROR(1) :: " + e.getMessage());
		}
	}

	// For Case 2:
	public static void insertoutpatientrequest(int a) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (Exception e) {
			System.out.println("ERROR :: " + e.getMessage());
		}

		try {
			String host = "jdbc:mysql://localhost/surgerydatabase";
			String username = "root";
			String password = "";
			Connection con = DriverManager.getConnection(host, username,
					password);
			Statement st = (Statement) con.createStatement();
			st.executeUpdate("INSERT INTO outpatientrequest(PID)" + " Values ("
					+ a + ")");
			con.close();
		} catch (Exception e) {
			System.out.println("ERROR(1) :: " + e.getMessage());
		}
	}

	// For Case 3:
	public static void updatedocchoice(int a, String b) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (Exception e) {
			System.out.println("ERROR :: " + e.getMessage());
		}

		try {
			String host = "jdbc:mysql://localhost/surgerydatabase";
			String username = "root";
			String password = "";
			Connection con = DriverManager.getConnection(host, username,
					password);
			Statement st = (Statement) con.createStatement();
			st.executeUpdate("UPDATE patienttable " + " SET Doc_Choice = "
					+ "'" + b + "'"+ " Where PID = " + a
					+ ";");
			con.close();
		} catch (Exception e) {
			System.out.println("ERROR(1) :: " + e.getMessage());
		}
	}
	//For case 4:
	public static void showalloutpatients(int a){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		} catch (Exception e) {
			System.out.println("ERROR :: " + e.getMessage());
		}

		try {
			String host = "jdbc:mysql://localhost/surgerydatabase";
			String username = "root";
			String password = "";
			Connection con = DriverManager.getConnection(host, username,password);
			Statement st = (Statement) con.createStatement();
			String sql = "select * from outpatienttable where PID="+a+"";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println("\n" + rs.getString(1) + "\t"
						+ rs.getString(2) + "\t" + rs.getString(3));
			}
			con.close();
		} catch (Exception e) {
			System.out.println("ERROR(1) :: " + e.getMessage());
		}		
	}
	//For Case 5:
	public static void showdrugprescription(int a){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		} catch (Exception e) {
			System.out.println("ERROR :: " + e.getMessage());
		}

		try {
			String host = "jdbc:mysql://localhost/surgerydatabase";
			String username = "root";
			String password = "";
			Connection con = DriverManager.getConnection(host, username,password);
			Statement st = (Statement) con.createStatement();
			String sql = "select * from drugtable where PID="+a+"";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println("\n" + rs.getString(1) + "\t"
						+ rs.getString(2) + "\t" + rs.getString(3)+"\t"+rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println("ERROR(1) :: " + e.getMessage());
		}		
	}
//FOR Case 6:
	public static void showpreviousvisits(int a){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		} catch (Exception e) {
			System.out.println("ERROR :: " + e.getMessage());
		}

		try {
			String host = "jdbc:mysql://localhost/surgerydatabase";
			String username = "root";
			String password = "";
			Connection con = DriverManager.getConnection(host, username,password);
			Statement st = (Statement) con.createStatement();
			String sql = "select * from surgeryvisittable where PID="+a+"";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println("\n" + rs.getString(1) + "\t"
						+ rs.getString(2) + "\t" + rs.getString(3));
			}
			con.close();
		} catch (Exception e) {
			System.out.println("ERROR(1) :: " + e.getMessage());
		}		
	}
	//For validation
	public static void verify(){
		boolean tmp=false;
		String passcode,temp="";
		while(tmp==false){
			System.out.println("Enter User ID: ");
			int uid=s.nextInt();
			//
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			
			} catch (Exception e) {
				System.out.println("ERROR :: " + e.getMessage());
			}

			try {
				String host = "jdbc:mysql://localhost/surgerydatabase";
				String username = "root";
				String password = "";
				Connection con = DriverManager.getConnection(host, username,password);
				Statement st = (Statement) con.createStatement();
				String sql = "SELECT * FROM credentials WHERE UID="+uid;
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()){
				//System.out.println(rs.getString(1)+"\t"+rs.getString(2));
				temp=Operations.crypto(rs.getString(2));
				}
				System.out.println("Enter Password : ");
				passcode=s.next();
				//System.out.println(temp);
				if(temp.equals(passcode)){System.out.println("Login Successfully!");tmp=true;}
				else System.out.println("Please Enter correct data");
				
				con.close();
			} catch (Exception e) {
				System.out.println("ERROR(1) :: " + e.getMessage()+"\nInValid Credentials!");
			}		
			
			//
		}
	}
}
