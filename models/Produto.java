package models;

public class Produto {
  private int id;
  private String nome;
  private float preco;
  private int quantidade;
  private String marca;

  public Produto(String nome, float preco, int quantidade, String marca) {
    this.id = gerarProximoId();
    this.nome = nome;
    this.preco = preco;
    this.quantidade = quantidade;
    this.marca = marca;
  }

  private static int proximoId = 1;

  private static int gerarProximoId() {
    return proximoId++;
  }

  public void editarProduto(int id, String nome, float preco, int quantidade, String marca) {
    this.nome = nome;
    this.preco = preco;
    this.quantidade = quantidade;
    this.marca = marca;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public static int getProximoId() {
    return proximoId;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public float getPreco() {
    return preco;
  }

  public void setPreco(float preco) {
    this.preco = preco;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

}
