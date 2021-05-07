package com.merck.ocs.utils;

import com.merck.ocs.beans.ServerBean;
import com.merck.ocs.entities.ServerEntity;

public class ServerUtils {

	public static ServerEntity convertBeanToEntity(ServerBean serverBean) {
		ServerEntity serverEntity = new ServerEntity();

		serverEntity.setId(serverBean.getId());
		serverEntity.setName(serverBean.getName());
		serverEntity.setOs(serverBean.getOs());
		serverEntity.setTitle(serverBean.getTitle());
		serverEntity.setComponent(ComponentUtils.convertBeanToEntity(serverBean.getComponent()));

		return serverEntity;

	}

	public static ServerBean convertEntityToBean(ServerEntity serverEntity) {
		ServerBean serverBean = new ServerBean();

		serverBean.setId(serverEntity.getId());
		serverBean.setName(serverEntity.getName());
		serverBean.setOs(serverEntity.getOs());
		serverBean.setTitle(serverEntity.getTitle());
		serverBean.setComponent(ComponentUtils.convertEntityToBean(serverEntity.getComponent()));

		return serverBean;
	}
}
