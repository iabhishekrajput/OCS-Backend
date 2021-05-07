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
import com.merck.ocs.service.ApplicationService;

import javassist.NotFoundException;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://192.168.0.111:3000" })
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;

	@GetMapping("/applications")
	public ResponseEntity<List<ApplicationBean>> getAllApplications() {
		return ResponseEntity.ok(applicationService.getAllApplications());
	}

	@PostMapping("/application")
	public ResponseEntity<ApplicationBean> createApplication(@RequestBody ApplicationBean applicationBean) {
		return ResponseEntity.ok(applicationService.createApplication(applicationBean));
	}

	@GetMapping("/application/{applicationId}")
	public ResponseEntity<ApplicationBean> getApplicationById(@PathVariable Integer applicationId) throws NotFoundException {
		return ResponseEntity.ok(applicationService.getApplicationById(applicationId));
	}

	@GetMapping("/application")
	public ResponseEntity<ApplicationBean> getApplicationByApplicationName(@RequestParam("name") String applicationName) throws NotFoundException {
		return ResponseEntity.ok(applicationService.getApplicationByApplicationName(applicationName));
	}
}
