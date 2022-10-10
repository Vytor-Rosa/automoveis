package br.senai.sc.automoveis.model.factory;

import br.senai.sc.automoveis.model.entities.*;

public class AutomovelFactory {
    public Automovel getAutomoveis(Integer codigo, String marca, String modelo, String tipo) {
        switch (tipo) {
            case "1" -> {
                return new Carro(codigo, marca, modelo);
            }
            default -> {
                return new Moto(codigo, marca, modelo);
            }
        }
    }
}
