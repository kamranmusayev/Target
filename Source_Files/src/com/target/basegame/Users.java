package com.target.basegame;

public abstract class Users {
	
	protected String login;
	protected String password;
	protected int currentlevel;
	protected String ArrowType,BowType;
	
	public Users(){
		login = null;
		password = null;
		currentlevel = 1;
		ArrowType = null;
		BowType = null;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCurrentlevel() {
		return currentlevel;
	}

	public void setCurrentlevel(int currentlevel) {
		this.currentlevel = currentlevel;
	}

	public String getArrowType() {
		return ArrowType;
	}

	public void setArrowType(String arrowType) {
		ArrowType = arrowType;
	}

	public String getBowType() {
		return BowType;
	}

	public void setBowType(String bowType) {
		BowType = bowType;
	}
}
