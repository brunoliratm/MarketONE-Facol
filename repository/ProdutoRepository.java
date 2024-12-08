package repository;

import java.util.ArrayList;
import models.Produto;

public class ProdutoRepository {
  private ArrayList<Produto> produtos = new ArrayList<>();

  public void adicionarProduto(Produto produto) {
    produtos.add(produto);
  }

  public void editarProduto(int id, String nome, float preco, int quantidade, String marca) {
    for (Produto produto : produtos) {
      if (produto.getId() == id) {
        produto.editarProduto(id, nome, preco, quantidade, marca);
        break;
      }
    }
  }

  public void removerProduto(int id) {
    produtos.removeIf(produto -> produto.getId() == id);
  }

  public ArrayList<Produto> listarProdutos() {
    return produtos;
  }
}
