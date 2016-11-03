package com.github.liyiorg.common.result;

public class BaseResult {

	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isSuccess(){
		return "0".equals(status);
	}
}
