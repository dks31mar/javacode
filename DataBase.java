package com.quote;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	Connection con;
    Statement stmnt1;
    ResultSet result;
    DataBase() throws SQLException{
    	connectdba();
        initial();
    }
	private void initial() {
		
		
		
	}
	private void connectdba() throws SQLException {
		
		
	}
	public static void main(String[] args) {
		

	}

}
