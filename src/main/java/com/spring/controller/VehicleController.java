package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Vehicle;
import com.spring.service.iface.IUserService;
import com.spring.service.iface.IVehicleService;

@Controller
public class VehicleController {

	@Autowired
	private IVehicleService vehicleService;
	
	@RequestMapping(value = "/vehicles", method = RequestMethod.GET)
	public ModelAndView allVehicle(ModelAndView mv) {
		List<Vehicle> vehicles = vehicleService.findAllVehicle();
		mv.addObject("vehicles", vehicles);
		mv.setViewName("vehicleList");
		return mv;
	}

	@RequestMapping(value = "/vehicles/{vehicleId}", method = RequestMethod.GET)
	public ModelAndView getVehicleById(int vehicleId, ModelAndView mv) {
		Vehicle vecicle = vehicleService.findVehicleById(vehicleId);
		mv.addObject("vehicle", vecicle);
		mv.setViewName("vehicleDetail");
		return mv;
	}

	@RequestMapping(value = "/vehicles", method = RequestMethod.POST)
	public String newVehiclePost(Vehicle vehicle, ModelAndView mv) {
		vehicleService.saveVehicle(vehicle);
		return "redirect:/vehicles";

	}

	@RequestMapping(value = "/vehicles-{userId}", method = RequestMethod.GET)
	public ModelAndView findAllByUserId(@PathVariable("userId") int userId, ModelAndView mv) {
		List<Vehicle> vehicles = vehicleService.findAllByUserId(userId);
		mv.addObject("vehicles", vehicles);
		mv.setViewName("vehicleList");
		return mv;
	}

	@RequestMapping(value = "/editVehicle/{vehicleId}", method = RequestMethod.GET)
	public ModelAndView editVehicle(int vehicleId, ModelAndView mv) {
		Vehicle vehicle = vehicleService.findVehicleById(vehicleId);
		mv.addObject("vehicle", vehicle);
		mv.setViewName("vehicleDetial");
		return mv;
	}

	@RequestMapping(value = "/deleteVehicle/{vehicleId}", method = RequestMethod.GET)
	public String deleteVehicle(int vehicleId) {
		vehicleService.deleteVehicle(vehicleId);
		return "redirect:/vehicles";
	}
	
	@RequestMapping(value = "/searchOwner", method = RequestMethod.GET)
	@ResponseBody
	public List<String> search(HttpServletRequest request) {
		return vehicleService.searchOwner(request.getParameter("term"));
	}
	
	@RequestMapping(value = "/newVehicle", method = RequestMethod.GET)
	public ModelAndView newVehicle(ModelAndView mv) {
		mv.addObject("vehicle", new Vehicle());
		mv.setViewName("newVehicle");
		return mv;
	}
	
	@RequestMapping(value = "/newVehicle", method=RequestMethod.POST)
	public String newUserPost(Vehicle vehicle, ModelAndView mv) {
		vehicleService.saveVehicle(vehicle);
		mv.setViewName("listUser");
		return "redirect:/getAllUsers";
		
	}

}
