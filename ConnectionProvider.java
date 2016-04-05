package com.admin.login.invoice;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionProvider {
	static Properties prop;
	static{
		prop = new Properties();
		try{
			/*InputStream in = ConnectionProvider.class.getResourceAsStream("/connection/db.properties");*/
			prop.load(new FileInputStream("connection/db.properties"));
			
		}
		catch(Exception ex){
			System.out.println("connection provider error........     "+ex);
		}
		
	}

	public static Connection getConnection() throws Exception
	{
	Class.forName(prop.getProperty("driverClass"));
	Connection con = DriverManager.getConnection(prop.getProperty("url"),
			prop.getProperty("user"),prop.getProperty("password"));
	return con;
	}

}
