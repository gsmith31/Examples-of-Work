package edu.elon.nutrigen.data;

import java.sql.*;

import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.google.appengine.api.utils.SystemProperty;

public class ConnectionPool {

	private static ConnectionPool pool = null;
	private static final String GOOGLE_MYSQL = "jdbc:google:mysql://elonunc:nutrition/guestbook?user=root";
	private static final String LOCAL_MYSQL = "jdbc:mysql://127.0.0.1:3306/guestbook";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "mysqluser";

	public static Connection getConnection() {
		String url = null;
		Connection conn = null;
		try {
			if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
				// Load the class that provides the new "jdbc:google:mysql://"
				// prefix.

				Class.forName("com.mysql.jdbc.GoogleDriver");

				System.out
						.println("From JSP on Google  - using production version");
				url = GOOGLE_MYSQL;
				conn = DriverManager.getConnection(url);
			} else {
				// Local MySQL instance to use during development.
				Class.forName("com.mysql.jdbc.Driver");
				System.out
						.println("From JSP on Local machine  - using development version");
				url = LOCAL_MYSQL;
				conn = DriverManager.getConnection(url, USERNAME, PASSWORD);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}

	public static void freeConnection(Connection c) {
		try {
			c.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}