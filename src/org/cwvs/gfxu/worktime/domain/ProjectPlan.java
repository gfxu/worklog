package org.cwvs.gfxu.worktime.domain;

import java.util.Date;

public class ProjectPlan extends BaseDomain {

	private static final long serialVersionUID = 8495873852551847937L;

	private Long id;       
	private Long projectId;
	private Date sTime;
	private Date eTime;
	private String milestone;
	private String comment;
	
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getMilestone() {
		return milestone;
	}
	public void setMilestone(String milestone) {
		this.milestone = milestone;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getsTime() {
		return sTime;
	}
	public void setsTime(Date sTime) {
		this.sTime = sTime;
	}
	public Date geteTime() {
		return eTime;
	}
	public void seteTime(Date eTime) {
		this.eTime = eTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
