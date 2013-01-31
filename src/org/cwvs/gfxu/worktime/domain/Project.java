package org.cwvs.gfxu.worktime.domain;

public class Project extends BaseDomain {

	private static final long serialVersionUID = 5707969641609486251L;
	
	private Long id;       
	private String name;
	private Long projectManagerId;
	
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
	public Long getProjectManagerId() {
		return projectManagerId;
	}
	public void setProjectManagerId(Long projectManagerId) {
		this.projectManagerId = projectManagerId;
	}

}
