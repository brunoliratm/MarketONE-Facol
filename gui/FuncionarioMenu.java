package gui;

import java.util.Scanner;
import models.Funcionario;
import models.Produto;
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
                listarProdutos();
                break;
            case "2":
                adicionarProduto(sc);
                break;
            case "3":
                editarProduto(sc);
                break;
            case "4":
                removerProduto(sc);
                break;
            case "5":
                System.out.println("Listar clientes");
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

    private static void listarProdutos() {
        for (Produto produto : produtoService.listarProdutos()) {
            System.out.println("ID: " + produto.getId());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("Quantidade: " + produto.getQuantidade());
            System.out.println("Marca: " + produto.getMarca());
            System.out.println();
        }
    }

    private static void adicionarProduto(Scanner sc) {
        System.out.println("Adicionar produto");
        System.out.print("Nome: ");
        String nome = sc.next();
        System.out.print("Preço: ");
        float preco = sc.nextFloat();
        System.out.print("Quantidade: ");
        int quantidade = sc.nextInt();
        System.out.print("Marca: ");
        String marca = sc.next();
        produtoService.adicionarProduto(nome, preco, quantidade, marca);
        System.out.println("Produto adicionado com sucesso!");
    }

    private static void editarProduto(Scanner sc) {
        System.out.println("Editar produto");
        System.out.print("ID: ");
        int id = sc.nextInt();
        System.out.print("Nome: ");
        String nome = sc.next();
        System.out.print("Preço: ");
        float preco = sc.nextFloat();
        System.out.print("Quantidade: ");
        int quantidade = sc.nextInt();
        System.out.print("Marca: ");
        String marca = sc.next();
        produtoService.editarProduto(id, nome, preco, quantidade, marca);
        System.out.println("Produto editado com sucesso!");
    }

    private static void removerProduto(Scanner sc) {
        System.out.println("Remover produto");
        System.out.print("ID: ");
        int id = sc.nextInt();
        produtoService.removerProduto(id);
        System.out.println("Produto removido com sucesso!");
    }
}
