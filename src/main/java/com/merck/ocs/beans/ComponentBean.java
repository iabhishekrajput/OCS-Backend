package com.merck.ocs.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ComponentBean {

	private Integer id;
	private String name;
	private String title;
	
	@JsonIgnore
	private ApplicationBean application;

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

	public ApplicationBean getApplication() {
		return application;
	}

	public void setApplication(ApplicationBean application) {
		this.application = application;
	}

	

}
