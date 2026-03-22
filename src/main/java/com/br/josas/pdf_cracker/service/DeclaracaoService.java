package com.br.josas.pdf_cracker.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.br.josas.pdf_cracker.model.Declaracao;

@Service
public class DeclaracaoService {
	
	@Autowired
	private FileSystemStorageService storageService;
	
	
	public void uploadDeclaracoes(MultipartFile file) {
		
		try (InputStream inputStream = file.getInputStream();
				PDDocument declaracoes = Loader.loadPDF(inputStream.readAllBytes())){
			
			Splitter splitter = new Splitter();
			
			for(PDDocument declaracao : splitter.split(declaracoes)) {
				
				processaDeclaracao(declaracao);
								
				declaracao.close();
			}
			
			declaracoes.close();
		} catch (Exception e) {
			
		}
		
	}
	
	private void processaDeclaracao(PDDocument declaracao) throws IOException {
		PDFTextStripper stripper = new PDFTextStripper();
		String texto = stripper.getText(declaracao);
		
		String[] linhas = texto.split("\\r?\\n");
		Pattern pattern = Pattern.compile(
					"(.*?)\\s+(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})\\s+(\\d{2}/\\d{2}/\\d{4})\\s+R\\$\\s+([\\d.,]+)"
				);
		
		for (String linha : linhas) {
			Matcher matcher = pattern.matcher(linha);
			
			if (matcher.find()) {
				
				if(isTitular(linha)) {
					Declaracao declaracaoInfo = new Declaracao();
					
					declaracaoInfo.setNomeTitular(matcher.group(1));
					declaracaoInfo.setDocumentoTitular(matcher.group(2));
					declaracaoInfo.setDataNascimento(null /*matcher.group(3)*/);
					declaracaoInfo.setNomeArquivo(matcher.group(2) + "2009");
					
					storageService.store(declaracao);
				}
			}
		}
	}

	private boolean isTitular(String linha) {
		// TODO Auto-generated method stub
		return true;
	}
}
