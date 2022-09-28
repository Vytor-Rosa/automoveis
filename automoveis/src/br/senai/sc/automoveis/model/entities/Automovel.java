package br.senai.sc.automoveis.model.entities;

public class Automovel {
	String marca, modelo;
	int codigo;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Automovel(int codigo, String marca, String modelo) {
		super();
		this.codigo = codigo;
		this.marca = marca;
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "codigo: " + codigo + "\nmarca: " + marca + "\nmodelo: " + modelo;
	}

	public Automovel() {
		super();
	}
	
}
