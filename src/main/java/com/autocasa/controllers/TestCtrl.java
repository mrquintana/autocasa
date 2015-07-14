package com.autocasa.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.autocasa.model.Test;
import com.autocasa.repositories.TestRepo;

@Controller
@RequestMapping("/testdb")
public class TestCtrl {

	
	private TestRepo testRepo;
	
	@Autowired
	public TestCtrl(TestRepo testRepo) {
		super();
		this.testRepo = testRepo;
	}


	@RequestMapping(method = RequestMethod.GET)
	public String testdb(Map<String, Object> model) {
		List<Test> lt = testRepo.findAll();
		model.put("contacts", lt);
		return "testdb";
	}
}
