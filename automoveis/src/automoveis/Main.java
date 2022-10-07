package automoveis;

import br.senai.sc.automoveis.controller.PessoaController;
import br.senai.sc.automoveis.model.entities.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner tec = new Scanner(System.in);
	static ArrayList<Automovel> listaCarros = new ArrayList<Automovel>();
	static ArrayList<Automovel> listaMotos = new ArrayList<Automovel>();
	static ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	static PessoaController controller = new PessoaController();
	public static Pessoa usuario;
 
	public static void main(String[] args) throws SQLException {
		Dono dono1 = new Dono("Vytor", "123", "999.999.999-00", 1, 17, "clóvis");
		listaPessoas.add(dono1);
		
		login();
	}

	private static void login() throws SQLException {
		int indice = -1;
		
		System.out.println("matricula: ");
		int matricula = tec.nextInt();
		System.out.println("senha: ");
		String senha = tec.next();
		
		for (int i = 0; i < listaPessoas.size(); i++) {
			if (listaPessoas.get(i).getMatricula() == matricula) {
				indice = i;
				usuario = listaPessoas.get(i);
			}
		}
		
		if(listaPessoas.get(indice).getSenha().equals(senha)) {
			System.out.println("BEM VINDO: " + listaPessoas.get(indice).getNome());
			menu();
		}else {
			System.out.println("matricula ou senha incorretos!");
			main(null);
		}
		
		
	}
	
	private static void menu() throws SQLException {
		System.out.println("1- menu Pessoa; \n2- menu Automóveis");
		int opcao = tec.nextInt();
		switch (opcao) {
		case 1:
			menuPessoa();
			break;
		case 2:
			menuAuto();
			break;
		}
	}
	
	private static void menuPessoa() throws SQLException {
		System.out.println("1- Cadastrar; \n 2- Editar; \n3- Excluir; \n4- listar; \n5- finalizar.");
		int opcao = tec.nextInt();

		switch (opcao) {
		case 1:
			menuCadastrarPessoa();
			break;
		case 2:
			editarPessoa();
			break;
		case 3:
			excluirPessoa();
			break;
		case 4:
			listarPessoa();
			break;
		case 5:
			System.exit(0);
			break;
		}

	}

	private static void editarPessoa() throws SQLException {
		
		int indice = -1;
		
		System.out.println("1- dono; \n2- cliente.");
		int opcao = tec.nextInt();
		System.out.println("matricula: ");
		int matricula = tec.nextInt();
		
		System.out.println("novo nome: ");
		String nome = tec.next();
		System.out.println("nova senha: ");
		String senha = tec.next();
		System.out.println("nova matricula: ");
		int matricula1 = tec.nextInt();
		System.out.println("novo cpf: ");
		String cpf = tec.next();
		System.out.println("nova idade: ");
		int idade  = tec.nextInt();
		
		switch (opcao) {
		case 1:
			for (int i = 0; i < listaPessoas.size(); i++) {
				if (listaPessoas.get(i).getMatricula() == matricula) {
					indice = i;
				}
			}
			System.out.println("novo aaa: ");
			String aaa = tec.next();
			
			Dono dono = new Dono(nome, senha, cpf, matricula1, idade, aaa);
			listaPessoas.set(indice, dono);
			break;
			
		case 2:
			for (int i = 0; i < listaPessoas.size(); i++) {
				if (listaPessoas.get(i).getMatricula() == matricula) {
					indice = i;
				}
			}
			System.out.println("novo bbb: ");
			String bbb = tec.next();
			
			Funcionario funcionario = new Funcionario(nome, senha, cpf, matricula1, idade, bbb);
			listaPessoas.set(indice, funcionario);
			break;
		}
		menuPessoa();
	}

	private static void excluirPessoa() throws SQLException {
		System.out.println("matricula: ");
		int matricula = tec.nextInt();

			System.out.println("1- sim; \n2- não");
			System.out.println("Deseja realmente excluir esse usuario: ");
			System.out.println(controller.selecionarPorMatricula(matricula));
			int escolha = tec.nextInt();
			switch (escolha) {
			case 1:
				controller.excluir(matricula);
				break;
			case 2:
				break;
			}
		menuPessoa();
	}

	private static void listarPessoa() throws SQLException {
		System.out.println("1- Funcionario; \2- Cliente");
		int opcao = tec.nextInt();

		switch (opcao) {
		case 1:
				System.out.println(controller.selecionarTodos());
			break;
		case 2:
			for (int i = 0; i < listaPessoas.size(); i++) {
				System.out.println("=========================");
				System.out.println(listaPessoas.get(i).toString());
				System.out.println("=========================");
			}
			break;
		}
		try {
			menuPessoa();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	private static void menuCadastrarPessoa() throws SQLException {
		System.out.println("1- funcionario; \2- cliente");
		int opcao = tec.nextInt();

		switch (opcao) {
		case 1:
			listaPessoas.add(cadastrarPessoa(opcao));
			break;
		case 2:
			listaPessoas.add(cadastrarPessoa(opcao));
			break;
		}
		menuPessoa();
	}

	private static Pessoa cadastrarPessoa(int opcao) throws SQLException {
		System.out.println("nome: ");
		String nome = tec.next();
		System.out.println("senha: ");
		String senha = tec.next();
		System.out.println("matricula: ");
		int matricula = tec.nextInt();
		System.out.println("cpf: ");
		String cpf = tec.next();
		System.out.println("idade: ");
		int idade = tec.nextInt();

		switch (opcao) {
		case 1:
			System.out.println("aaa: ");
			String aaa = tec.next();
			controller.cadastrar(nome, senha, cpf, matricula, idade);
			return new Funcionario(nome, senha, cpf, matricula, idade, aaa);
		case 2:
			return new Cliente(nome, senha, cpf, matricula, idade);
		}
		return null;
	}

	private static void menuAuto() {
		System.out.println("1- Cadastrar; \n 2- Editar; \n3- Excluir; \n4- listar; \n5- finalizar.");
		int opcao = tec.nextInt();

		switch (opcao) {
		case 1:
			menuCadastrar();
			break;
		case 2:
			editar();
			break;
		case 3:
			excluir();
			break;
		case 4:
			listar();
			break;
		case 5:
			System.exit(0);
			break;
		}
	}

	private static void editar() {
		int indice = -1;

		System.out.println("1- carro; \n2- moto.");
		int opcao = tec.nextInt();
		System.out.println("codigo: ");
		int codigo = tec.nextInt();

		switch (opcao) {
		case 1:
			for (int i = 0; i < listaCarros.size(); i++) {
				if (listaCarros.get(i).getCodigo() == codigo) {
					indice = i;
				}
			}
			break;
		case 2:
			for (int i = 0; i < listaMotos.size(); i++) {
				if (listaMotos.get(i).getCodigo() == codigo) {
					indice = i;
				}
			}
			break;
		}

		System.out.println("novo codigo: ");
		codigo = tec.nextInt();
		System.out.println("nova marca: ");
		String marca = tec.next();
		System.out.println("novo modelo: ");
		String modelo = tec.next();

		switch (opcao) {
		case 1:
			System.out.print("nova qtd portas: ");
			int portas = tec.nextInt();
			System.out.print("nova qtd lugares: ");
			int lugares = tec.nextInt();
			System.out.print("novo aro: ");
			String aro = tec.next();

			Carro Tcarro = new Carro(codigo, marca, modelo, portas, lugares, aro);
			listaCarros.set(indice, Tcarro);
			break;

		case 2:
			System.out.print("nova altura do assento: ");
			double altura_assento = tec.nextDouble();
			System.out.print("novo rake: ");
			double rake = tec.nextDouble();
			System.out.print("novo tamanho do vao livre: ");
			double vao_livre = tec.nextDouble();

			Moto Tmoto = new Moto(codigo, marca, modelo, altura_assento, rake, vao_livre);
			listaCarros.set(indice, Tmoto);
			break;
		}
		menuAuto();
	}

	private static void menuCadastrar() {
		System.out.println("1- carro; \n2- moto.");
		int opcao = tec.nextInt();

		switch (opcao) {
		case 1:
			listaCarros.add(cadastrar(opcao));
			break;
		case 2:
			listaMotos.add(cadastrar(opcao));
			break;
		}
		menuAuto();
	}

	private static void excluir() {
		System.out.print("1- carro; \n2- moto.");
		int opcao = tec.nextInt();
		System.out.print("codigo: ");
		int codigo = tec.nextInt();

		int indice = -1;

		switch (opcao) {
		case 1:
			for (int i = 0; i < listaCarros.size(); i++) {
				if (listaCarros.get(i).getCodigo() == codigo) {
					indice = i;
				}
			}
			listaCarros.remove(indice);
			break;
		case 2:
			for (int i = 0; i < listaMotos.size(); i++) {
				if (listaMotos.get(i).getCodigo() == codigo) {
					indice = i;
				}
				listaMotos.remove(indice);
				break;
			}
		}
	}

	private static Automovel cadastrar(int opcao) {
		System.out.print("codigo: ");
		int codigo = tec.nextInt();
		System.out.print("marca: ");
		String marca = tec.next();
		System.out.print("modelo: ");
		String modelo = tec.next();

		switch (opcao) {
		case 1:
			System.out.print("qtd portas: ");
			int portas = tec.nextInt();
			System.out.print("qtd lugares: ");
			int lugares = tec.nextInt();
			System.out.print("aro: ");
			String aro = tec.next();
			return new Carro(codigo, marca, modelo, portas, lugares, aro);
		case 2:
			System.out.print("altura do assento: ");
			double altura_assento = tec.nextDouble();
			System.out.print("rake: ");
			double rake = tec.nextDouble();
			System.out.print("vao livre: ");
			double vao_livre = tec.nextDouble();
			return new Moto(codigo, marca, modelo, altura_assento, rake, vao_livre);
		}
		return null;
	}

	private static void listar() {
		System.out.println("1- carro; \n2- moto.");
		int opcao = tec.nextInt();

		switch (opcao) {
		case 1:
			for (int i = 0; i < listaCarros.size(); i++) {
				System.out.println(listaCarros.get(i).toString());
			}
		case 2:
			for (int i = 0; i < listaMotos.size(); i++) {
				System.out.println(listaMotos.get(i).toString());
			}
		}
		menuAuto();
	}

}
