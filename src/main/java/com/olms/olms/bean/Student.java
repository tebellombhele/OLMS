package com.olms.olms.bean;

import java.io.Serializable;

/**
 * The type Student.
 */
public class Student implements Serializable {

	private String sid;
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String salt;

    /**
     * Instantiates a new Student.
     */
    public Student() {
		username="";
		password="";
		email = "";
		firstName = "";
		lastName = "";
		setSalt("");
	}

    /**
     * Instantiates a new Student.
     *
     * @param sid       the sid
     * @param username  the username
     * @param password  the password
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     * @param salt      the salt
     */
    public Student(String sid, String username,String password,String firstName, String lastName, String email, String salt) {
		this.sid = sid;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.salt = salt;
	}

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
		return email;
	}

    /**
     * Gets sid.
     *
     * @return the sid
     */
    public String getSid() {
		return sid;
	}

    /**
     * Sets sid.
     *
     * @param sid the sid
     */
    public void setSid(String sid) {
		this.sid = sid;
	}

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
		return username;
	}

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
		this.username = username;
	}

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
		return password;
	}

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
		this.password = password;
	}

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
		this.email = email;
	}

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
		return firstName;
	}

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
		return lastName;
	}

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    /**
     * Gets salt.
     *
     * @return the salt
     */
    public String getSalt() {
		return salt;
	}

    /**
     * Sets salt.
     *
     * @param salt the salt
     */
    public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", salt=" + salt + "]";
	}






}