package com.merck.ocs.service;

import java.util.List;

import com.merck.ocs.beans.ComponentBean;

import javassist.NotFoundException;

public interface ComponentService {
	
	public List<ComponentBean> getComponentsByApplicationId(Integer applicationId);

	public ComponentBean getComponentById(Integer componentId) throws NotFoundException;

	public ComponentBean createComponent(ComponentBean componentBean);

}
