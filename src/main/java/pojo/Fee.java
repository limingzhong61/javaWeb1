package pojo;

import java.util.Date;

public class Fee {
	@Override
	public String toString() {
		return "Fee [feeId=" + feeId + ", feeName=" + feeName + ", baseTime=" + baseTime + ", baseFee=" + baseFee
				+ ", unitFee=" + unitFee + ", createTime=" + createTime + ", startTime=" + startTime + ", state="
				+ state + "]";
	}

	private Integer feeId;

	private String feeName;

	private Integer baseTime;

	private Double baseFee;

	private String unitFee;

	private Date createTime;

	private Date startTime;

	private String state;

	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getFeeId() {

		return this.feeId;
	}

	public void setFeeId(Integer feeId) {

		this.feeId = feeId;
	}

	public String getFeeName() {

		return this.feeName;
	}

	public void setFeeName(String feeName) {

		this.feeName = feeName;
	}

	public Integer getBaseTime() {

		return this.baseTime;
	}

	public void setBaseTime(Integer baseTime) {

		this.baseTime = baseTime;
	}

	public Double getBaseFee() {

		return this.baseFee;
	}

	public void setBaseFee(Double baseFee) {

		this.baseFee = baseFee;
	}

	public String getUnitFee() {

		return this.unitFee;
	}

	public void setUnitFee(String unitFee) {

		this.unitFee = unitFee;
	}

	public Date getCreateTime() {

		return this.createTime;
	}

	public void setCreateTime(Date createTime) {

		this.createTime = createTime;
	}

	public Date getStartTime() {

		return this.startTime;
	}

	public void setStartTime(Date startTime) {

		this.startTime = startTime;
	}

	public String getState() {

		return this.state;
	}

	public void setState(String state) {

		this.state = state;
	}
}
