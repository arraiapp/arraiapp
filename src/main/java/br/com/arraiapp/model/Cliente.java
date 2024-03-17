package br.com.arraiapp.model;

import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private float creditos;
	private ArrayList<Ficha> fichas;
	
	
	public Cliente(String nome, String email, String senha, String cpf) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public float getCreditos() {
		return creditos;
	}
	public void setCreditos(float creditos) {
		this.creditos = creditos;
	}
	public ArrayList<Ficha> getFichas() {
		return fichas;
	}
	public void setFichas(ArrayList<Ficha> fichas) {
		this.fichas = fichas;
	}
	
	
	
	
}
