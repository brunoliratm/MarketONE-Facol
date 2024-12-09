package gui;

import java.util.Scanner;
import models.Funcionario;
import services.FuncionarioService;
import services.ProdutoService;

public class FuncionarioMenu {
    static ProdutoService produtoService = new ProdutoService();

    public static void menu(Scanner sc, Funcionario funcionario) {
        System.out.println("Bem-vindo ao menu do funcionário!");
        System.out.println("1 - Listar produtos");
        System.out.println("2 - Adicionar produto");
        System.out.println("3 - Editar produto");
        System.out.println("4 - Remover produto");
        System.out.println("5 - Listar clientes");
        System.out.println("6 - Remover cliente");
        System.out.println("7 - Dados do funcionário");
        System.out.println("0 - Sair");

        String opcao = sc.next();

        switch (opcao) {
            case "1":
                FuncionarioService.listarProdutos();
                menu(sc, funcionario);
                break;
            case "2":
                FuncionarioService.adicionarProduto(sc);
                menu(sc, funcionario);
                break;
            case "3":
                FuncionarioService.editarProduto(sc);
                menu(sc, funcionario);
                break;
            case "4":
                FuncionarioService.removerProduto(sc);
                menu(sc, funcionario);
                break;
            case "5":

                break;
            case "6":
                System.out.println("Remover cliente");
                break;
            case "7":
                System.out.println("Dados do funcionário");
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("Email: " + funcionario.getEmail());
                System.out.println("Telefone: " + funcionario.getTelefone());
                break;
            case "0":
                System.out.println("Saindo do menu do funcionário...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    
}
