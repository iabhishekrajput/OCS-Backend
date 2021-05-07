package com.merck.ocs.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import com.merck.ocs.entities.ComponentEntity;

@RepositoryDefinition(domainClass = ComponentEntity.class, idClass = Integer.class)
public interface ComponentRepository extends JpaRepository<ComponentEntity, Integer> {
	
	List<ComponentEntity> findByApplicationId(Integer applicationId);
	
	Optional<ComponentEntity> findByIdAndApplicationId(Integer id, Integer applicationId);
}
