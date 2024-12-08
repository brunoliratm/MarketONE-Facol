package services;

import models.Carrinho;
import models.Produto;
import models.Cliente;
import java.util.ArrayList;

public class CarrinhoService {
    public void adicionarProduto(Carrinho carrinho, Produto produto, int quantidade) {
        carrinho.getProdutos().add(produto);
        carrinho.getQuantidades().add(quantidade);
    }

    public double calcularTotal(Carrinho carrinho) {
        double total = 0;
        for (int i = 0; i < carrinho.getProdutos().size(); i++) {
            total += carrinho.getProdutos().get(i).getPreco() * carrinho.getQuantidades().get(i);
        }
        return total;
    }

    public void listarProdutos(Carrinho carrinho) throws InterruptedException {
        System.out.println("Itens no Carrinho:");
        for (int i = 0; i < carrinho.getProdutos().size(); i++) {
            Produto produto = carrinho.getProdutos().get(i);
            int quantidade = carrinho.getQuantidades().get(i);
            System.out.println("ID: " + produto.getId());
            System.out.println("Produto: " + produto.getNome());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("Quantidade: " + quantidade);
            System.out.println();
        }
    }

    public void finalizarCompra(Carrinho carrinho, Cliente cliente) throws InterruptedException {
        double total = calcularTotal(carrinho);
        if (carrinho.getProdutos().isEmpty()) {
            System.out.println("O carrinho está vazio. Não é possível finalizar a compra.");
            return;
        }
        listarProdutos(carrinho);
        ArrayList<Produto> produtosComprados = new ArrayList<>(carrinho.getProdutos());
        System.out.println("Total da Compra: " + total);
        cliente.getHistoricoCompras().addAll(produtosComprados);
        carrinho.getProdutos().clear();
        carrinho.getQuantidades().clear();
        System.out.println("Compra realizada com sucesso!");
        Thread.sleep(2000);
    }

    public void limparCarrinho(Carrinho carrinho) {
        carrinho.getProdutos().clear();
        carrinho.getQuantidades().clear();
    }
}