package com.olms.olms.databaseutility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The type Db util.
 */
public class DatabaseUtility {

    /**
     * Close statement.
     *
     * @param s the s
     */
    public static void closeStatement(Statement s) {
        try {
            if (s != null) {
                s.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * Close prepared statement.
     *
     * @param ps the ps
     */
    public static void closePreparedStatement(Statement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * Close result set.
     *
     * @param rs the rs
     */
    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}