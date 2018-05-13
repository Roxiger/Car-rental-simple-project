import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DBConnection {
	
	static Connection conn = null;
	
	static Connection getConnection() {
		
		String JDBC = "jdbc:mysql://localhost/car_rental";
		String login = "root";
		String password = "";
		String driver = "java.sql.Driver";
		
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(JDBC,login,password);
			
			//System.out.println("Connected!"); 
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
//			System.out.println("Error!");
			
			JOptionPane.showMessageDialog(null, "Error!");
			
		} catch(SQLException e) {
			e.printStackTrace();
//			System.out.println("Error!");
			
			JOptionPane.showMessageDialog(null, "Error!");
		} finally {
			return conn;
		}
		
	}
}
