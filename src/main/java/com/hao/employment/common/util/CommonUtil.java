package com.hao.employment.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/*@author haoxueqiao
  @date 2019/4/2 19:52*/
public class CommonUtil {
    public static String getUsernameFromRequest(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            if ("Admin-Token".equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
