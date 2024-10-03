package payment_package;

import java.util.*;
import java.sql.*;

public class payDao {

	// Method to establish a database connection
	public static Connection getConnection() {
		Connection con = null;
		try {
			// Load the MySQL JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// Establish connection with the database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/video", "root", "nisal");
		} catch (Exception e) {
			// Print any exceptions that occur during the connection process
			System.out.println(e);
		}
		return con;
	}
	// Method to insert payment details into the database
	public static int save(pay e) {
		int status = 0;
		try {
			// Get a database connection
			Connection con = payDao.getConnection();
			
			// Prepare SQL statement for insertion
			PreparedStatement ps = con.prepareStatement(
					"insert into payment(name,email,amount,cardname,cardnumber,expmonth,expyear,cvv) values (?,?,?,?,?,?,?,?)");
			// Set values for placeholders in the SQL statement
			ps.setString(1, e.getName());
			ps.setString(2, e.getEmail());
			ps.setString(3, e.getAmount());
			ps.setString(4, e.getCardname());
			ps.setString(5, e.getCardnumber());
			ps.setString(6, e.getExpmonth());
			ps.setString(7, e.getExpyear());
			ps.setString(8, e.getCvv());

			 // Execute the SQL statement
			status = ps.executeUpdate();
			
			// Close the database connection
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	// Method to update payment details in the database
	public static int update(pay e) {
		int status = 0;
		try {
			// Get a database connection
			Connection con = payDao.getConnection();
			// Prepare SQL statement for updating records
			PreparedStatement ps = con.prepareStatement(
					"update payment set name=?,email=?,amount=?,cardname=?,cardnumber=?,expmonth=?,expyear=?,cvv=? where id=?");
			
			// Set values for placeholders in the SQL statement
			ps.setString(1, e.getName());
			ps.setString(2, e.getEmail());
			ps.setString(3, e.getAmount());
			ps.setString(4, e.getCardname());
			ps.setString(5, e.getCardnumber());
			ps.setString(6, e.getExpmonth());
			ps.setString(7, e.getExpyear());
			ps.setString(8, e.getCvv());
			ps.setInt(9, e.getId());

			// Execute the SQL statement
			status = ps.executeUpdate();
			
			// Close the database connection
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}
	
	
	// Method to delete payment details from the database
	public static int delete(int id) {
		int status = 0;
		try {
			// Get a database connection
			Connection con = payDao.getConnection();
			
			// Prepare SQL statement for deleting records
			PreparedStatement ps = con.prepareStatement("delete from payment where id=?");
			// Set value for the placeholder in the SQL statement
			ps.setInt(1, id);
			// Execute the SQL statement
			status = ps.executeUpdate();
			
			// Close the database connection
			con.close();
		} catch (Exception e) {
			
			// Print any exceptions that occur during the process
			e.printStackTrace();
		}

		return status;
	}
	
	
	// Method to retrieve payment details by ID from the database
	public static pay getpaymentById(int id) {
		pay e = new pay();

		try {
			// Get a database connection
			Connection con = payDao.getConnection();
			// Prepare SQL statement for retrieving records by ID
			PreparedStatement ps = con.prepareStatement("select * from payment where id=?");
			// Set value for the placeholder in the SQL statement
			ps.setInt(1, id);
			// Execute the SQL statement
			ResultSet rs = ps.executeQuery();
			 // If records are found, set values for the payment object
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setAmount(rs.getString(4));
				e.setCardname(rs.getString(5));
				e.setCardnumber(rs.getString(6));
				e.setExpmonth(rs.getString(7));
				e.setExpyear(rs.getString(8));
				e.setCvv(rs.getString(9));
			}
			// Close the database connection
			con.close();
		} catch (Exception ex) {
			// Print any exceptions that occur during the process
			ex.printStackTrace();
		}

		return e;
	}
	
	// Method to retrieve all payment details from the database
	public static List<pay> getAllpayment() {
		List<pay> list = new ArrayList<pay>();

		try {
			// Get a database connection
			Connection con = payDao.getConnection();
			// Prepare SQL statement for retrieving all records
			PreparedStatement ps = con.prepareStatement("select * from payment");
			// Execute the SQL statement
			ResultSet rs = ps.executeQuery();
			 // Iterate through the result set and add payment objects to the list
			while (rs.next()) {
				pay e = new pay();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setAmount(rs.getString(4));
				e.setCardname(rs.getString(5));
				e.setCardnumber(rs.getString(6));
				e.setExpmonth(rs.getString(7));
				e.setExpyear(rs.getString(8));
				e.setCvv(rs.getString(9));
				list.add(e);
			}
			 // Close the database connection
			con.close();
		} catch (Exception e) {
			// Print any exceptions
			e.printStackTrace();
		}

		return list;
	}
}