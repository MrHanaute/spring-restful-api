package com.api.exeptions;

import java.util.Date;

public class MessageError {
	private Date data;
	private String msg;
	
	public MessageError() {}

	public MessageError(Date data, String msg) {
		super();
		this.data = data;
		this.msg = msg;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
