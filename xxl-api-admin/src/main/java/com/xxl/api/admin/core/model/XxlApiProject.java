package com.xxl.api.admin.core.model;

import lombok.Data;

/**
 * Created by xuxueli on 17/3/30.
 */
@Data
public class XxlApiProject {

    private int id;                 // 项目ID
    private String name;            // 项目名称
    private String desc;            // 项目描述
    private String baseUrlProduct;  // 根地址(线上)
    private String baseUrlPpe;      // 根地址(预发布)
    private String baseUrlQa;       // 根地址(测试)
    private int bizId;              // 业务线ID
    private int status;              // 项目状态\r\n1.审核中\r\n2.审核不通过\r\n0.审核通过\r\n3.已停止

}
