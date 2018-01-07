package ConsoleApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class DoctorOperations {
	DoctorOperations(){}
	//For Case 1:
	public static void insertdrug(int a,int b,int c,String d){
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
			st.executeUpdate("INSERT INTO drugtable(Dg_ID,Name,DID,PID)"
	                + " Values (" + c + ",'" + d + "','" + a + "','" + b + "')");
			con.close();
		} catch (Exception e) {
			System.out.println("ERROR(1) :: " + e.getMessage());
		}
	}
	//For Case 2:
	public static void showoutpatient(int a){
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
			String sql = "select * from outpatienttable where DID="+a+"";
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
	//For Case 3:
	public static void showdrugs(int a){
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
			String sql = "select * from drugtable where DID="+a+"";
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

}
