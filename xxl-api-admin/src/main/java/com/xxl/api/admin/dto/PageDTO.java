package com.xxl.api.admin.dto;

import lombok.Data;

@Data
public class PageDTO {

    /**
     * 当前页码 ※※※从0开始※※※
     */
    private Integer pageNo;

    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 排序字段
     */
    private String sort;

    /**
     * 排序规则，正/倒序
     */
    private String order;
}
