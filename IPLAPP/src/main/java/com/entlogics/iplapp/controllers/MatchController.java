package com.entlogics.iplapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entlogics.iplapp.models.Match;
import com.entlogics.iplapp.services.IMatchService;

@Controller
public class MatchController {

	IMatchService iMatchService;

	@Autowired
	public void setiMatchService(IMatchService iMatchService) {
		this.iMatchService = iMatchService;
	}

	@RequestMapping("/matchForm")
	String matchForm(Model model) {

		System.out.println("Inside MatchController matchForm()");

		model.addAttribute("match", new Match());

		return "matchForm";
	}

	@RequestMapping("/addMatch")
	String createMatch(Model model, @ModelAttribute("match") Match match) {

		System.out.println("Inside MatchController createMatch()");

		// adding match using MatchService
		iMatchService.createMatch(match);

		// add this object in view to print newly created match id
		model.addAttribute("match", match);

		return "matchAdded";
	}

}
