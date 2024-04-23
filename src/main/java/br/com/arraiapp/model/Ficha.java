package br.com.arraiapp.model;

public class Ficha {
	
	private Integer id;
	private float valor;

	public Ficha(float valor) {
		super();
		this.valor = valor;
	}
	
	public Integer getId() {
		return id;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
}
