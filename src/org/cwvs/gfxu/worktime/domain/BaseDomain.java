package org.cwvs.gfxu.worktime.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author gangfeng.xu
 *
 */
public class BaseDomain implements Serializable{
	
	private Integer status;   
	private Character delFlg;
	private String insertUser;
	private Date insertTime;
	private String updateUser;
	private Date updateTime;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Character getDelFlg() {
		return delFlg;
	}
	public void setDelFlg(Character delFlg) {
		this.delFlg = delFlg;
	}
	public String getInsertUser() {
		return insertUser;
	}
	public void setInsertUser(String insertUser) {
		this.insertUser = insertUser;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	private static final long serialVersionUID = 1L;

}
