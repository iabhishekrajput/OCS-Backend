package com.merck.ocs.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.merck.ocs.beans.ComponentBean;
import com.merck.ocs.entities.ComponentEntity;
import com.merck.ocs.utils.ComponentUtils;

import javassist.NotFoundException;

@Repository
public class ComponentDaoImpl implements ComponentDao {

	@Autowired
	private ComponentRepository componentRepository;

	@Override
	public List<ComponentBean> getComponentsByApplicationId(Integer applicationId) {
		List<ComponentEntity> componentEntities = componentRepository.findByApplicationId(applicationId);
		List<ComponentBean> componentBeans = new ArrayList<>();

		for (ComponentEntity componentEntity : componentEntities) {
			componentBeans.add(ComponentUtils.convertEntityToBean(componentEntity));
		}

		return componentBeans;
	}

	@Override
	public ComponentBean createComponent(ComponentBean componentBean) {
		return ComponentUtils
				.convertEntityToBean(componentRepository.save(ComponentUtils.convertBeanToEntity(componentBean)));
	}

	@Override
	public ComponentBean getComponentById(Integer componentId) throws NotFoundException {
		return componentRepository.findById(componentId).map(componentEntity -> {
			return ComponentUtils.convertEntityToBean(componentEntity);
		}).orElseThrow(() -> new NotFoundException("Component Not Found"));
	}

}
