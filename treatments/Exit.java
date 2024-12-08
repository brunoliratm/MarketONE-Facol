package treatments;

import java.util.Scanner;

public class Exit {
  public static void exitProgram(Scanner sc) throws InterruptedException {
    sc.close();
    System.out.println("Obrigado por utilizar nosso mercado!");
    System.out.println("Até mais");
    Thread.sleep(2000);
    System.exit(0);
  }

}
