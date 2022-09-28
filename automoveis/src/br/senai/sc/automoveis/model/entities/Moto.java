package br.senai.sc.automoveis.model.entities;

public class Moto extends Automovel {
	double altura_assento, rake, vao_livre;
	
	@Override
	public String toString() {
		return super.toString() + "\naltura_assento: " + altura_assento + "\nrake: " + rake + "\nvao_livre: " + vao_livre;
	}

	public double getAltura_assento() {
		return altura_assento;
	}

	public void setAltura_assento(double altura_assento) {
		this.altura_assento = altura_assento;
	}

	public double getRake() {
		return rake;
	}

	public void setRake(double rake) {
		this.rake = rake;
	}

	public double getVao_livre() {
		return vao_livre;
	}

	public void setVao_livre(double vao_livre) {
		this.vao_livre = vao_livre;
	}

	public Moto(int codigo, String marca, String modelo, double altura_assento, double rake, double vao_livre) {
		super(codigo, marca, modelo);
		this.altura_assento = altura_assento;
		this.rake = rake;
		this.vao_livre = vao_livre;
	}

	public Moto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Moto(int codigo, String marca, String modelo) {
		super(codigo, marca, modelo);
	}
	
}
