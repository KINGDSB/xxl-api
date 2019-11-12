package com.xxl.api.admin.core.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;



/**
 * @author xdp
 * 2019-11-2
 */
@Data
public class BlueStarApplyfromDTO implements Serializable{
	private String id;
	private String applyOfName;
	private String applyOfProjectName;
	private String applyOfPort;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Timestamp applyOfDate;
	private String applyOfStatus;
}
