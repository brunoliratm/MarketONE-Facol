package MarketONE;

public class Funcionario {
    private String nome;
    private String email;
    private long telefone;
    private String cargo;
    private float salario;
    private String senha;

    public Funcionario(String nome, String email, long telefone, String cargo, float salario, String senha){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cargo = cargo;
        this.salario = salario;
        this.senha = senha;
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

    public long getTelefone() {
        return telefone;
    }
    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }
    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
