package it.polito.tdp.artsmia.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;


public class DBConnect {

	private static String jdbcURL = "jdbc:mysql://localhost/artsmia?user=root&password=root";

	private static HikariDataSource ds;

	public static Connection getConnection() {

		if (ds == null) {
			// initialize DataSource
				ds = new HikariDataSource();
				ds.setJdbcUrl(jdbcURL);
		}

		try {
			Connection c = ds.getConnection();
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
