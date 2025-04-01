package com.olms.olms.databaseutility;

import com.olms.olms.bean.Student;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * The type Student db.
 */
public class StudentDatabase {

    /**
     * Insert int.
     *
     * @param user the user
     * @return the int
     */
    public static int insert(@NotNull Student user) {
        ConnectionHub hub = ConnectionHub.getInstance();
        Connection connection = hub.getConnection();
        PreparedStatement ps = null;
        

        String query
                = "INSERT INTO student (studentid, firstname, lastname, username, email, password,salt) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getSid());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getUsername());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPassword());
            ps.setString(7,user.getSalt());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DatabaseUtility.closePreparedStatement(ps);
            hub.NoConnection(connection);
        }
    }
}