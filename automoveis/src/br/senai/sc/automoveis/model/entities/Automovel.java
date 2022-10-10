package br.senai.sc.automoveis.model.entities;

import br.senai.sc.automoveis.model.factory.*;

public class Automovel {
    String marca, modelo;
    int codigo;

    public static Automovel cadastrar(String marca, String modelo, int codigo, String tipo) {
        if (tipo.equals("1")) {
            return new AutomovelFactory().getAutomoveis(codigo, marca, modelo, tipo);
        }
        return new AutomovelFactory().getAutomoveis(codigo, marca, modelo, tipo);
    }

    public static Automovel editar(String marca, String modelo, Integer codigo, String tipo) {
        return new AutomovelFactory().getAutomoveis(codigo, modelo, marca, tipo);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
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

}
