package com.br.josas.pdf_cracker.model;


import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Declaracao {
	
	@Id
	private Long declaracaoId;
	
	private String nomeTitular;
	
	private String documentoTitular;
	
	private Date dataNascimento;
	
	private String email;
	
	private String nomeArquivo;

	public Declaracao() {
	}

	public Long getDeclaracaoId() {
		return declaracaoId;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getDocumentoTitular() {
		return documentoTitular;
	}

	public void setDocumentoTitular(String documentoTitular) {
		this.documentoTitular = documentoTitular;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataNascimento, declaracaoId, documentoTitular, email, nomeArquivo, nomeTitular);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Declaracao other = (Declaracao) obj;
		return Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(declaracaoId, other.declaracaoId)
				&& Objects.equals(documentoTitular, other.documentoTitular) && Objects.equals(email, other.email)
				&& Objects.equals(nomeArquivo, other.nomeArquivo) && Objects.equals(nomeTitular, other.nomeTitular);
	}
		
}
