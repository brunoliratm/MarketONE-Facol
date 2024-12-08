
package services;

import models.Cliente;
import models.Produto;
import java.util.ArrayList;

public class ClienteService {
    public void adicionarCompra(Cliente cliente, ArrayList<Produto> produtosComprados) {
        cliente.getHistoricoCompras().addAll(produtosComprados);
    }

    public static void exibirHistoricoDeCompras(Cliente cliente) {
        for (Produto produto : cliente.getHistoricoCompras()) {
            System.out.println("Produto: " + produto.getNome());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println();
        }
    }
}