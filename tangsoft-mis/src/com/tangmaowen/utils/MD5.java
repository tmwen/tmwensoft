package com.tangmaowen.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.tangmaowen.mis.common.MisException;

/**
 * @author 唐懋文
 * @since 2009-10-25 下午01:56:16
 * 
 */
public class MD5 {
	
	public static String crypt(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}

		StringBuffer hexString = new StringBuffer();

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] hash = md.digest();

			for (int i = 0; i < hash.length; i++) {
				if ((0xff & hash[i]) < 0x10) {
					hexString.append("0"
							+ Integer.toHexString((0xFF & hash[i])));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[i]));
				}
			}
		} catch (NoSuchAlgorithmException e) {
			throw new MisException("对字符串进行MD5 hashing失败", e);
		}
		return hexString.toString();
	}
}
