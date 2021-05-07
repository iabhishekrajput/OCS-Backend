package com.merck.ocs.dao;

import java.util.List;

import com.merck.ocs.beans.ComponentBean;

import javassist.NotFoundException;

public interface ComponentDao {
	
	public List<ComponentBean> getComponentsByApplicationId(Integer applicationId);

	public ComponentBean createComponent(ComponentBean componentBean);

	public ComponentBean getComponentById(Integer componentId) throws NotFoundException;

}
