package com.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.MyOrder;
import com.spring.service.iface.IOrderService;
import com.spring.util.AppUtil;

@Controller
public class OrderController {

	@Autowired
	private IOrderService orderService;
	
	@ModelAttribute("delTimes")
	public List<String> initDelTimes() {
		return AppUtil.initTime();
	}

	@RequestMapping(value = "/orderlist", method = RequestMethod.GET)
	public String listOrders(ModelMap model) {
		List<MyOrder> orders = orderService.findAll();
		model.addAttribute("orders", orders);
		return "orderlist";
	}

	@RequestMapping(value = { "/neworder" }, method = RequestMethod.GET)
	public String newOrder(ModelMap model) {
		model.addAttribute("order", new MyOrder());
		model.addAttribute("edit", false);
		return "order";
	}

	@RequestMapping(value = { "/neworder" }, method = RequestMethod.POST)
	public String saveOrder(@Valid MyOrder order, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "order";
		}
		String custRec = order.getCustomerRecomendation();
		custRec = custRec.replaceAll(",", "<br/>");
		order.setCustomerRecomendation(custRec);
		
		String obsRec = order.getObserverRecomendation();
		obsRec = obsRec.replaceAll(",", "<br/>");
		order.setObserverRecomendation(obsRec);
		
		orderService.saveOrder(order);
		return "redirect:/orderlist";
	}

	@RequestMapping(value = "/edit-order-{orderId}", method = RequestMethod.GET)
	public String editOrder(@PathVariable int orderId, ModelMap model) {
		MyOrder order = orderService.findById(orderId);
		model.addAttribute("order", order);
		model.addAttribute("edit", true);
		return "order";
	}

	@RequestMapping(value = "/edit-order-{orderId}", method = RequestMethod.POST)
	public String updateOrder(@Valid MyOrder order, BindingResult result, ModelMap model, @PathVariable int orderId) {
		if (result.hasErrors()) {
			return "order";
		}
		MyOrder temp = orderService.findById(order.getOrderId());
		if (order.getCustomerName() != null)
			temp.setCustomerName(order.getCustomerName());
		if (order.getCustomerMobile() != null)
			temp.setCustomerMobile(order.getCustomerMobile());
		if (order.getCustomerEmail() != null)
			temp.setCustomerEmail(order.getCustomerEmail());
		if (order.getVehicleBrand() != null)
			temp.setVehicleBrand(order.getVehicleBrand());
		if (order.getVehicleModel() != null)
			temp.setVehicleModel(order.getVehicleModel());
		if (order.getCustomerRecomendation() != null)
			temp.setCustomerRecomendation(order.getCustomerRecomendation());
		if (order.getObserverRecomendation() != null)
			temp.setObserverRecomendation(order.getObserverRecomendation());
		if (order.getExpectedServiceCost() != temp.getExpectedServiceCost())
			temp.setExpectedServiceCost(order.getExpectedServiceCost());
		if (order.getDeliveryDateTime() != null)
			temp.setDeliveryDateTime(order.getDeliveryDateTime());

		orderService.update(temp);
		return "redirect:/orderlist";
	}

	@RequestMapping(value = "/delete-order-{orderId}", method = RequestMethod.GET)
	public String deleteOrder(@PathVariable int orderId) {
		orderService.deleteOrderById(orderId);
		return "redirect:/orderIdlist";
	}
}
