package com.br.josas.pdf_cracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.br.josas.pdf_cracker.service.DeclaracaoService;

@RestController
@RequestMapping("/declaracao")
public class DeclaracaoController {
	
	@Autowired
	private DeclaracaoService declaracaoService;

	@PostMapping("/upload")
	public ResponseEntity<Void> uploadDeclaracoes(@RequestParam(name = "file") MultipartFile file){
		
		declaracaoService.uploadDeclaracoes(file);
		
		return ResponseEntity.ok().build();
	}
}
