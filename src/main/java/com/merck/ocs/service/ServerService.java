package com.merck.ocs.service;

import java.util.List;

import com.merck.ocs.beans.ServerBean;

import javassist.NotFoundException;

public interface ServerService {
	
	public List<ServerBean> getAllServers();
	
	public ServerBean getServerById(Integer id) throws NotFoundException;

	public ServerBean getServerByServerName(String serverName) throws NotFoundException;

	public ServerBean createServer(ServerBean serverBean);

	public List<ServerBean> getServersByComponentId(Integer componentId);
}
