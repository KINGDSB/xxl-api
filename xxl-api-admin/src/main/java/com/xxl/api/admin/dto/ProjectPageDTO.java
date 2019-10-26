package com.xxl.api.admin.dto;

import lombok.Data;

@Data
public class ProjectPageDTO extends PageDTO {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 项目名称
     */
    private String name;
}
