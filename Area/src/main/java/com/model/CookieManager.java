package com.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieManager {

    public static final String  COOKIE_DERNIERE_CONNEXION = "AreaCookie";
    public static final int     COOKIE_MAX_AGE            = 60 * 60 * 24 * 365;

    public static String getCookieValue(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if ( cookies != null ) {
            for ( Cookie cookie : cookies ) {
                if ( cookie != null && COOKIE_DERNIERE_CONNEXION.equals( cookie.getName() ) ) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static void setCookie(HttpServletResponse response, String valeur) {
        Cookie cookie = new Cookie( COOKIE_DERNIERE_CONNEXION , valeur );
        cookie.setMaxAge( COOKIE_MAX_AGE );
        response.addCookie( cookie );
    }

    public static void DeleteCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie( COOKIE_DERNIERE_CONNEXION , "" );
        cookie.setMaxAge(0);
        response.addCookie( cookie );
    }
}
