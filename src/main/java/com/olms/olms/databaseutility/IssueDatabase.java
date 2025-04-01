package com.olms.olms.databaseutility;

import com.olms.olms.bean.Book;
import com.olms.olms.bean.Issue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The type Issue db.
 */
public class IssueDatabase {

    /**
     * Insert int.
     *
     * @param issue the issue
     * @return the int
     */
    public static int insert(@NotNull Issue issue) {
		ConnectionHub hub = ConnectionHub.getInstance();
		Connection connection = hub.getConnection();
		PreparedStatement ps = null;

		String query = "INSERT INTO Issue (bookid, studentid) "
				+ "VALUES (?, ?)";
		try {

			ps = connection.prepareStatement(query);
			ps.setString(1, issue.getBookid());
			ps.setString(2, issue.getStudentid());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			return 0;
		} finally {
			DatabaseUtility.closePreparedStatement(ps);
			hub.NoConnection(connection);
		}
	}

    /**
     * Issued books array list.
     *
     * @param studentid the studentid
     * @return the array list
     */
    public static @Nullable ArrayList<Book> issuedBooks(String studentid) {
		// add code that returns an ArrayList<User> object of all books in the
		// Book table
		ConnectionHub hub = ConnectionHub.getInstance();
		Connection connection = hub.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM book inner join Issue on book.bookid= Issue.bookid where Issue.studentid= ? ;";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1,studentid);
			System.out.println(studentid);
			rs = ps.executeQuery();
			ArrayList<Book> books = new ArrayList<>();
			while (rs.next()) {
				Book book = new Book();
				book.setBookid(rs.getString("bookid"));

				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPubdate(rs.getString("publicationdate"));
				books.add(book);

			}
			return books;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} finally {
			DatabaseUtility.closeResultSet(rs);
			DatabaseUtility.closePreparedStatement(ps);
			hub.NoConnection(connection);
		}
	}

    /**
     * Delete int.
     *
     * @param issue the issue
	 */
    public static void delete(Issue issue) {
		ConnectionHub hub = ConnectionHub.getInstance();
		Connection connection = hub.getConnection();
		PreparedStatement ps = null;

		String query = "DELETE FROM Issue "
				+ "WHERE bookid = ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, issue.getBookid());

			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DatabaseUtility.closePreparedStatement(ps);
			hub.NoConnection(connection);
		}
	}

    /**
     * Delete with book id int.
     *
     * @param bookId the book id
	 */
    public static void deleteWithBookId(String bookId) {
		ConnectionHub hub = ConnectionHub.getInstance();
		Connection connection = hub.getConnection();
		PreparedStatement ps = null;

		String query = "DELETE FROM Issue "
				+ "WHERE bookid = ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, bookId);

			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DatabaseUtility.closePreparedStatement(ps);
			hub.NoConnection(connection);
		}
	}
}




