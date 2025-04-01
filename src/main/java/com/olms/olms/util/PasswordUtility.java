package com.olms.olms.util;

import org.jetbrains.annotations.NotNull;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

/**
 * The type Password utility.
 */
public class PasswordUtility {

    /**
     * This code uses SHA-256. If this algorithm isn't available,
     * Try a weaker level of encryption such as SHA-128.
     *
     * @param password the password
     * @return the string
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    public static @NotNull String hashPassword(@NotNull String password)
			throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.reset();
		md.update(password.getBytes());
		byte[] mdArray = md.digest();
		StringBuilder sb = new StringBuilder(mdArray.length * 2);
		for (byte b : mdArray) {
			int v = b & 0xff;
			if (v < 16) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return sb.toString();
	}

    /**
     * Gets salt.
     *
     * @return the salt
     */
    public static String getSalt() {
		Random r = new SecureRandom();
		byte[] saltBytes = new byte[32];
		r.nextBytes(saltBytes);
		return Base64.getEncoder().encodeToString(saltBytes);
	}

    /**
     * Hash and salt password string.
     *
     * @param password the password
     * @return the string
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    public static @NotNull String hashAndSaltPassword(String password)
			throws NoSuchAlgorithmException {
		String salt = getSalt();
		return hashPassword(password + salt);
	}

    /**
     * Check password strength.
     *
     * @param password the password
     * @throws Exception the exception
     */
    public static void checkPasswordStrength(String password) throws Exception {
		if (password == null || password.trim().isEmpty()) {
			throw new Exception("Password cannot be empty.");
		} else if (password.length() < 8) {
			throw new Exception("Password is too short. " +
					"Must be at least 8 characters long.");
		}
	}

    /**
     * Validate password boolean.
     *
     * @param password the password
     * @return the boolean
     */
    public static boolean validatePassword(String password) {
		try {
			checkPasswordStrength(password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
}