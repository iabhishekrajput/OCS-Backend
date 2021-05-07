package com.merck.ocs.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.merck.ocs.beans.ServerBean;
import com.merck.ocs.entities.ServerEntity;
import com.merck.ocs.utils.ServerUtils;

import javassist.NotFoundException;

@Repository
public class ServerDaoImpl implements ServerDao {

	@Autowired
	private ServerRepository serverRepository;

	@Override
	public List<ServerBean> getAllServers() {
		List<ServerEntity> serverEntities = serverRepository.findAll();
		List<ServerBean> serverBeans = new ArrayList<>();

		for (ServerEntity serverEntity : serverEntities) {
			serverBeans.add(ServerUtils.convertEntityToBean(serverEntity));
		}

		return serverBeans;
	}

	@Override
	public ServerBean getServerById(Integer id) throws NotFoundException {
		return serverRepository.findById(id).map(server -> {
			return ServerUtils.convertEntityToBean(server);
		}).orElseThrow(() -> new NotFoundException("Could not find Server"));
	}

	@Override
	public ServerBean getServerByServerName(String serverName) throws NotFoundException {
		return serverRepository.findByName(serverName).map(server -> {
			return ServerUtils.convertEntityToBean(server);
		}).orElseThrow(() -> new NotFoundException("Could not find Server"));
	}

	@Override
	public ServerBean createServer(ServerBean serverBean) {
		return ServerUtils.convertEntityToBean(serverRepository.save(ServerUtils.convertBeanToEntity(serverBean)));
	}

	@Override
	public List<ServerBean> getServersByComponentId(Integer componentId) {
		List<ServerEntity> serverEntities = serverRepository.findByComponentId(componentId);
		List<ServerBean> serverBeans = new ArrayList<>();

		for (ServerEntity serverEntity : serverEntities) {
			serverBeans.add(ServerUtils.convertEntityToBean(serverEntity));
		}

		return serverBeans;
	}
}
