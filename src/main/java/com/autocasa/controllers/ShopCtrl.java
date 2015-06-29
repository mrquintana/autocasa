package com.autocasa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopCtrl {

	@RequestMapping(value= {"/shop"})
	public String showShop() {
		return "shop";
	}
	
	@RequestMapping(value= {"/shoph"})
	public String showShopH() {
		return "shop_h";
	}
}
