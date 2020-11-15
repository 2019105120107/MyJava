package cn.lhz.jsj.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBHelper {
	private String driver="com.mysql.cj.jdbc.Driver";
	private Connection connection=null;
	private Statement stmt=null;
	private ResultSet rs =null;
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public Statement getStmt() {
		return stmt;
	}
	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	public boolean createConn() {
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookcity?"
					+ "user=root&password=LHZ521...&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false");
			return true;
		}catch(Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
	public boolean update(String sql) {
		
		try {
			stmt=connection.createStatement();
			stmt.execute(sql);
		
			return true;
		}catch(Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
	
	public void query(String sql) {
		try {
			stmt=connection.createStatement();
			rs = stmt.executeQuery(sql);
			
		}catch(Exception ex) {
			
		}
	}
	public boolean next() {
		try {
			if(rs.next()) {
				return true;
			}
			return false;
		}catch(Exception ex) {
			return false;
		}
	}
	public void closeRs() {
		
		try {
			if(rs!=null) {
				rs.close();
			}
			
		}catch(Exception ex) {
			
		}
	}
	public void closeStmt() {
		
		try {
			if(stmt!=null) {
				stmt.close();
			}
			
		}catch(Exception ex) {
			
		}
	}
	public void closeConn() {
	
	try {
		if(connection!=null) {
			connection.close();
		}
		
	}catch(Exception ex) {
		
	}
}
}
