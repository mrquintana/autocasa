package com.autocasa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactCtrl {

	@RequestMapping(value= {"/contact"})
	public String showFaq() {
		return "contact";
	}
}
