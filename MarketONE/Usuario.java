package MarketONE;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String email;
    private int idade;
    private String endereco;
    private long telefone;
    private ArrayList<ArrayList<Produto>> historicoCompras;

    public Usuario(String nome, String email, int idade, String endereco, long telefone){
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.endereco = endereco;
        this.telefone = telefone;
        this.historicoCompras = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public long getTelefone() {
        return telefone;
    }
    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
    public void adicionarCompra(ArrayList<Produto> produtosComprados) {
        historicoCompras.add(produtosComprados);
    }

    public ArrayList<ArrayList<Produto>> getHistoricoCompras() {
        return historicoCompras;
    }

    public void exibirHistoricoDeCompras() {
        System.out.println("Histórico de Compras:");
        for (int i = 0; i < historicoCompras.size(); i++) {
            ArrayList<Produto> compra = historicoCompras.get(i);
            System.out.println("Compra " + (i + 1) + ":");
            for (Produto p : compra) {
                System.out.println("Produto: " + p.getNome());
                System.out.println("Preço: " + p.getPreco());
                System.out.println("Marca: " + p.getMarca());
                System.out.println();
            }
            System.out.println();
        }
    }
}
