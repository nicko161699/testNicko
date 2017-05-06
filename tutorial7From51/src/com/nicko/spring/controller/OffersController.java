package com.nicko.spring.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nicko.spring.model.Offer;
import com.nicko.spring.service.OfferService;

@Controller
public class OffersController {

	@Autowired
	private OfferService service;

	// kalo pake Model
	@RequestMapping("/offers")
	public String showOffers(Model model) {
		List<Offer> lstOffer = service.getOffers();
		
		model.addAttribute("lstOffer", lstOffer);

		return "offers";
	}
	
	@RequestMapping("/create-offers")
	public String createOffers(Model model) {
		
		return "create-offers";
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String showTest(Model model, @RequestParam("id") String id) {
		System.out.println("ID is : " + id);
		
		return "home";
	}
	
	public OfferService getService() {
		return service;
	}

	public void setService(OfferService service) {
		this.service = service;
	}

}
