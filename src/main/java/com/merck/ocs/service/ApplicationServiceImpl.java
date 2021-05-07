package com.merck.ocs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merck.ocs.beans.ApplicationBean;
import com.merck.ocs.dao.ApplicationDao;

import javassist.NotFoundException;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationDao applicationDao;

	@Override
	public List<ApplicationBean> getAllApplications() {
		return applicationDao.getAllApplications();
	}

	@Override
	public ApplicationBean createApplication(ApplicationBean applicationRequestBean) {
		return applicationDao.createApplication(applicationRequestBean);
	}

	@Override
	public ApplicationBean getApplicationById(Integer applicationId) throws NotFoundException {
		return applicationDao.getApplicationById(applicationId);
	}

	@Override
	public ApplicationBean getApplicationByApplicationName(String applicationName) throws NotFoundException {
		return applicationDao.getApplicationByApplicationName(applicationName);
	}

}
