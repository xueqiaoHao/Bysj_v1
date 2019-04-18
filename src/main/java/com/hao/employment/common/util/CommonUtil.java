package com.hao.employment.common.util;

import com.hao.employment.bean.entry.SysMenu;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
    /*将集合中的值转为逗号拼接的字符串*/

}
