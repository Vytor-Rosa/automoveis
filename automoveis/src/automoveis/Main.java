package automoveis;

import br.senai.sc.automoveis.controller.AutomovelController;
import br.senai.sc.automoveis.controller.PessoaController;
import br.senai.sc.automoveis.exceptions.*;
import br.senai.sc.automoveis.model.entities.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author vytor_rosa
 */
public class Main {
    static Scanner tec = new Scanner(System.in);
    static ArrayList<Automovel> listaCarros = new ArrayList<Automovel>();
    static ArrayList<Automovel> listaMotos = new ArrayList<Automovel>();
    static ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
    static PessoaController pessoaController = new PessoaController();
    static AutomovelController automovelController = new AutomovelController();
    public static Pessoa usuario;

    /**
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException, InvalidoException {
        Dono dono1 = new Dono("Vytor", "123", "999.999.999-00", 1, 17, "clóvis");
        listaPessoas.add(dono1);
        login();
    }

    /**
     * @throws SQLException
     */
    private static void login() throws SQLException, InvalidoException {
        try {
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

            if (indice == -1) {
                throw new CodigoInvalido();
            }

            if (listaPessoas.get(indice).getSenha().equals(senha)) {
                System.out.println("BEM VINDO: " + listaPessoas.get(indice).getNome());
                menu();
            } else {
                System.out.println("matricula ou senha incorretos!");
                main(null);
            }
        } catch (Exception exception) {
            System.out.println("deu ruim \n"
                    + exception.getClass().getSimpleName() + ": " + exception.getMessage() + "\n");
        }
    }

    /**
     * @throws SQLException
     */
    private static void menu() throws SQLException, InvalidoException {
        System.out.println("1- menu Pessoa; \n2- menu Automóveis");
        int opcao = tec.nextInt();
        switch (opcao) {
            case 1:
                menuPessoa();
                break;
            case 2:
                menuAutomovel();
                break;
        }
    }

    /**
     * @throws SQLException
     */
    private static void menuPessoa() throws SQLException {
        System.out.println("1- Cadastrar; \n 2- Editar; \n3- Excluir; \n4- listar; \n5- finalizar.");
        int opcao = tec.nextInt();

        try {
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
                    listarPessoas();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    throw new InvalidoException();
            }
        } catch (Exception exception) {
            System.out.println("deu ruim \n"
                    + exception.getClass().getSimpleName() + ": " + exception.getMessage() + "\n");
        }

    }

    /**
     * @throws SQLException
     */
    private static void editarPessoa() throws SQLException {
        System.out.println("matricula: ");
        int matricula = tec.nextInt();

        System.out.println("novo nome: ");
        String nome = tec.next();
        System.out.println("nova senha: ");
        String senha = tec.next();
        System.out.println("nova matricula: ");
        int matriculaNova = tec.nextInt();
        System.out.println("novo cpf: ");
        String cpf = tec.next();
        System.out.println("nova idade: ");
        int idade = tec.nextInt();

        pessoaController.editar(matricula, nome, senha, cpf, matriculaNova, idade);
        menuPessoa();
    }

    /**
     * @throws SQLException
     */
    private static void excluirPessoa() throws SQLException {
        System.out.println("matricula: ");
        int matricula = tec.nextInt();

        System.out.println("1- sim; \n2- não");
        System.out.println("Deseja realmente excluir esse usuario: ");
        System.out.println(pessoaController.selecionarPorMatricula(matricula));
        int escolha = tec.nextInt();
        switch (escolha) {
            case 1:
                pessoaController.excluir(matricula);
                break;
            case 2:
                break;
        }
        menuPessoa();
    }

    /**
     * @throws SQLException
     */
    private static void listarPessoas() throws SQLException {
        System.out.println("1- Funcionario; \n2- Cliente");
        int opcao = tec.nextInt();

        switch (opcao) {
            case 1:
                System.out.println(pessoaController.selecionarPorTipo(opcao));
                break;
            case 2:
                System.out.println(pessoaController.selecionarPorTipo(opcao));
                break;
        }
        try {
            menuPessoa();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * @throws SQLException
     */
    private static void menuCadastrarPessoa() throws SQLException {
        System.out.println("1- funcionario; \2- cliente");
        int opcao = tec.nextInt();
        try {
            switch (opcao) {
                case 1:
                    listaPessoas.add(cadastrarPessoa(opcao));
                    break;
                case 2:
                    listaPessoas.add(cadastrarPessoa(opcao));
                    break;
                default:
                    throw new InvalidoException();
            }
        } catch (Exception exception) {
            System.out.println("deu ruim \n"
                    + exception.getClass().getSimpleName() + ": " + exception.getMessage() + "\n");
        }
        menuPessoa();
    }

    /**
     * @param opcao
     * @return
     * @throws SQLException
     */
    private static Pessoa cadastrarPessoa(int opcao) throws SQLException {
        try {
            System.out.println("nome: ");
            String nome = tec.next();
            System.out.println("senha: ");
            String senha = tec.next();
            System.out.println("matricula: ");
            int matricula = tec.nextInt();
            if (matricula < 1) {
                throw new CodigoInvalido();
            }
            System.out.println("cpf: ");
            String cpf = tec.next();
            System.out.println("idade: ");
            int idade = tec.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("aaa: ");
                    String aaa = tec.next();
                    pessoaController.cadastrar(nome, senha, cpf, matricula, idade);
                    return new Funcionario(nome, senha, cpf, matricula, idade, aaa);
                case 2:
                    return new Cliente(nome, senha, cpf, matricula, idade);
                default:
                    throw new InvalidoException();
            }
        } catch (Exception exception) {
            System.out.println("deu ruim \n"
                    + exception.getClass().getSimpleName() + ": " + exception.getMessage() + "\n");
        }
        return null;
    }

    /**
     * @throws SQLException
     */
    private static void menuAutomovel() throws SQLException, InvalidoException {
        System.out.println("1- Cadastrar; \n 2- Editar; \n3- Excluir; \n4- listar; \n5- finalizar.");
        int opcao = tec.nextInt();

        try {
            switch (opcao) {
                case 1:
                    cadastrarAutomovel();
                    break;
                case 2:
                    editarAutomovel();
                    break;
                case 3:
                    excluirAutomovel();
                    break;
                case 4:
                    listarAutomoveis();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    throw new InvalidoException();
            }
            menuAutomovel();
        } catch (Exception exception) {
            System.out.println("deu ruim \n"
                    + exception.getClass().getSimpleName() + ": " + exception.getMessage() + "\n");
        }
    }

    /**
     * @throws SQLException
     */
    private static void editarAutomovel() throws SQLException, InvalidoException {
        System.out.println("1- carro; \n2- moto.");
        String opcao = tec.next();
        System.out.println("codigo: ");
        int codigo = tec.nextInt();

        System.out.println("novo codigo: ");
        codigo = tec.nextInt();
        System.out.println("nova marca: ");
        String marca = tec.next();
        System.out.println("novo modelo: ");
        String modelo = tec.next();

        switch (opcao) {
            case "1":
                System.out.print("nova qtd portas: ");
                int portas = tec.nextInt();
                System.out.print("nova qtd lugares: ");
                int lugares = tec.nextInt();
                System.out.print("novo aro: ");
                String aro = tec.next();
                automovelController.editar(codigo, marca, modelo, opcao);
                break;

            case "2":
                System.out.print("nova altura do assento: ");
                double altura_assento = tec.nextDouble();
                System.out.print("novo rake: ");
                double rake = tec.nextDouble();
                System.out.print("novo tamanho do vao livre: ");
                double vao_livre = tec.nextDouble();
                automovelController.editar(codigo, marca, modelo, opcao);
                break;
        }
        menuAutomovel();
    }

    /**
     * @throws SQLException
     */
    private static void excluirAutomovel() throws SQLException {
        System.out.print("codigo: ");
        int codigo = tec.nextInt();
        automovelController.excluir(codigo);
    }

    /**
     * @return
     * @throws SQLException
     */
    private static Automovel cadastrarAutomovel() throws SQLException {
        try {
            System.out.println("1- carro; \n2- moto.");
            String opcao = tec.next();

            System.out.print("codigo: ");
            int codigo = tec.nextInt();
            if (codigo < 1) {
                throw new CodigoInvalido();
            }
            System.out.print("marca: ");
            String marca = tec.next();
            System.out.print("modelo: ");
            String modelo = tec.next();

            switch (opcao) {
                case "1":
                    automovelController.cadastrar(codigo, marca, modelo, opcao);
                    break;
                case "2":
                    automovelController.cadastrar(codigo, marca, modelo, opcao);
                    break;
            }
        } catch (Exception exception) {
            System.out.println("deu ruim \n"
                    + exception.getClass().getSimpleName() + ": " + exception.getMessage() + "\n");
        }
        return null;
    }

    /**
     * @throws SQLException
     */
    private static void listarAutomoveis() throws SQLException, InvalidoException {
        System.out.println(automovelController.selecionarTodos());
        menuAutomovel();
    }

}
