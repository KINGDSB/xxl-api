package com.xxl.api.admin.dto;

import lombok.Data;

/**
 * 登录dto
 * @author dsb
 * @Date: 2019/10/5 15:19
 * @Description:
 */
@Data
public class LoginDTO {

    /**
     * username
     */
    private String username;
    /**
     * password
     */
    private String password;
}
