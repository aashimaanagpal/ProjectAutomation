package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "admin", "Admin@123");
		
		Statement stmt = con.createStatement();
		
		ResultSet result = stmt.executeQuery("select * from eproduct;");
		
		while (result.next()) {

			System.out.println("Product Id " + result.getInt("ID"));
			System.out.println("Product name " + result.getString("name"));
			System.out.println("Price " + result.getDouble("Price"));
		}
		
		stmt.executeUpdate("insert into eproduct (name, price, date_added) values ('Television', 15000.00, now())");
		
		result = stmt.executeQuery("select * from eproduct;");
		
		while (result.next()) {

			System.out.println("Product Id " + result.getInt("ID"));
			System.out.println("Product name " + result.getString("name"));
			System.out.println("Price " + result.getDouble("Price"));
		}
		
		stmt.executeUpdate("delete from eproduct where id='3';");
		
		result = stmt.executeQuery("select * from eproduct;");
		while (result.next()) {

			System.out.println("Product Id " + result.getInt("ID"));
			System.out.println("Product name " + result.getString("name"));
			System.out.println("Price " + result.getDouble("Price"));
		}
		
		stmt.executeUpdate("update eproduct set price='20000' where id='4';");
		result = stmt.executeQuery("select * from eproduct;");
		while (result.next()) {

			System.out.println("Product Id " + result.getInt("ID"));
			System.out.println("Product name " + result.getString("name"));
			System.out.println("Price " + result.getDouble("Price"));
		}

		con.close();


	}

}
