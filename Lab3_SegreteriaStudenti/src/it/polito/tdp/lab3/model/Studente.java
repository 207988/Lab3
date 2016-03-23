package it.polito.tdp.lab3.model;

public class Studente {

	private String matricola;
	private String nome;
	private String cognome;
	private String cDs;
	
	public Studente(String matricola, String nome, String cognome, String cDs) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.cDs = cDs;
	}

	public String getMatricola() {
		return matricola;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getcDs() {
		return cDs;
	}
	
	
	
	
}
