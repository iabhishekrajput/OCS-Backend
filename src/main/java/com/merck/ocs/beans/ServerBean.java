package com.merck.ocs.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ServerBean {

	private Integer id;
	private String name;
	private String title;
	private String os;

	@JsonIgnore
	private ComponentBean component;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public ComponentBean getComponent() {
		return component;
	}

	public void setComponent(ComponentBean component) {
		this.component = component;
	}

}
