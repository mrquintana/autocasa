package com.autocasa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.autocasa.model.Publication;
import com.autocasa.repositories.PublicationRepository;

@Controller
@RequestMapping(value="/item")
public class ItemCtrl {

	@Autowired
	private PublicationRepository publicationRepository;
	@RequestMapping(value= {"/{itemNumber}"})
	public String showItem(@PathVariable Long itemNumber, Model model) {
		Publication publication = publicationRepository.findOne(itemNumber);
		model.addAttribute("publication", publication);
		return "item";
	}
	
	@RequestMapping(value= {"/itemh"})
	public String showItemh() {
		return "item_h";
	}
}
