package com.tristan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tristan.services.ApplicationService;

@RestController
@RequestMapping("/Application")
public class ApplicationController {

	@Autowired
	private ApplicationService aservice;
}
