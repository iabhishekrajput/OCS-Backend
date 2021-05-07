package com.merck.ocs.service;

import java.util.List;

import com.merck.ocs.beans.ApplicationBean;

import javassist.NotFoundException;

public interface ApplicationService {

	public List<ApplicationBean> getAllApplications();

	public ApplicationBean createApplication(ApplicationBean applicationBean);

	public ApplicationBean getApplicationById(Integer applicationId) throws NotFoundException;

	public ApplicationBean getApplicationByApplicationName(String applicationName) throws NotFoundException;
}
