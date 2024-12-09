package services;

import java.util.Scanner;

import models.Produto;

public class FuncionarioService {

  public static void listarProdutos() {
        for (Produto produto : ProdutoService.listarProdutos()) {
            System.out.println("ID: " + produto.getId());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("Quantidade: " + produto.getQuantidade());
            System.out.println("Marca: " + produto.getMarca());
            System.out.println();
        }
    }

    public static void adicionarProduto(Scanner sc) {
        System.out.println("Adicionar produto");
        System.out.print("Nome: ");
        String nome = sc.next();
        System.out.print("Preço: ");
        float preco = sc.nextFloat();
        System.out.print("Quantidade: ");
        int quantidade = sc.nextInt();
        System.out.print("Marca: ");
        String marca = sc.next();
        ProdutoService.adicionarProduto(nome, preco, quantidade, marca);
        System.out.println("Produto adicionado com sucesso!");
    }

    public static void editarProduto(Scanner sc) {
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
        ProdutoService.editarProduto(id, nome, preco, quantidade, marca);
        System.out.println("Produto editado com sucesso!");
    }

    public static void removerProduto(Scanner sc) {
        System.out.println("Remover produto");
        System.out.print("ID: ");
        int id = sc.nextInt();
        ProdutoService.removerProduto(id);
        System.out.println("Produto removido com sucesso!");
    }

}
