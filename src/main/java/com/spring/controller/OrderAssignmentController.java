package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.User;
import com.spring.model.Vehicle;
import com.spring.service.iface.IOrderAssignmentService;
import com.spring.service.iface.IVehicleService;

@Controller
public class OrderAssignmentController {

	@Autowired
	private IOrderAssignmentService mechanicService;
	
	@RequestMapping(value = "/mechaniclist", method = RequestMethod.GET)
	public String listUsers(ModelMap model) {
		List<User> users = mechanicService.getAllMechanic();
		model.addAttribute("mechanics", users);
		return "mechaniclist";
	}
	@RequestMapping(value = "/mechanic-{mechId}", method = RequestMethod.GET)
	public String editUser(@PathVariable int mechId, ModelMap model) {
		User user = mechanicService.getMechanicById(mechId);
		model.addAttribute("mechanic", user);
		List<Vehicle> vehicles = mechanicService.findAllSubmittedVehicle();
		model.addAttribute("vehicles", vehicles);
		return "mechanic";
	}
	@RequestMapping(value = "/select-vehicle-{mechId}-{vehicleId}", method = RequestMethod.GET)
	public String selectVehicle(@PathVariable int mechId, @PathVariable int vehicleId, ModelMap model) {
		mechanicService.saveAssignment(mechId, vehicleId);
		return "redirect:/mechaniclist";
	}
}
