package com.olms.olms.bean;

import java.io.Serializable;

/**
 * The type Issue.
 */
public class Issue implements Serializable {

	private int issueid;
	private String bookid;
	private String studentid;


    /**
     * Instantiates a new Issue.
     */
    public Issue() {

	}

    /**
     * Instantiates a new Issue.
     *
     * @param bookid    the bookid
     * @param studentid the studentid
     */
    public Issue(String bookid, String studentid) {
		this.setIssueid(issueid);
		this.setBookid(bookid);
		this.setStudentid(studentid);
	}

    /**
     * Gets studentid.
     *
     * @return the studentid
     */
    public String getStudentid() {
		return studentid;
	}

    /**
     * Sets studentid.
     *
     * @param studentid the studentid
     */
    public void setStudentid(String studentid) {
		this.studentid = studentid;
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
     * Gets issueid.
     *
     * @return the issueid
     */
    public int getIssueid() {
		return issueid;
	}

    /**
     * Sets issueid.
     *
     * @param issueid the issueid
     */
    public void setIssueid(int issueid) {
		this.issueid = issueid;
	}

	@Override
	public String toString() {
		return "Issue [issueid=" + issueid + ", bookid=" + bookid + ", studentid=" + studentid + "]";
	}
}