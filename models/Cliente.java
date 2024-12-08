package models;

import java.util.ArrayList;

public class Cliente extends Pessoa{

  protected int idade;
  protected ArrayList<Produto> historicoCompras;

  public Cliente(String nome, String cpf, String senha, String email, long telefone, String endereco, int idade){
    super(nome, cpf, senha, email, telefone, endereco);
    this.idade = idade;
    this.historicoCompras = new ArrayList<>();
  }

  public int getIdade() {
    return this.idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public ArrayList<Produto> getHistoricoCompras() {
    return this.historicoCompras;
  }

  public void setHistoricoCompras(ArrayList<Produto> historicoCompras) {
    this.historicoCompras = historicoCompras;
  }

  

}
