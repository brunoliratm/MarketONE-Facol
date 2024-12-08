package models;

import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Produto> produtos = new ArrayList<>();
    private ArrayList<Integer> quantidades = new ArrayList<>();

    public void adicionarProduto(Produto produto, int quantidade) {
        produtos.add(produto);
        quantidades.add(quantidade);
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < produtos.size(); i++) {
            total += produtos.get(i).getPreco() * quantidades.get(i);
        }
        return total;
    }

    public void listarProdutos() throws InterruptedException {
        System.out.println("Itens no Carrinho:");
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            int quantidade = quantidades.get(i);
            System.out.println("ID: " + produto.getId());
            System.out.println("Produto: " + produto.getNome());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("Quantidade: " + quantidade);
            System.out.println();
        }
    }

    public void finalizarCompra(Cliente cliente) throws InterruptedException {
        double total = calcularTotal();
        if (produtos.isEmpty()) {
            System.out.println("O carrinho está vazio. Não é possível finalizar a compra.");
            return;
        }
        listarProdutos();
        ArrayList<Produto> produtosComprados = new ArrayList<>(produtos);
        System.out.println("Total da Compra: " + total);
        cliente.getHistoricoCompras().addAll(produtosComprados);
        produtos.clear();
        quantidades.clear();
        System.out.println("Compra realizada com sucesso!");
        Thread.sleep(2000);
    }

    public void limparCarrinho() {
        produtos.clear();
        quantidades.clear();
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public ArrayList<Integer> getQuantidades() {
        return quantidades;
    }
}