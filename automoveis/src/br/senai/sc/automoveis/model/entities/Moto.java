package br.senai.sc.automoveis.model.entities;

public class Moto extends Automovel {
	double alturaAssento, rake, vaoLivre;
	
	@Override
	public String toString() {
		return super.toString() + "\naltura_assento: " + alturaAssento + "\nrake: " + rake + "\nvao_livre: " + vaoLivre;
	}

	public Moto(int codigo, String marca, String modelo, double altura_assento, double rake, double vao_livre) {
		super(codigo, marca, modelo);
		this.alturaAssento = altura_assento;
		this.rake = rake;
		this.vaoLivre = vao_livre;
	}

	public Moto(int codigo, String marca, String modelo) {
		super(codigo, marca, modelo);
	}
	
}
