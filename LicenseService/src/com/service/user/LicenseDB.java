package com.service.user;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class LicenseDB {

	ResultSet rs;
	/**
	* get the license information from the database for given user
	* @in param uname User name of the information is requested
	* @out param returns license object
	*/ License getLicenseByUser(String uname) {
		License license = new License();

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String connString = "jdbc:mysql://localhost:3306/licensemanagerdb";
			Connection myConn = DriverManager.getConnection(connString, "root", "password"); // establish
																								// connection

			Statement sqlStatement = myConn.createStatement(); // create
																// statement
			String booleanString = "SELECT * FROM license Where user_name='" + uname + "'";
			ResultSet rs1 = sqlStatement.executeQuery(booleanString);

			while (rs1.next()) {
				
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				String date = df.format(rs1.getDate("expiry"));

				license.setUname(uname);
				license.setLicenseKey(rs1.getString("l_key"));
				license.setLicenseType(rs1.getString("l_type"));
				license.setExpiryDate(date);
				license.setBlade(rs1.getString("blade"));
				license.setOptional_list(rs1.getString("optional_list"));
				license.setSeats(rs1.getInt("seats"));
				license.setStatueMessage("success: Retrived the user license information for the user '" + uname + "'");
		
			}

		} catch (Exception e) {
			e.printStackTrace();
			license.setUname(uname);
			license.setLicenseKey("no match found");
			license.setStatueMessage(
					"error: Database error while retriveing the user license information for the user '" + uname + "'");
		}
		return license;
	}

	public License createLicenseByUser(String uname) {
		License license = new License();
		try {
			// DB connection
			Class.forName("com.mysql.jdbc.Driver");
			String connString = "jdbc:mysql://localhost:3306/licensemanagerdb";
			Connection myConn = DriverManager.getConnection(connString, "root", "password");
			String query = " insert into license (user_name, l_key, l_type, expiry, blade, optional_list ,seats )"
					+ " values (?, ?, ?, ?, ? ,? ,?)";
			// date field
			java.util.Date utilDate = new java.util.Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(utilDate);
			calendar.add(Calendar.YEAR, 4);// add 4 years from current
			utilDate = calendar.getTime();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			// convert to String
			String type = "BASIS";
			LicenseKeyGenerator lkg = new LicenseKeyGenerator();
			String l_key = lkg.generateRandomString();
			PreparedStatement pstm = myConn.prepareStatement(query);
			pstm.setString(1, uname);
			pstm.setString(2, l_key);
			pstm.setString(3, type);
			pstm.setDate(4, sqlDate);
			pstm.setString(5, "TestBlade");
			pstm.setString(6, "TestOptional_list");
			pstm.setInt(7, 0);

			pstm.execute();
			// to return license object
			license.setUname(uname);
			license.setLicenseKey(l_key);
			license.setLicenseType(type);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			String date = df.format(sqlDate);
			license.setExpiryDate(date);

			license.setBlade("TestBlade");
			license.setOptional_list("TestOptional_list");
			license.setSeats(0);
			license.setStatueMessage("success: Created the user license for the user '" + uname + "'");
		} catch (MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			license.setUname(uname);
			license.setLicenseKey("no match found");
			license.setStatueMessage("error: Already the '" + uname + "' has license,");
		} catch (Exception e) {
			e.printStackTrace();
			license.setUname(uname);
			license.setLicenseKey("0");
			license.setStatueMessage("error: Database error while creating the user license.");
		}
		return license;
	}

	public String removeLicenseByUser(String uname) throws SQLException, ClassNotFoundException {

		String retVal = "success: removed the user license";
		try {

			Class.forName("com.mysql.jdbc.Driver"); // load the driver
			String connString = "jdbc:mysql://localhost:3306/licensemanagerdb";
			Connection myConn = DriverManager.getConnection(connString, "root", "password"); // establish
																								// connection
			Statement sqlStatement = myConn.createStatement(); // create
																// statement
			String queryString = ""; // query
			String booleanString = "SELECT COUNT(user_name) FROM license Where user_name='" + uname + "'";

			sqlStatement.execute(booleanString);
			ResultSet resultSet = sqlStatement.getResultSet(); // result set for
																// records
			boolean recordFound = false;

			while (resultSet.next()) {
				if (resultSet.getInt(1) != 0) {
					recordFound = true;
				}
			}

			if (recordFound) {
				queryString = "DELETE FROM license WHERE user_name = '" + uname + "'";
				sqlStatement.execute(queryString);
				sqlStatement.close();
				myConn.close();

			} // ends if statement
			else {
				retVal = "error: user license is not removed, there is no matching record.";
			}
		} // ends try block
		catch (Exception e) {
			e.printStackTrace();
			retVal = "db_error: user license is not removed";
		}
		return retVal;
	} // ends remove() method

	public License updateLicenseByUser(String uname) {
		License license = new License();
		try {

			Class.forName("com.mysql.jdbc.Driver"); // load the driver
			String connString = "jdbc:mysql://localhost:3306/licensemanagerdb";
			Connection myConn = DriverManager.getConnection(connString, "root", "password"); // establish
																								// connection
			Statement sqlStatement = myConn.createStatement(); // create
																// statement
			String queryString = ""; // query
			String booleanString = "SELECT COUNT(user_name) FROM license Where user_name='" + uname + "'";

			sqlStatement.execute(booleanString);
			ResultSet resultSet = sqlStatement.getResultSet(); // result set for
																// records
			boolean recordFound = false;

			while (resultSet.next()) {
				if (resultSet.getInt(1) != 0) {
					recordFound = true;
				}
			}

			if (recordFound) {
				// convert to String
				String type = "BASIS";
				String blade = "testBlade";
				String optional_list = "Option list";
				int seats = 0;
				LicenseKeyGenerator lkg = new LicenseKeyGenerator();
				String l_key = lkg.generateRandomString();
				java.util.Date utilDate = new java.util.Date();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(utilDate);
				calendar.add(Calendar.YEAR, 2);// add 4 years from current
				utilDate = calendar.getTime();
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				queryString = "UPDATE license SET l_key = '" + l_key + "', l_type = '" + type + "', expiry ='" + sqlDate
						+ "', blade = '" + blade + "',  optional_list = '" + optional_list + "', seats ='" + seats
						+ "' WHERE user_name='" + uname + "'";

				sqlStatement.execute(queryString);
				resultSet = sqlStatement.getResultSet();
				license.setUname(uname);
				license.setLicenseKey(l_key);
				license.setLicenseType(type);
				license.setExpiryDate(sqlDate);
				license.setBlade(blade);
				license.setOptional_list(optional_list);
				license.setSeats(seats);
				license.setStatueMessage("Success: The User License is updated for the user '" + uname + "'");

				sqlStatement.close();
				myConn.close();

			} // ends if statement
			else {
				license.setStatueMessage("ERROR: user license is failed to update");
			}
		} // ends try block
		catch (Exception e) {
			e.printStackTrace();
			license.setStatueMessage("db_error: user license is failed to update");
		}
		return license;
	} // ends method
}