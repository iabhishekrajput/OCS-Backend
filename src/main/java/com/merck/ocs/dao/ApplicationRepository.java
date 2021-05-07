package com.merck.ocs.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import com.merck.ocs.entities.ApplicationEntity;

@RepositoryDefinition(domainClass = ApplicationEntity.class, idClass = Integer.class)
public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Integer> {
	
	Optional<ApplicationEntity> findByName(String applicationName);
}
