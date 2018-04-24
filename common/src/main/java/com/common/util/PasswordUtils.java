package com.common.util;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class PasswordUtils {
	public static byte[] getBytes(String str) {
		return str.getBytes();
	}



	public static String getEncodePassWord(String passWord, byte[] salt) {
		byte[] hashPassword = Digests.sha1(getBytes(passWord), salt, 1024);
		return encodeHex(hashPassword);
	}



	public static String encodeHex(byte[] bytes) {
		return Hex.encodeHexString(bytes);
	}



	/**
	 * Hex解密算法
	 */
	public static byte[] decodeHex(String input) {
		try {
			return Hex.decodeHex(input.toCharArray());
		} catch (DecoderException e) {
			throw Exceptions.unchecked(e);
		}
	}
}
