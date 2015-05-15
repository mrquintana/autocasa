package com.autocasa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Faq {

	@RequestMapping(value= {"/faq"})
	public String showFaq() {
		return "faq";
	}
}
