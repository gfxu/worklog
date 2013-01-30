package org.cwvs.gfxu.worktime.controller;

import java.io.Serializable;

import org.cwvs.gfxu.worktime.domain.User;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 */
public class AccountForm implements Serializable {

	private User account;

	private boolean newAccount;

	private String repeatedPassword;

	public AccountForm(User account) {
		this.account = account;
		this.newAccount = false;
	}

	public AccountForm() {
		this.account = new User();
		this.newAccount = true;
	}

	public User getAccount() {
		return account;
	}

	public boolean isNewAccount() {
		return newAccount;
	}

	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}

	public String getRepeatedPassword() {
		return repeatedPassword;
	}

}
