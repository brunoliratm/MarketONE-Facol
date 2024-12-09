package services;

import java.util.Scanner;

import gui.ClienteMenu;
import gui.FuncionarioMenu;
import models.Cliente;
import models.Funcionario;
import repository.ClienteRepository;
import repository.FuncionarioRepository;

public class Registro {

    public static void registrarCliente(Scanner sc) throws InterruptedException {
        System.out.print("Nome: ");
        String nome = sc.next();
        System.out.print("CPF: ");
        String cpf = sc.next();
        System.out.print("Senha: ");
        String senha = sc.next();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Telefone: ");
        long telefone = sc.nextLong();
        System.out.print("Endereço: ");
        String endereco = sc.next();
        System.out.print("Idade: ");
        int idade = sc.nextInt();

        Cliente cliente = new Cliente(nome, cpf, senha, email, telefone, endereco, idade);
        ClienteRepository.adicionarCliente(cliente);
        System.out.println("Cliente registrado com sucesso!");
        Thread.sleep(2000);
        ClienteMenu.menu(sc, cliente);
    }

    public static void registrarFuncionario(Scanner sc) throws InterruptedException {
        System.out.print("Nome: ");
        String nome = sc.next();
        System.out.print("CPF: ");
        String cpf = sc.next();
        System.out.print("Senha: ");
        String senha = sc.next();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Telefone: ");
        long telefone = sc.nextLong();
        System.out.print("Endereço: ");
        String endereco = sc.next();
        System.out.print("Cargo: ");
        String cargo = sc.next();
        System.out.print("Salário: ");
        double salario = sc.nextDouble();

        Funcionario funcionario = new Funcionario(nome, cpf, senha, email, telefone, endereco, cargo, salario);
        FuncionarioRepository.adicionarFuncionario(funcionario);
        System.out.println("Funcionário registrado com sucesso!");
        Thread.sleep(2000);
        FuncionarioMenu.menu(sc, funcionario);
    }

}
