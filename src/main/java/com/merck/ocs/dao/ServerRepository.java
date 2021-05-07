package com.merck.ocs.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import com.merck.ocs.entities.ServerEntity;

@RepositoryDefinition(domainClass = ServerEntity.class, idClass = Integer.class)
public interface ServerRepository extends JpaRepository<ServerEntity, Integer> {

	public Optional<ServerEntity> findByName(String serverName);

	public List<ServerEntity> findByComponentId(Integer componentId);

}