package repository;

import java.util.ArrayList;
import models.Funcionario;

public class FuncionarioRepository {
  static ArrayList<Funcionario> funcionarios = new ArrayList<>();
  
    public static void adicionarFuncionario(Funcionario funcionario) {
      funcionarios.add(funcionario);
    }
  
    public static Funcionario findByEmail(String email) {
      for (Funcionario funcionario : funcionarios) {
      if (funcionario.getEmail().equals(email)) {
        return funcionario;
      }
    }
    return null;
  }


}
