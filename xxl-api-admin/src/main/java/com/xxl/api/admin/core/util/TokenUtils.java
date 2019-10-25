package com.xxl.api.admin.core.util;

import com.xxl.api.admin.core.model.XxlApiUser;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;

/**
 * Created by dsb on 19/10/5.
 */
public class TokenUtils {

    public static final String TOKEN_HEADER_KEY = "Access-Token";

    public static String makeToken(XxlApiUser xxlApiUser){
        String tokenJson = JacksonUtil.writeValueAsString(xxlApiUser);
        String tokenHex = new BigInteger(tokenJson.getBytes()).toString(16);
        return tokenHex;
    }
    public static XxlApiUser parseToken(String tokenHex){
        XxlApiUser xxlApiUser = null;
        if (tokenHex != null) {
            String tokenJson = new String(new BigInteger(tokenHex, 16).toByteArray());      // username_password(md5)
            xxlApiUser = JacksonUtil.readValue(tokenJson, XxlApiUser.class);
        }
        return xxlApiUser;
    }
    public static XxlApiUser getTokenUser(HttpServletRequest request){
        return parseToken(request.getHeader(TOKEN_HEADER_KEY));
    }
}
