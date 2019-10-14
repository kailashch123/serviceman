package com.spring.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.model.User;
import com.spring.model.Vehicle;
import com.spring.service.iface.IUserService;
import com.spring.service.iface.IVehicleService;
import com.spring.util.AppUtil;

@Controller
public class VehicleController {

	@Autowired
	private IVehicleService vehicleService;
	@Autowired
	private IUserService userService;
	
	@ModelAttribute("years")
	public List<Integer> initYears() {
		LocalDate date = LocalDate.now();
		int currentYear = date.getYear();
		int startYear = currentYear - 15;
		List<Integer> years = new ArrayList<Integer>();
		for(int i = startYear; i <= currentYear; i++) {
			years.add(i);
		}
		return years;
	}
	@RequestMapping(value = "/vehiclelist", method = RequestMethod.GET)
	public String allVehicle(ModelMap model) {
		List<Vehicle> vehicles = vehicleService.findAllVehicle();
		model.addAttribute("vehicles", vehicles);
		return "vehiclelist";
	}

	@RequestMapping(value = "/vehicles/{vehicleId}", method = RequestMethod.GET)
	public String getVehicleById(int vehicleId, ModelMap model) {
		Vehicle vecicle = vehicleService.findVehicleById(vehicleId);
		model.addAttribute("vehicle", vecicle);
		return "";
	}

	@RequestMapping(value = "/vehicles", method = RequestMethod.POST)
	public String newVehiclePost(Vehicle vehicle, ModelAndView mv) {
		vehicleService.saveVehicle(vehicle);
		return "redirect:/vehicles";

	}

	@RequestMapping(value = "/vehicles-{userId}", method = RequestMethod.GET)
	public String findAllByUserId(@PathVariable("userId") int userId, ModelMap model) {
		List<Vehicle> vehicles = vehicleService.findAllByUserId(userId);
		model.addAttribute("vehicles", vehicles);
		return "vehiclelist";
	}

	@RequestMapping(value = "/edit-vehicle-{vehicleId}", method = RequestMethod.GET)
	public String editVehicle(@PathVariable("vehicleId") int vehicleId, ModelMap model) {
		Vehicle vehicle = vehicleService.findVehicleById(vehicleId);
		vehicle.setUserString(AppUtil.createOwnerString(vehicle.getUser()));
		model.addAttribute("vehicle", vehicle);
		return "vehicle";
	}
	@RequestMapping(value = "/edit-vehicle-{vehicleId}", method = RequestMethod.POST)
	public String updateVehicle(Vehicle vehicle, ModelMap model) {
		vehicleService.updateVehicle(vehicle);
		vehicle.setUserString(AppUtil.createOwnerString(vehicle.getUser()));
		model.addAttribute("vehicle", vehicle);
		return "vehiclelist";
	}
	@RequestMapping(value = "/delete-vehicle-{vehicleId}", method = RequestMethod.GET)
	public String deleteVehicle(int vehicleId) {
		vehicleService.deleteVehicle(vehicleId);
		return "redirect:/vehicles";
	}
	
	@RequestMapping(value = "/newvehicle", method = RequestMethod.GET)
	public String newVehicle(ModelMap model) {
		model.addAttribute("vehicle", new Vehicle());
		return "vehicle";
	}
	
	@RequestMapping(value = "/newvehicle", method=RequestMethod.POST)
	public String newVehicle(Vehicle vehicle) {
		String str = vehicle.getUserString();
		String emailStr = str.substring(str.indexOf("(")+1, str.indexOf(")"));
		User user = userService.findUserByEmail(emailStr);
		vehicle.setUser(user);
		vehicle.setStatus("INACTIVE");
		vehicleService.saveVehicle(vehicle);
		return "redirect:/vehiclelist";
		
	}
	
	@RequestMapping(value = "/user/search", method = RequestMethod.GET, headers="Accept=*/*")
	public @ResponseBody List<String> getTechList(@RequestParam("term") String query) {
		List<String> countryList = userService.search(query);
		return countryList;
	}

}
