package com.ithc.util;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
/**
 *   ―
 *   ☆
 *   €
 *   ◎
 * @author Administrator
 */
public class DBUtils {
	static Connection conn;
	static String url;
	static String driver;
	static String user;
	static String password;
	static{	
		InputStream is = DBUtils.class.getResourceAsStream("/db.properties");
		Properties ps = new Properties();
		try {
			ps.load(is);
			url = ps.getProperty("url");
			driver = ps.getProperty("driver");
			user = ps.getProperty("user");
			password = ps.getProperty("password");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConn(){
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
