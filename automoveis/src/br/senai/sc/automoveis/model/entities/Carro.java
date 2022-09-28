package br.senai.sc.automoveis.model.entities;

public class Carro extends Automovel {
	int portas, lugares; 
	String aro;
	
	@Override
	public String toString() {
		return super.toString() + "\nportas: " + portas + "\nlugares: " + lugares + "\naro: " + aro;
	}
	public int getPortas() {
		return portas;
	}
	public void setPortas(int portas) {
		this.portas = portas;
	}
	public int getLugares() {
		return lugares;
	}
	public void setLugares(int lugares) {
		this.lugares = lugares;
	}
	public String getAro() {
		return aro;
	}
	public void setAro(String aro) {
		this.aro = aro;
	}
	public Carro(int codigo, String marca, String modelo, int portas, int lugares, String aro) {
		super(codigo, marca, modelo);
		this.portas = portas;
		this.lugares = lugares;
		this.aro = aro;
	}
	public Carro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Carro(int codigo, String marca, String modelo) {
		super(codigo, marca, modelo);
	}
	
}
