package com.olms.olms.databaseutility;


import com.olms.olms.bean.Book;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The type Book db.
 */
public class BookDatabase {

	/**
	 * Insert int.
	 *
	 * @param book the book
	 * @return the int
	 */
	public static int insert(@NotNull Book book) {
		ConnectionHub hub = ConnectionHub.getInstance();
		Connection connection = hub.getConnection();
		PreparedStatement ps = null;

		String query = "INSERT INTO Book (bookid, title , author, publicationdate, quantity) " + "VALUES (?, ?, ?, ?, ?)";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, book.getBookid());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getPubdate());
			ps.setString(5, book.getQuantity());
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
	 * Select books array list.
	 *
	 * @return the array list
	 */
	public static @Nullable ArrayList<Book> selectBooks() {
		// add code that returns an ArrayList<User> object of all books in the
		// Book table
		ConnectionHub hub = ConnectionHub.getInstance();
		Connection connection = hub.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM Book ";
		try {
			ps = connection.prepareStatement(query);

			rs = ps.executeQuery();
			ArrayList<Book> books = new ArrayList<>();
			while (rs.next()) {
				Book book = new Book();
				book.setBookid(rs.getString("bookid"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPubdate(rs.getString("publicationdate"));
				book.setQuantity(rs.getString("quantity"));
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
	 * Update.
	 *
	 * @param book the book
	 */
	public static void update(@NotNull Book book) {
		ConnectionHub hub = ConnectionHub.getInstance();
		Connection connection = hub.getConnection();
		PreparedStatement ps = null;

		String query = "UPDATE Book SET "
				+ "title = ? ,"
				+ "author = ? ,"
				+ "publicationdate = ? ,"
				+ "quantity = ? "
				+" WHERE bookid = ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getPubdate());
			ps.setString(4, book.getQuantity());
			ps.setString(5, book.getBookid());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DatabaseUtility.closePreparedStatement(ps);
			hub.NoConnection(connection);
		}
	}

	/**
	 * Delete.
	 *
	 * @param book the book
	 */
	public static void delete(@NotNull Book book) {
		ConnectionHub hub = ConnectionHub.getInstance();
		Connection connection = hub.getConnection();
		PreparedStatement ps = null;

		String query = "DELETE FROM Book "
				+ "WHERE bookid = ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, book.getBookid());

			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DatabaseUtility.closePreparedStatement(ps);
			hub.NoConnection(connection);
		}
	}

	/**
	 * Select book book.
	 *
	 * @param bookid the bookid
	 * @return the book
	 */
	public static @Nullable Book selectBook(String bookid) {
		ConnectionHub pool = ConnectionHub.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM Book "
				+ "WHERE bookid = ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, bookid);
			rs = ps.executeQuery();
			Book book = null;
			while(rs.next()) {
				book = new Book();
				book.setBookid(bookid);
			}

			return book;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} finally {
			DatabaseUtility.closeResultSet(rs);
			DatabaseUtility.closePreparedStatement(ps);
			pool.NoConnection(connection);
		}
	}

}