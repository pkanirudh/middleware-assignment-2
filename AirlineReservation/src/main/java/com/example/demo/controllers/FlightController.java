package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Flight;
import com.example.demo.models.User;
import com.example.demo.service.FlightService;


@Controller
public class FlightController {
	
	private long flightNumberSelected;
	@Autowired
	private Flight flight;

	@Autowired
	private FlightService service;
	
	@Autowired
	private ModelAndView mdlView;
	
	@GetMapping("/findFlights")
	public ModelAndView initForm() {
		
		mdlView.setViewName("findflight");
		mdlView.addObject("command", flight);
		return mdlView;
	}
	
	@PostMapping("/findMyFlight")
	public String onSubmit(@Valid @ModelAttribute("command") Flight flight,Model model, BindingResult result) {
	
		Iterable<Flight> flightList=this.service.findAll(flight.getSource(),flight.getDestination());
		
		this.service.reduceSeats(flight.getFlight_number());
		
		 model.addAttribute("flightlist", flightList);
		 	
			return "bookticket";
		 
//		 ${flightlist}
	}
	
	@RequestMapping("/enterDetails")
	public String enterCardDetails(@Valid @ModelAttribute("command") User user) {
		
		
		return "cardDetails";
	}
	
	
	@PostMapping("/validateCardDetails")
	public String onBooking(@Valid @ModelAttribute("command") User user,BindingResult result) {
		
		List<Integer> cvvList= new ArrayList<>();
		this.service.validateCardDetails(user.getCvv(),user.getCard_number(),user.getExpiry_date()).forEach(eachObject -> {
			cvvList.add(eachObject);
		});
		System.out.println(cvvList);
		if(!cvvList.isEmpty()) {
				//this.service.updateAvailableSeats();
				return "success";
		}
		else
			return "invalid";
	}
	
	

}
