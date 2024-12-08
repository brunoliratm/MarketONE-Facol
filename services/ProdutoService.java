package services;

import java.util.ArrayList;
import repository.ProdutoRepository;
import models.Produto;

public class ProdutoService {
  private ProdutoRepository produtoRepository = new ProdutoRepository();

  public void adicionarProduto(String nome, float preco, int quantidade, String marca) {
    Produto produto = new Produto(nome, preco, quantidade, marca);
    produtoRepository.adicionarProduto(produto);
  }

  public void editarProduto(int id, String nome, float preco, int quantidade, String marca) {
    produtoRepository.editarProduto(id, nome, preco, quantidade, marca);
  }

  public void removerProduto(int id) {
    produtoRepository.removerProduto(id);
  }

  public ArrayList<Produto> listarProdutos() {
    return produtoRepository.listarProdutos();
  }
}
