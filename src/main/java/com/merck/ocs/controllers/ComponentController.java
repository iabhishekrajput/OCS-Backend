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

import com.merck.ocs.beans.ComponentBean;
import com.merck.ocs.service.ApplicationService;
import com.merck.ocs.service.ComponentService;

import javassist.NotFoundException;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://192.168.0.111:3000" })
public class ComponentController {

	@Autowired
	private ComponentService componentService;

	@Autowired
	private ApplicationService applicationService;

	@GetMapping("/components")
	public ResponseEntity<List<ComponentBean>> getComponentsByApplicationName(
			@RequestParam("app") String applicationName) throws NotFoundException {
		return ResponseEntity.ok(componentService.getComponentsByApplicationId(
				applicationService.getApplicationByApplicationName(applicationName).getId()));
	}

	@GetMapping("/components/{applicationId}")
	public ResponseEntity<List<ComponentBean>> getComponentsByApplicationId(
			@PathVariable("applicationId") Integer applicationId) {
		return ResponseEntity.ok(componentService.getComponentsByApplicationId(applicationId));
	}

	@GetMapping("/component/{componentId}")
	public ResponseEntity<ComponentBean> getComponentById(@PathVariable("componentId") Integer componentId) throws NotFoundException {
		return ResponseEntity.ok(componentService.getComponentById(componentId));
	}

	@PostMapping("/component/{applicationName}")
	public ResponseEntity<ComponentBean> createComponent(@PathVariable("applicationName") String applicationName,
			@RequestBody ComponentBean componentBean) throws NotFoundException {
		componentBean.setApplication(applicationService.getApplicationByApplicationName(applicationName));

		return ResponseEntity.ok(componentService.createComponent(componentBean));

	}
}
