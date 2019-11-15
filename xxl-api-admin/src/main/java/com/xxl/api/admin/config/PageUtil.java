package com.xxl.api.admin.config;

import lombok.Data;

@Data
public class PageUtil {
    /**
     * 当前页数 前台发来
     */
    private Integer pageNo;
    /**
     * 总条数=count(*)
     */
    private Integer totalCount;
    /**
     *当前页起始数 =（当前页数*每页条数）+1
     */
    private Integer starTotal;
    /**
     * 总页数 = 总条数/每页条数 (totalCount/PageSize)%!=0 页数+1
     */
    private Integer totalPage;
    /**
     * 每页条数 前台发来
     */
    private Integer PageSize;
}
