package org.arc.entity;

import java.util.Date;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version 创建时间：2017年10月28日 下午5:05:48
 */
public class Record {
	private int recordId;
	private Date finishTime;
	private int recordNumber;
	private int result;
	private int fertA;
	private int fertB;
	private int fertC;
	
	public Record() {
		super();
	}
	public Record(int recordId, Date finishTime, int recordNumber, int result,
			int fertA, int fertB, int fertC) {
		super();
		this.recordId = recordId;
		this.finishTime = finishTime;
		this.recordNumber = recordNumber;
		this.result = result;
		this.fertA = fertA;
		this.fertB = fertB;
		this.fertC = fertC;
	}
	
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public int getRecordNumber() {
		return recordNumber;
	}
	public void setRecordNumber(int recordNumber) {
		this.recordNumber = recordNumber;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int getFertA() {
		return fertA;
	}
	public void setFertA(int fertA) {
		this.fertA = fertA;
	}
	public int getFertB() {
		return fertB;
	}
	public void setFertB(int fertB) {
		this.fertB = fertB;
	}
	public int getFertC() {
		return fertC;
	}
	public void setFertC(int fertC) {
		this.fertC = fertC;
	}
	
	
	
}
