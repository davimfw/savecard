package dao;

import java.sql.*;

public class DAO {
	protected Connection conn;
	
	public DAO() {
		this.conn = null;
	}
	
	public boolean databaseConnection() {
		String serverName = "localhost";
		String db = "save-card";
		int port = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + port + "/" + db;
		String username = "postgres";
		String password = "123";
		boolean status = false;
		
		try {
			this.conn = DriverManager.getConnection(url, username, password);
			if(this.conn != null) {
				System.out.println("Conectou");
				status = true;
			} else {
				System.out.println("Deu ruim");
			}
		} catch (SQLException err) {
			System.out.println("Deu ruim " + err.getMessage());
		}
		
		return status;
	}
	
	public boolean databaseConnectionClose() {
		boolean status = false;
		
		try {
			this.conn.close();
			status = true;
		} catch (SQLException e) {
			e.getMessage();
		}
		
		return status;
	}
}
