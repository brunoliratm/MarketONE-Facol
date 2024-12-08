package models;

public class Funcionario extends Pessoa {

    protected String cargo;
    protected double salario;

    public Funcionario(String nome, String cpf, String senha, String email, long telefone, String endereco, String cargo, double salario) {
        super(nome, cpf, senha, email, telefone, endereco);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void aumentarSalario(double aumento) {
        this.salario += aumento;
    }

    public void exibirDados() {
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Email: " + this.email);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("Endereço: " + this.endereco);
        System.out.println("Cargo: " + this.cargo);
        System.out.println("Salário: " + this.salario);
    }

}
