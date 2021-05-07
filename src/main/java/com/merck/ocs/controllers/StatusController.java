package com.merck.ocs.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.merck.ocs.beans.ApplicationStatusBean;
import com.merck.ocs.beans.ComponentStatusBean;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://192.168.0.111:3000" })
public class StatusController {
	@GetMapping("/status/{applicationName}")
	public ResponseEntity<ApplicationStatusBean> getApplicationStatus(
			@PathVariable("applicationName") String applicationName) {
		ApplicationStatusBean applicationStatusBean = new ApplicationStatusBean();

		applicationStatusBean.setName(applicationName);
		applicationStatusBean.setStatus("success");

		return ResponseEntity.ok(applicationStatusBean);
	}

	@GetMapping("/status/{applicationName}/{componentName}")
	public ResponseEntity<ComponentStatusBean> getComponentStatus(
			@PathVariable("applicationName") String applicationName,
			@PathVariable("componentName") String componentName) {
		ComponentStatusBean componentStatusBean = new ComponentStatusBean();

		componentStatusBean.setName(componentName);
		componentStatusBean.setApplicationName(applicationName);
		componentStatusBean.setStatus("success");

		return ResponseEntity.ok(componentStatusBean);
	}
}
