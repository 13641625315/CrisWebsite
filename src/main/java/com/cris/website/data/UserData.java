package com.cris.website.data;

public class UserData {
	private String phoneNum;
	private String nickName;
	private String password;

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("phoneNum=");
		stringBuilder.append(phoneNum);
		stringBuilder.append(",");
		stringBuilder.append("nickName=");
		stringBuilder.append(nickName);
		stringBuilder.append(",");
		stringBuilder.append("password=");
		stringBuilder.append(password);
		stringBuilder.append(",");
		return stringBuilder.toString();
	}
}
