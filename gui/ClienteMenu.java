package gui;

import services.ClienteService;
import treatments.Clear;
import models.Cliente;
import java.util.Scanner;

public class ClienteMenu {
    static ClienteService clienteService = new ClienteService();

    public static void menu(Scanner sc, Cliente cliente) throws InterruptedException {
        Clear.limpeza();
        System.out.println("Área do Cliente");
        System.out.println("");
        Thread.sleep(2000);
        System.out.println("Digite a opção desejada:");
        System.out.println("1. Dados do Cliente");
        System.out.println("2. Histórico de compras");
        System.out.println("3. Retornar ao Menu Inicial\n");
        try {
            String opcao = sc.next();
            Clear.limpeza();
            switch (opcao) {
                case "1":
                    System.out.println("Dados do Cliente:");
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("Email: " + cliente.getEmail());
                    System.out.println("Idade: " + cliente.getIdade());
                    System.out.println("Endereço: " + cliente.getEndereco());
                    System.out.println("Telefone: " + cliente.getTelefone());
                    Thread.sleep(5000);
                    menu(sc, cliente);
                    break;
                case "2":
                    ClienteService.exibirHistoricoDeCompras(cliente);
                    Thread.sleep(5000);
                    menu(sc, cliente);
                    break;
                case "3":
                    MainMenu.menu(sc);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Insira um valor válido");
            Thread.sleep(2000);
            sc.nextLine();
            menu(sc, cliente);
        }
    }
}