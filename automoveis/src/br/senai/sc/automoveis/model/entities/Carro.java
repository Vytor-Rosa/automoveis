package br.senai.sc.automoveis.model.entities;

public class Carro extends Automovel {
	int portas, lugares; 
	String aro;
	
	@Override
	public String toString() {
		return super.toString() + "\nportas: " + portas + "\nlugares: " + lugares + "\naro: " + aro;
	}
	public Carro(int codigo, String marca, String modelo, int portas, int lugares, String aro) {
		super(codigo, marca, modelo);
		this.portas = portas;
		this.lugares = lugares;
		this.aro = aro;
	}
	public Carro(int codigo, String marca, String modelo) {
		super(codigo, marca, modelo);
	}
	
}
