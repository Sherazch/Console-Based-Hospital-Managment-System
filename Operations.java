package ConsoleApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JOptionPane;  // program uses JOptionPane

import com.mysql.jdbc.Statement;

public class Operations {

public static String crypto(String sen){
	String array=new StringBuffer(sen).reverse().toString();
	return array;
	
}
}
