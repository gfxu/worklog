package org.cwvs.gfxu.worktime.domain;

public class Role extends BaseDomain {

	private static final long serialVersionUID = 5707969641609486251L;
	
	private Long id;       
	private String name;
	
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

}
