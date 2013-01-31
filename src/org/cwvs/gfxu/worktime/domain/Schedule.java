package org.cwvs.gfxu.worktime.domain;

import java.util.Date;

public class Schedule extends BaseDomain {

	private static final long serialVersionUID = 5941611377956804007L;

	private Long id;
	private String name;
	private String comment;
	private Long projectPlanId;
	private Long coderId;
	private Long testerId;
	private Date psTime;  //计划开始时间
	private Date peTime;  //计划结束时间
	private Date asTime;  //实际开始时间
	private Date aeTime;  //实际结束时间
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Long getProjectPlanId() {
		return projectPlanId;
	}
	public void setProjectPlanId(Long projectPlanId) {
		this.projectPlanId = projectPlanId;
	}
	public Long getCoderId() {
		return coderId;
	}
	public void setCoderId(Long coderId) {
		this.coderId = coderId;
	}
	public Long getTesterId() {
		return testerId;
	}
	public void setTesterId(Long testerId) {
		this.testerId = testerId;
	}
	public Date getPsTime() {
		return psTime;
	}
	public void setPsTime(Date psTime) {
		this.psTime = psTime;
	}
	public Date getPeTime() {
		return peTime;
	}
	public void setPeTime(Date peTime) {
		this.peTime = peTime;
	}
	public Date getAsTime() {
		return asTime;
	}
	public void setAsTime(Date asTime) {
		this.asTime = asTime;
	}
	public Date getAeTime() {
		return aeTime;
	}
	public void setAeTime(Date aeTime) {
		this.aeTime = aeTime;
	}
	   
}
