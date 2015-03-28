package org.bme.base.model;

import java.util.Date;

public class FeelRecode {
	private int id;
	private String useid;// 用户id
	private String balance;// 余额
	private String fee;// 缴费
	private String operator;// 操作员
	private Date operatordate;// 操作日期

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUseid() {
		return useid;
	}

	public void setUseid(String useid) {
		this.useid = useid;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getOperatordate() {
		return operatordate;
	}

	public void setOperatordate(Date operatordate) {
		this.operatordate = operatordate;
	}


}
