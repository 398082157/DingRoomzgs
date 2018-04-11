package com.ithc.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SuppressWarnings("all")
public class MD5 {
	
	
	public static void main(String[] args) throws Exception {
		String md5 = getMd5("admin.");
		System.out.println(md5);
	}
	//MD5
	public static String getMd5(String md5){
		try {
			//获取md5加密算法对象,并且变成一个byte数组
			byte[] digest = MessageDigest.getInstance("md5").digest(md5.getBytes("utf-8"));
			//把byte数组变成一个16进制的数长32位
			String value = new BigInteger(1, digest).toString(16);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	

}
