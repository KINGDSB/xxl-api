package com.xxl.api.admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xxl.api.admin.core.model.ReturnT;
import com.xxl.api.admin.core.model.XxlApiUser;
import com.xxl.api.admin.core.util.CookieUtil;
import com.xxl.api.admin.core.util.JacksonUtil;
import com.xxl.api.admin.core.util.TokenUtils;
import com.xxl.api.admin.dao.IXxlApiUserDao;
import com.xxl.api.admin.dto.LoginDTO;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;

/**
 * Created by xuxueli on 17/3/30.
 */
@Configuration
public class LoginService {

    public static final String LOGIN_IDENTITY = "XXL_API_LOGIN_IDENTITY";

    @Resource
    private IXxlApiUserDao xxlApiUserDao;

    /**
     * login
     *
     * @param dto
     * @return
     */
    public ReturnT<String> login(LoginDTO dto){

        XxlApiUser xxlApiUser = xxlApiUserDao.findByUserName(dto.getUsername());
        if (xxlApiUser == null) {
            return new ReturnT<String>(500, "账号或密码错误");
        }

        // 密码加密暂时就在前端加密
//        String passwordParamMd5 = dto.getPassword();
        String passwordParamMd5 = DigestUtils.md5DigestAsHex(dto.getPassword().getBytes());
        if (!xxlApiUser.getPassword().equals(passwordParamMd5)) {
            return new ReturnT<String>(500, "账号或密码错误");
        }

        JSONObject data = JSONObject.parseObject("{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": 1,\n" +
                "    \"username\": 1,\n" +
                "    \"password\": \"\",\n" +
                "    \"avatar\": \"https://gw.alipayobjects.com/zos/rmsportal/jZUIxmJycoymBprLOUbT.png\",\n" +
                "    \"status\": 1,\n" +
                "    \"telephone\": \"\",\n" +
                "    \"lastLoginIp\": \"27.154.74.117\",\n" +
                "    \"lastLoginTime\": 1534837621348,\n" +
                "    \"creatorId\": \"admin\",\n" +
                "    \"createTime\": 1497160610259,\n" +
                "    \"deleted\": 0,\n" +
                "    \"roleId\": \"admin\",\n" +
                "    \"lang\": \"zh-CN\",\n" +
                "    \"token\": \"4291d7da9005377ec9aec4a71ea837f\"\n" +
                "  }");

        String loginToken = TokenUtils.makeToken(xxlApiUser);
        data.put("token", loginToken);
        data.put("id", xxlApiUser.getId());
        data.put("name", xxlApiUser.getUserName());
        data.put("userName", xxlApiUser.getUserName());

        return ReturnT.success(data);
    }

    /**
     * logout
     *
     * @param request
     * @param response
     */
    public void logout(HttpServletRequest request, HttpServletResponse response){
        CookieUtil.remove(request, response, LOGIN_IDENTITY);
    }

    /**
     * logout
     *
     * @param request
     * @return
     */
    public XxlApiUser ifLogin(HttpServletRequest request){
        String cookieToken = CookieUtil.getValue(request, LOGIN_IDENTITY);
        if (cookieToken != null) {
            XxlApiUser cookieUser = TokenUtils.parseToken(cookieToken);
            if (cookieUser != null) {
                XxlApiUser dbUser = xxlApiUserDao.findByUserName(cookieUser.getUserName());
                if (dbUser != null) {
                    if (cookieUser.getPassword().equals(dbUser.getPassword())) {
                        return dbUser;
                    }
                }
            }
        }
        return null;
    }

}
