package com.ycy.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtils {
		
	
	public static String getUserIdcookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if("userid".equals(cookie.getName())){
				return cookie.getValue();
			}
		}
		return null;
	}
	
}
