package com.autocasa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutCtrl {

	@RequestMapping(value= {"/about"})
	public String showFaq() {
		return "about";
	}
}
