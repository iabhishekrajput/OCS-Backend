package com.merck.ocs.dao;

import java.util.List;

import com.merck.ocs.beans.ApplicationBean;

import javassist.NotFoundException;

public interface ApplicationDao {
	
	public List<ApplicationBean> getAllApplications();

	public ApplicationBean createApplication(ApplicationBean applicationBean);

	public ApplicationBean getApplicationById(Integer applicationId) throws NotFoundException;

	public ApplicationBean getApplicationByApplicationName(String applicationName) throws NotFoundException;
	
}
