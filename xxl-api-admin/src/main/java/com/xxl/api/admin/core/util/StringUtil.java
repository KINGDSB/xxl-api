package com.xxl.api.admin.core.util;

import java.util.UUID;

import org.springframework.util.StringUtils;

public class StringUtil extends StringUtils {
	/**
     * 取随机的32位uuid
     *
     * @return
     */
    public static String getUUID() {
          return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
