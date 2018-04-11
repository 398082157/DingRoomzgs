package com.ithc.util;

import java.util.UUID;

public class RanDomUUID {

	public static String uuidName(String name) {
		// 取出文件的后缀
		int index = name.lastIndexOf(".");
		String imgName = name.substring(index, name.length());
		// 生成一个唯一的随即名
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");

		return uuid + imgName;
	}

}
