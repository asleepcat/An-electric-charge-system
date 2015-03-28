package org.bme.base.model;

import java.util.Date;

public class GetData {
	private Integer gdid;//主键
	private Integer yhid;//外键用户表
	private Date cbrq;//抄表日期
	private Double cbdl;//抄表电量
	private String sfqy;//是否启用
	public Integer getGdid() {
		return gdid;
	}
	public void setGdid(Integer gdid) {
		this.gdid = gdid;
	}
	public Integer getYhid() {
		return yhid;
	}
	public void setYhid(Integer yhid) {
		this.yhid = yhid;
	}
	public Date getCbrq() {
		return cbrq;
	}
	public void setCbrq(Date cbrq) {
		this.cbrq = cbrq;
	}
	public Double getCbdl() {
		return cbdl;
	}
	public void setCbdl(Double cbdl) {
		this.cbdl = cbdl;
	}
	public String getSfqy() {
		return sfqy;
	}
	public void setSfqy(String sfqy) {
		this.sfqy = sfqy;
	}
}
