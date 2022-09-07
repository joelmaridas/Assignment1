package com.tristan.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.tristan.models.ClientMessage;
import com.tristan.models.Place;
import com.tristan.services.PlaceService;

import static com.tristan.util.ClientMessageUtil.*;

@RestController
public class PlaceController {
	
	@Autowired
	private PlaceService pservice;
	
	@PostMapping("/place")
	public @ResponseBody ClientMessage createPlace(@RequestBody Place place) {
		int code = pservice.createPlace(place);
		switch (code) {
		case 1:
			return CREATION_SUCCESSFUL;
		case 0:
			return CREATION_FAILED;
		case -1:
			return ENTITY_ALREADY_EXISTS;
		}
		
		return null;
	}
	
	@DeleteMapping("/place")
	public @ResponseBody ClientMessage deletePlace(@RequestBody Place place) {
		return pservice.deletePlace(place) ? DELETION_SUCCESSFUL : DELETION_FAILED;
	}
}
