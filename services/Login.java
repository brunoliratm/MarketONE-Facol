package services;

import java.util.Scanner;
import gui.ClienteMenu;
import gui.FuncionarioMenu;
import gui.MainMenu;
import models.Cliente;
import models.Funcionario;
import repository.ClienteRepository;
import repository.FuncionarioRepository;

public class Login {

  public static void loginCliente(Scanner sc) throws InterruptedException {
    System.out.println("Login cliente");

    System.out.println("Digite o email: ");
    String email = sc.next();

    System.out.println("Digite a senha: ");
    String senha = sc.next();

    Cliente cliente = ClienteRepository.findByEmail(email);

    if (cliente != null && cliente.getSenha().equals(senha)) {
      System.out.println("Login efetuado com sucesso!");
      Thread.sleep(2000);
      ClienteMenu.menu(sc, cliente);
    } else {
      System.out.println("Email ou senha incorretos!");
      Thread.sleep(2000);
      MainMenu.menu(sc);
    }

  }

  public static void loginFuncionario(Scanner sc) throws InterruptedException {
    System.out.println("Login funcionário");

    System.out.println("Digite o email: ");
    String email = sc.next();

    System.out.println("Digite a senha: ");
    String senha = sc.next();

    Funcionario funcionario = FuncionarioRepository.findByEmail(email);

    if (funcionario != null && funcionario.getSenha().equals(senha)) {
      System.out.println("Login efetuado com sucesso!");
      Thread.sleep(2000);
      FuncionarioMenu.menu(sc, funcionario);
    } else {
      System.out.println("Email ou senha incorretos!");
      Thread.sleep(2000);
      MainMenu.menu(sc);
    }

  }

}
