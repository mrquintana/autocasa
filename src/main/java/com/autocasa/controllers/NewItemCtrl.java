package com.autocasa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewItemCtrl {

	@RequestMapping(value="/newitem")
	public String showNewItem() {
		return "newitem";
	}
}
