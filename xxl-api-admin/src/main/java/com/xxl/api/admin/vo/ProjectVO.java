package com.xxl.api.admin.vo;

import lombok.Data;

@Data
public class ProjectVO {

    /**
     * id
     */
    private Integer id;

    /**
     * 项目icon
     */
    private String cover;

    /**
     * 项目标题/名称
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 修改日期
     */
    private String updatedAt;


}
