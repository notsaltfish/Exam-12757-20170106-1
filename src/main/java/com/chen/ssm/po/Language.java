package com.chen.ssm.po;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Language {
	private int languageId;
	private String name;
	private Date lastUpdate;
	
	
	public int getLanguageId() {
		return languageId;
	}
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}
