package repository;

import java.util.ArrayList;
import models.Cliente;

public class ClienteRepository {
  static ArrayList<Cliente> clientes = new ArrayList<>();

  public static void adicionarCliente(Cliente cliente) {
    clientes.add(cliente);
  }

  public static Cliente findByEmail(String email) {
    for (Cliente cliente : clientes) {
      if (cliente.getEmail().equals(email)) {
        return cliente;
      }
    }
    return null;
  }


}
