package com.merck.ocs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merck.ocs.beans.ServerBean;
import com.merck.ocs.dao.ServerDao;

import javassist.NotFoundException;

@Service
public class ServerServiceImpl implements ServerService {

	@Autowired
	private ServerDao serverDao;

	@Override
	public List<ServerBean> getAllServers() {
		return serverDao.getAllServers();
	}

	@Override
	public ServerBean getServerById(Integer id) throws NotFoundException {
		return serverDao.getServerById(id);
	}

	@Override
	public ServerBean getServerByServerName(String serverName) throws NotFoundException {
		return serverDao.getServerByServerName(serverName);
	}

	@Override
	public ServerBean createServer(ServerBean serverBean) {
		return serverDao.createServer(serverBean);
	}

	@Override
	public List<ServerBean> getServersByComponentId(Integer componentId) {
		return serverDao.getServersByComponentId(componentId);
	}

}
