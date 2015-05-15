package com.autocasa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemCtrl {

	@RequestMapping(value= {"/item"})
	public String showItem() {
		return "item";
	}
}
