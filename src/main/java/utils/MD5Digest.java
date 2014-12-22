package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Digest {
	public static String md5Digest(String original) throws NoSuchAlgorithmException {
		MessageDigest md5Gen = MessageDigest.getInstance("MD5");
		byte[] digest = md5Gen.digest(original.getBytes());
		StringBuffer hexSt = new StringBuffer();
		for (byte b : digest) {
			hexSt.append(String.format("%02x", b & 0xff));
		}
		String hashed = hexSt.toString();
		return hashed;
	}


}
