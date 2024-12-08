package gui;

import treatments.Clear;
import treatments.Exit;
import java.util.Scanner;

import services.Login;
import services.Registro;

public class MainMenu {

  public static void menu(Scanner sc) throws InterruptedException {
    Clear.limpeza();
    System.out.println("Menu Inicial\n");
    Thread.sleep(2000);
    System.out.println("Digite a opção desejada:\n");

    System.out.println("1. Login do Cliente");
    System.out.println("2. Login do Funcionário");
    System.out.println("3. registrar Cliente");
    System.out.println("4. registrar Funcionário");
    System.out.println("0. Sair do Aplicativo\n");
    System.out.print("--> ");
    String opcao = sc.next();

    Clear.limpeza();
    switch (opcao) {
      case "1":
        Login.loginCliente(sc);
        break;
      case "2":
        Login.loginFuncionario(sc);
        break;
      case "3":
        Registro.registrarCliente(sc);
        break;
      case "4":
        Registro.registrarFuncionario(sc);
        break;

      case "0":
        Exit.exitProgram(sc);
        break;
      default:
        System.out.println("Insira uma opção válida!");
        Thread.sleep(2000);
        menu(sc);
        break;
    }
  }

}