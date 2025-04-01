package com.olms.olms.databaseutility;

import org.jetbrains.annotations.NotNull;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The type Connection hub.
 */
public class ConnectionHub {
//Declare Amazon RDS and/or Google Firebase Root User, Password, URL and/or Key Data here...

	private static ConnectionHub hub = null;
	private static DataSource dataSource = null;
	private ConnectionHub() {
		try {
			InitialContext ic = new InitialContext();
			dataSource = (DataSource) ic.lookup("jdbc:mysql://localhost:3306/onlinelms?useSSL=true");
		} catch (NamingException e) {
			System.out.println(e);
		}
	}

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static synchronized ConnectionHub getInstance() {
		if (hub == null) {
			hub = new ConnectionHub();
		}
		return hub;
	}

    /**
     * Gets connection.
     *
     * @return the connection
     */
    public Connection getConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/onlinelms?useSSL=true";
		String username = "root";
		String password = "password";

		try
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url);
			System.out.println("Post establishing a DB connection - "+con);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return con;
		/*try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}*/
	}

    /**
     * No connection.
     *
     * @param c the c
     */
    public void NoConnection(@NotNull Connection c) {
		try {
			c.close();
		} catch (SQLException | NullPointerException |IllegalArgumentException e) {
			System.out.println(e);
		}
	}
}