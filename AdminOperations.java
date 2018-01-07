package ConsoleApplication;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class AdminOperations {
	AdminOperations(){}
	//For Case 1:
	public static void displayall() {
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
			String sql = "select* from doctortable";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println("\n" + rs.getString(1) + "\t"
						+ rs.getString(2) + "\t" + rs.getString(3) + "\t"
						+ rs.getString(4) + "\t" + rs.getString(5));
			}
			con.close();
		} catch (Exception e) {
			System.out.println("ERROR(1) :: " + e.getMessage());
		}

	}
//For Case 2:
	public static void displayallwaiting(){
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
			String sql = "select* from surgicalwaitinglist";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println("\n" + rs.getString(1));
			}
			con.close();
		} catch (Exception e) {
			System.out.println("ERROR(1) :: " + e.getMessage());
		}
	}
	//FOR Case 6:
	public static void deletedoc(int a){
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
			st.executeUpdate("DELETE * FROM doctortable" +" Where DID = " + a
					+ ";");
			con.close();
		} catch (Exception e) {
			System.out.println("ERROR(1) :: " + e.getMessage());
		}
	}
	//FOR Case 7:
	public static void deletepatient(int a){
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
			st.executeUpdate("DELETE * FROM patienttable" +" Where PID = " + a
					+ ";");
			con.close();
		} catch (Exception e) {
			System.out.println("ERROR(1) :: " + e.getMessage());
		}
	}
	//FOR Case 8:
	public static void updatesrghrs(int a){
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
			st.executeUpdate("UPDATE doctortable " + " SET Srg_hrs = "
					+ " Where DID = " + a
					+ ";");
			con.close();
		} catch (Exception e) {
			System.out.println("ERROR(1) :: " + e.getMessage());
		}
	}
	//FOR Case 9:
	public static void updateoncallhrs(int a){
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
			st.executeUpdate("UPDATE doctortable " + " SET Oncall_hrs = "
					+ " Where DID = " + a
					+ ";");
			con.close();
		} catch (Exception e) {
			System.out.println("ERROR(1) :: " + e.getMessage());
		}
	}	
	//FOR Case 10:
	public static void insertoutpatient(int a, int b, String c){
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
			st.executeUpdate("INSERT INTO outpatienttable(PID,DID,Date)"
	                + " Values (" + a + "," + b + ",'" + c + "')");
			con.close();
		} catch (Exception e) {
			System.out.println("ERROR(1) :: " + e.getMessage());
		}
	}
	//FOR Case 11:
	public static void adddoctor(int a, String b, String c, int d, int e){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		} catch (Exception e1) {
			System.out.println("ERROR :: " + e1.getMessage());
		}

		try {
			String host = "jdbc:mysql://localhost/surgerydatabase";
			String username = "root";
			String password = "";
			Connection con = DriverManager.getConnection(host, username,password);
			Statement st =con.createStatement();
			System.out.println("yahoo!");
			st.executeUpdate("INSERT INTO doctortable(DID,Name,Address,Srg_hrs,Oncall_hrs)"
	                + " VALUES(" + a + ",'" + b + "','" + c + "'," + d + "," + e + ")");

			con.close();
		} catch (Exception i) {
			System.out.println("ERROR(1) :: " + i.getMessage());
		}
	}
	//For Case 12:
	public static void addpatient(int a, String b, String c, String d){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		} catch (Exception e1) {
			System.out.println("ERROR :: " + e1.getMessage());
		}

		try {
			String host = "jdbc:mysql://localhost/surgerydatabase";
			String username = "root";
			String password = "";
			Connection con = DriverManager.getConnection(host, username,password);
			Statement st = (Statement) con.createStatement();
			st.executeUpdate("INSERT INTO patienttable(PID,Name,Address,Doc_Choice)"
	                + " Values (" + a + ",'" + b + "','" + c + "','" + d + "')");
			con.close();
		} catch (Exception i) {
			System.out.println("ERROR(1) :: " + i.getMessage());
		}
	}
	// FOR Password storage
	public static void store(int a,String b){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		} catch (Exception e1) {
			System.out.println("ERROR :: " + e1.getMessage());
		}

		try {
			String host = "jdbc:mysql://localhost/surgerydatabase";
			String username = "root";
			String password = "";
			Connection con = DriverManager.getConnection(host, username,password);
			Statement st = (Statement) con.createStatement();
			st.executeUpdate("INSERT INTO credentials(UID,Password)"
	                + " Values (" + a + ",'" + Operations.crypto(b) + "')");
			con.close();
		} catch (Exception i) {
			System.out.println("ERROR(1) :: " + i.getMessage());
		}
	}
}
