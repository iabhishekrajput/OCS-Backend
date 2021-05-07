package com.merck.ocs.utils;

import org.springframework.beans.BeanUtils;

import com.merck.ocs.beans.ApplicationBean;
import com.merck.ocs.entities.ApplicationEntity;

public class ApplicationUtils {
	public static ApplicationBean convertEntityToBean(ApplicationEntity applicationEntity) {

		ApplicationBean applicationBean = new ApplicationBean();

		BeanUtils.copyProperties(applicationEntity, applicationBean);

		return applicationBean;

	}

	public static ApplicationEntity convertBeanToEntity(ApplicationBean applicationBean) {

		ApplicationEntity applicationEntity = new ApplicationEntity();

		BeanUtils.copyProperties(applicationBean, applicationEntity);

		return applicationEntity;

	}
}
