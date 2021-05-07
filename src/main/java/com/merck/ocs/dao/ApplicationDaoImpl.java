package com.merck.ocs.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.merck.ocs.beans.ApplicationBean;
import com.merck.ocs.entities.ApplicationEntity;
import com.merck.ocs.utils.ApplicationUtils;

import javassist.NotFoundException;

@Repository
public class ApplicationDaoImpl implements ApplicationDao {

	@Autowired
	private ApplicationRepository applicationRepository;

	@Override
	public List<ApplicationBean> getAllApplications() {
		List<ApplicationEntity> applicationEntities = applicationRepository.findAll();
		List<ApplicationBean> applicationBeans = new ArrayList<>();

		for (ApplicationEntity applicationEntity : applicationEntities) {
			applicationBeans.add(ApplicationUtils.convertEntityToBean(applicationEntity));
		}

		return applicationBeans;
	}

	@Override
	public ApplicationBean createApplication(ApplicationBean applicationBean) {
		return ApplicationUtils.convertEntityToBean(applicationRepository.save(ApplicationUtils.convertBeanToEntity(applicationBean)));
	}

	@Override
	public ApplicationBean getApplicationById(Integer applicationId) throws NotFoundException {
		return applicationRepository.findById(applicationId).map(applicationEntity -> {
			return ApplicationUtils.convertEntityToBean(applicationEntity);
		}).orElseThrow(() -> new NotFoundException("Application Not Found"));
	}

	@Override
	public ApplicationBean getApplicationByApplicationName(String applicationName) throws NotFoundException {
		return applicationRepository.findByName(applicationName).map(applicationEntity -> {
			return ApplicationUtils.convertEntityToBean(applicationEntity);
		}).orElseThrow(() -> new NotFoundException("Application Not Found"));
	}

}
