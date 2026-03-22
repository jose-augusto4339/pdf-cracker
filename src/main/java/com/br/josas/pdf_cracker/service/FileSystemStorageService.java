package com.br.josas.pdf_cracker.service;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class FileSystemStorageService implements StorageService{

	@Value("${filesystem.location}")
	private String location;
	
	@Override
	public void init() {
	
		
	}

	@Override
	public void store(PDDocument file) {
	
			
	}

	@Override
	public Stream<Path> loadAll() {
	
		return null;
	}

	@Override
	public Resource loadAsResource(String filename) {
	
		return null;
	}

	@Override
	public void deleteAll() {
	
		
	}
	
	
}
