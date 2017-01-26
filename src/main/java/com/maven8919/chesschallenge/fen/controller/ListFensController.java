package com.maven8919.chesschallenge.fen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.maven8919.chesschallenge.fen.service.FenImporterService;

@Controller
public class ListFensController {

	@Autowired
	private FenImporterService fenImporterService;
	
	@GetMapping
	public String listFens(Model model) {
		model.addAttribute("fens", fenImporterService.getAllFens());
		return "list_fens";
	}
	
}
