package com.br.josas.pdf_cracker.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.core.io.Resource;

public interface StorageService {

	void init();
	
	void store(Object... file);
	
	Stream<Path> loadAll();
	
	Resource loadAsResource(String filename);
	
	void deleteAll();
}
