package org.bme.base.model;

public class PowerType {
	private Integer id;
	private String typename;// 用户类型
	private Double feestandard;// 收费标准

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Double getFeestandard() {
		return feestandard;
	}

	public void setFeestandard(Double feestandard) {
		this.feestandard = feestandard;
	}

}
