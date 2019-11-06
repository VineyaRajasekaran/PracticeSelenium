package SeleniumLearn1;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.ResultSet;

import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class DataBaseConnectionTest {
	private static final Logger log = LogManager.getLogger(DataBaseConnectionTest.class.getName());
	
	@Test
	public void getDatafromDataBase() throws SQLException {

	String host="localhost";

	String port= "3306";

	Connection con=DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/credentials", "root", "root");

	Statement s=con.createStatement();

	ResultSet rs=s.executeQuery("select username , password from logincredentials where name='adam';");
	while(rs.next()) {
		log.debug(rs.getString("username"));
		log.debug(rs.getString("password"));
		
	}

	}
	

}
