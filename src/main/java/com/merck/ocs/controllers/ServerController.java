package com.merck.ocs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.merck.ocs.beans.ApplicationBean;
import com.merck.ocs.beans.ComponentBean;
import com.merck.ocs.beans.ServerBean;
import com.merck.ocs.service.ApplicationService;
import com.merck.ocs.service.ComponentService;
import com.merck.ocs.service.ServerService;

import javassist.NotFoundException;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://192.168.0.111:3000" })
public class ServerController {

	@Autowired
	private ServerService serverService;

	@Autowired
	private ComponentService componentService;

	@Autowired
	private ApplicationService applicationService;

	@PostMapping("/server")
	public ResponseEntity<ServerBean> createServer(@RequestBody ServerBean serverBean,
			@RequestParam("app") String applicationName, @RequestParam("component") String componentName)
			throws NotFoundException {

		ApplicationBean applicationBean = applicationService.getApplicationByApplicationName(applicationName);
		List<ComponentBean> componentBeans = componentService.getComponentsByApplicationId(applicationBean.getId());

		ComponentBean componentBean = null;

		for (ComponentBean item : componentBeans) {
			if (item.getName().equals(componentName)) {
				componentBean = item;
				break;
			}
		}

		serverBean.setComponent(componentBean);

		return ResponseEntity.ok(serverService.createServer(serverBean));
	}

	@GetMapping("/servers/all")
	public ResponseEntity<List<ServerBean>> getAllServers() {
		return ResponseEntity.ok(serverService.getAllServers());
	}

	@GetMapping("/server/{serverId}")
	public ResponseEntity<ServerBean> getServerById(@PathVariable("serverId") Integer serverId)
			throws NotFoundException {
		return ResponseEntity.ok(serverService.getServerById(serverId));
	}

	@GetMapping("/servers/{componentId}")
	public ResponseEntity<List<ServerBean>> getServersByComponentId(@PathVariable("componentId") Integer componentId) {
		return ResponseEntity.ok(serverService.getServersByComponentId(componentId));
	}

	@GetMapping("/server")
	public ResponseEntity<ServerBean> getServerByServerName(@RequestParam("name") String serverName)
			throws NotFoundException {
		return ResponseEntity.ok(serverService.getServerByServerName(serverName));
	}

	@GetMapping("/servers")
	public ResponseEntity<List<ServerBean>> getServersByApplicationNameAndComponentName(
			@RequestParam("app") String applicationName, @RequestParam("component") String componentName)
			throws NotFoundException {
		ApplicationBean applicationBean = applicationService.getApplicationByApplicationName(applicationName);
		List<ComponentBean> componentBeans = componentService.getComponentsByApplicationId(applicationBean.getId());

		ComponentBean componentBean = null;

		for (ComponentBean item : componentBeans) {
			if (item.getName().equals(componentName)) {
				componentBean = item;
				break;
			}
		}

		return ResponseEntity.ok(serverService.getServersByComponentId(componentBean.getId()));
	}
}
