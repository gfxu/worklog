package org.cwvs.gfxu.worktime.controller;

import java.io.Serializable;

import org.cwvs.gfxu.worktime.domain.User;
import org.springframework.beans.support.PagedListHolder;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 */
public class UserSession implements Serializable {

	private User account;

	private PagedListHolder myList;

	public UserSession(User account) {
		this.account = account;
	}

	public User getAccount() {
		return account;
	}

	public void setMyList(PagedListHolder myList) {
		this.myList = myList;
	}

	public PagedListHolder getMyList() {
		return myList;
	}

}
