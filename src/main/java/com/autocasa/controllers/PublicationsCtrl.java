package com.autocasa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.autocasa.model.Publication;
import com.autocasa.service.PublicationService;

@Controller
@RequestMapping("/publications")
public class PublicationsCtrl {

	private PublicationService publicationService;
	
	@Autowired
	public PublicationsCtrl(PublicationService publicationService) {
		super();
		this.publicationService = publicationService;
	}
	
	@RequestMapping( value= {"/{pageNumber}"},method=RequestMethod.GET)
	public String publications(@PathVariable Integer pageNumber, Model model) {
		Page<Publication> page = publicationService.getPublication(pageNumber);
		
		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 4);
		int end = Math.min(begin + 8, page.getTotalPages());
		
		model.addAttribute("publications", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		
		return "shop";
	}
	
	@RequestMapping( value= {"/", ""},method=RequestMethod.GET)
	public String publicationsDefault() {
		return "redirect:/publications/1";
	}
	
	
}
