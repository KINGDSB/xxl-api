package com.xxl.api.admin.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageVO {

    /**
     * 当前页码
     */
    private Integer pageNo;

    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 总条数
     */
    private Integer totalCount;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 数据
     */
    private List data;

    /**
     * 获取总页数
     */
    public Integer getPageCount(){
        return totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
    };
}
