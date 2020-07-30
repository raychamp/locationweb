package com.champion.location.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.champion.location.entities.Location;
import com.champion.location.service.LocationService;

@Controller
public class LocationController {
	

	@Autowired
	LocationService service;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		System.out.println("In showCeate method");
		return "createLocation";
	}
	
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location locationSaved = service.saveLocation(location);
		String msg = "Location saved with id: " + locationSaved.getId();
		modelMap.addAttribute("msg", msg);
//		emailUtil.sendEmail("springxyzabc@gmail.com", "Location Saved",
//				"Location Saved Successfully and about to return a response");
		return "createLocation";
	}

}
