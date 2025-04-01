package com.olms.olms.bean;

import java.io.Serializable;

/**
 * The type Book.
 */
public class Book implements Serializable {

	private String bookid;
	private String title;
	private String author;
	private String pubdate;
	private String quantity;

    /**
     * Instantiates a new Book.
     */
    public Book() {
		title="";
		author="";
		pubdate = "";
		quantity = "";
	}

    /**
     * Instantiates a new Book.
     *
     * @param bookid   the bookid
     * @param title    the title
     * @param author   the author
     * @param pubdate  the pubdate
     * @param quantity the quantity
     */
    public Book(String bookid, String title,String author,String pubdate, String quantity) {
		this.bookid = bookid;
		this.title = title;
		this.author = author;
		this.quantity = quantity;
		this.pubdate = pubdate;
	}

    /**
     * Gets bookid.
     *
     * @return the bookid
     */
    public String getBookid() {
		return bookid;
	}

    /**
     * Sets bookid.
     *
     * @param bookid the bookid
     */
    public void setBookid(String bookid) {
		this.bookid = bookid;
	}

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
		return title;
	}

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
		this.title = title;
	}

    /**
     * Gets author.
     *
     * @return the author
     */
    public String getAuthor() {
		return author;
	}

    /**
     * Sets author.
     *
     * @param author the author
     */
    public void setAuthor(String author) {
		this.author = author;
	}

    /**
     * Gets pubdate.
     *
     * @return the pubdate
     */
    public String getPubdate() {
		return pubdate;
	}

    /**
     * Sets pubdate.
     *
     * @param pubdate the pubdate
     */
    public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public String getQuantity() {
		return quantity;
	}

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", title=" + title + ", author=" + author + ", pubdate=" + pubdate
				+ ", quantity=" + quantity + "]";
	}




}