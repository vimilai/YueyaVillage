package com.ycy.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtils {
		
	
	public static String getUserIdcookie(HttpServletRequest request) {
		try {
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				if("userid".equals(cookie.getName())){
					return cookie.getValue();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
