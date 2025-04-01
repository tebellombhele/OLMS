package com.olms.olms.studentlogin;

import com.olms.olms.databaseutility.ConnectionHub;
import com.olms.olms.databaseutility.DatabaseUtility;
import com.olms.olms.util.PasswordUtility;
import org.jetbrains.annotations.Nullable;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Login dao student.
 */
public class LoginDaoStudent {
	/**
	 * Gets name.
	 *
	 * @param username  the username
	 * @param hashedpwd the hashedpwd
	 * @return the name
	 */
	public static @Nullable String getName(String username, String hashedpwd) {
		ConnectionHub hub = ConnectionHub.getInstance();
		Connection connection = hub.getConnection();
		PreparedStatement ps = null;
		ResultSet rs;
		String name= null;
		String existingPassword;
		String salt;
		String newPassword;
		String query = "SELECT * from Student WHERE username='"+username+"' ;";
		try {
			ps = connection.prepareStatement(query);{
				rs= ps.executeQuery();
				while(rs.next()){
					name= rs.getString("firstname");
					existingPassword= rs.getString("password");
					salt= rs.getString("salt");
					try {
						newPassword= PasswordUtility.hashPassword(hashedpwd + salt);
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return name;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} finally {
			DatabaseUtility.closePreparedStatement(ps);
			hub.NoConnection(connection);
		}
	}
}
