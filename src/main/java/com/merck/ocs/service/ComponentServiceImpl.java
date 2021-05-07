package com.merck.ocs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merck.ocs.beans.ComponentBean;
import com.merck.ocs.dao.ComponentDao;

import javassist.NotFoundException;

@Service
public class ComponentServiceImpl implements ComponentService {

	@Autowired
	private ComponentDao componentDao;

	@Override
	public List<ComponentBean> getComponentsByApplicationId(Integer applicationId) {
		return componentDao.getComponentsByApplicationId(applicationId);
	}

	@Override
	public ComponentBean createComponent(ComponentBean componentBean) {
		return componentDao.createComponent(componentBean);
	}

	@Override
	public ComponentBean getComponentById(Integer componentId) throws NotFoundException {
		return componentDao.getComponentById(componentId);
	}

}
