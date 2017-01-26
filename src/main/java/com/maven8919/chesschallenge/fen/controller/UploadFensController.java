package com.maven8919.chesschallenge.fen.controller;

import java.io.File;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maven8919.chesschallenge.fen.domain.Fen;
import com.maven8919.chesschallenge.fen.service.FenImporterService;

@Controller
public class UploadFensController {

	@Autowired
	private FenImporterService fenImporterService;

	@GetMapping(value = "/upload_fen")
	public String uploadFen() {
		return "upload_fen";
	}

	@PostMapping(value = "/upload_fen")
	public String processUploadedFile(@RequestParam("filePath") String filePath, Model model) {
		File fensFile = new File(filePath);
		Set<Fen> uniqueFens = fenImporterService.getUniqueFenPositionsFromFile(fensFile);
		uniqueFens.stream()
			.filter(fen -> fenImporterService.notInDb(fen))
			.forEach(fenImporterService::saveFen);
		model.addAttribute("unique fens size", uniqueFens.size());
		return "redirect:/list_fens";
	}

}
