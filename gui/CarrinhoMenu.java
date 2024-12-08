package gui;

import services.CarrinhoService;
import models.Carrinho;
import java.util.Scanner;
import models.Cliente;
import treatments.Clear;

public class CarrinhoMenu {
    static CarrinhoService carrinhoService = new CarrinhoService();
    static Carrinho carrinhoCompras = new Carrinho();

    public static void carrinho(Scanner sc, Cliente cliente) throws Exception {
        Clear.limpeza();
        System.out.println("Carrinho de Compras\n");
        Thread.sleep(2000);
        System.out.println("Escolha uma opção:");
        System.out.println("1. Listar Produtos no Carrinho");
        System.out.println("2. Calcular Valor Total do Carrinho");
        System.out.println("3. Finalizar compra");
        System.out.println("4. Retornar ao Menu Inicial\n");
        String opcao = sc.next();
        Clear.limpeza();
        switch (opcao) {
            case "1":
                carrinhoService.listarProdutos(carrinhoCompras);
                carrinho(sc, cliente);
                break;
            case "2":
                double total = carrinhoService.calcularTotal(carrinhoCompras);
                System.out.println("Total do Carrinho: " + total);
                Thread.sleep(2000);
                carrinho(sc, cliente);
                break;
            case "3":
                carrinhoService.finalizarCompra(carrinhoCompras, cliente);
                Thread.sleep(2000);
                carrinho(sc, cliente);
                break;
            case "4":
                MainMenu.menu(sc);
                break;
            default:
                System.out.println("Opção inválida.");
                Thread.sleep(1000);
                sc.nextLine();
                carrinho(sc, cliente);
                break;
        }
    }

}