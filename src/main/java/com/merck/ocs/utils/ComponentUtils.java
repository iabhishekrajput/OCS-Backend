package com.merck.ocs.utils;

import com.merck.ocs.beans.ComponentBean;
import com.merck.ocs.entities.ComponentEntity;

public class ComponentUtils {
	public static ComponentBean convertEntityToBean(ComponentEntity componentEntity) {

		ComponentBean componentBean = new ComponentBean();

		componentBean.setId(componentEntity.getId());
		componentBean.setName(componentEntity.getName());
		componentBean.setTitle(componentEntity.getTitle());
		componentBean.setApplication(ApplicationUtils.convertEntityToBean(componentEntity.getApplication()));

		return componentBean;
	}

	public static ComponentEntity convertBeanToEntity(ComponentBean componentBean) {

		ComponentEntity componentEntity = new ComponentEntity();

		componentEntity.setId(componentBean.getId());
		componentEntity.setName(componentBean.getName());
		componentEntity.setTitle(componentBean.getTitle());
		componentEntity.setApplication(ApplicationUtils.convertBeanToEntity(componentBean.getApplication()));

		return componentEntity;
	}
}
