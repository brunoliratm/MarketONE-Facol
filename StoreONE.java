import java.io.IOException;
import java.util.*;

public class StoreONE {
    public static void limpeza(){
        String os = System.getProperty("os.name").toLowerCase();

        try {
            Process process;
            if (os.contains("win")) {
                process = new ProcessBuilder("cmd", "/c", "cls").inheritIO().start();
            } else {
                process = new ProcessBuilder("clear").inheritIO().start();
            }
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<CarrinhoDeCompras> carrinhos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            limpeza();
            System.out.println("Menu:");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Criar Carrinho de Compras");
            System.out.println("3. Adicionar Produto ao Carrinho");
            System.out.println("4. Listar Produtos no Carrinho");
            System.out.println("5. Calcular Total da Compra");
            System.out.println("6. Dados do cliente");
            System.out.println("7. Sair do programa");
            System.out.println("Escolha uma opção: ");
            System.out.println();

            

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcao) {
                case 1:
                    limpeza();
                    System.out.print("Nome do Cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Endereço do Cliente: ");
                    String endereco = scanner.nextLine();
                    System.out.println("Idade: ");
                    int idade = scanner.nextInt();
                    System.out.println("Telefone: ");
                    long telefone = scanner.nextLong();
                    System.out.println("Renda: ");
                    double renda = scanner.nextDouble();
                    Cliente cliente = new Cliente(nome, endereco, idade, telefone, renda);
                    clientes.add(cliente);
                    System.out.println("Cliente adicionado");
                    Thread.sleep(2000);
                    break;

                case 2:
                limpeza();
                    if (clientes.isEmpty()) {
                        System.out.println("Crie um cliente primeiro.");
                        Thread.sleep(2000);
                    } else {
                        System.out.println("Escolha um cliente: ");
                        for (int i = 0; i < clientes.size(); i++) {
                            System.out.println(i + 1 + ". " + clientes.get(i).getNome());
                        }
                        int clienteSelecionado = scanner.nextInt();
                        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
                        carrinhos.add(carrinho);
                        System.out.println("Carrinho de compras criado para " + clientes.get(clienteSelecionado - 1).getNome());
                        Thread.sleep(3000);
                    }
                    break;

                case 3:
                    limpeza();
                    if (carrinhos.isEmpty()) {
                        System.out.println("Crie um carrinho de compras primeiro.");
                        Thread.sleep(2000);
                    } else {
                        System.out.print("Nome do Produto: ");
                        String nomeProduto = scanner.nextLine();
                        System.out.println("Marca do Produto");
                        String marca = scanner.nextLine();
                        System.out.print("Preço do Produto: ");
                        double preco = scanner.nextDouble();
                        System.out.print("Quantidade: ");
                        int quantidade = scanner.nextInt();
                        scanner.nextLine();
                        Produto produto = new Produto(nomeProduto, marca, preco, quantidade);
                        System.out.println("Escolha um carrinho de compras:");
                        for (int i = 0; i < carrinhos.size(); i++) {
                            System.out.println(i + 1 + ". Carrinho de Compras " + (i + 1));
                        }
                        int carrinhoSelecionado = scanner.nextInt();
                        carrinhos.get(carrinhoSelecionado - 1).adicionarProduto(produto);
                        System.out.println("");
                        System.out.println("Produto adicionado");
                    }
                    Thread.sleep(2000);
                    break;
                case 4:
                limpeza();
                    if (carrinhos.isEmpty()) {
                        System.out.println("Crie um carrinho de compras primeiro.");
                    } else {
                        System.out.println("Escolha um carrinho de compras:");
                        for (int i = 0; i < carrinhos.size(); i++) {
                            System.out.println(i + 1 + ". Carrinho de Compras " + (i + 1));
                        }
                        int carrinhoSelecionado = scanner.nextInt();
                        carrinhos.get(carrinhoSelecionado - 1).listarProdutos();
                    }
                    Thread.sleep(2000);
                    break;
                case 5:
                    if (carrinhos.isEmpty()) {
                        System.out.println("Crie um carrinho de compras primeiro.");
                    } else {
                        System.out.println("Escolha um carrinho de compras:");
                        for (int i = 0; i < carrinhos.size(); i++) {
                            System.out.println(i + 1 + ". Carrinho de Compras " + (i + 1));
                        }
                        int carrinhoSelecionado = scanner.nextInt();
                        double totalCompra = carrinhos.get(carrinhoSelecionado - 1).calcularTotal();
                        System.out.println("Total da Compra: " + totalCompra);
                    }
                    Thread.sleep(2000);
                    break;
                    case 6: 
                        limpeza();
                        if (clientes.isEmpty()) {
                            System.out.println("Nenhum cliente cadastrado.");
                        } else {
                            System.out.println("Escolha um cliente:");
                            for (int i = 0; i < clientes.size(); i++) {
                                System.out.println(i + 1 + ". " + clientes.get(i).getNome());
                            }
                            int clienteSelecionado = scanner.nextInt();
                            if (clienteSelecionado >= 1 && clienteSelecionado <= clientes.size()) {
                                clientes.get(clienteSelecionado - 1).mostrarInformacoes();
                            } else {
                                System.out.println("Cliente não encontrado.");
                            }
                        }
                        Thread.sleep(2000);
                        break;
                    case 7:
                        scanner.close();
                        System.exit(0);
                        break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    Thread.sleep(1000);
            }
            } catch (Exception e) {
                System.out.println("Insira um valor válido ;)");
                Thread.sleep(2000);
                limpeza();
                scanner.nextLine();
            }
        }
    }
}

class Produto {
    private String nome;
    private String marca;
    private double preco;
    private int quantidade;
    

    public Produto(String nome, String marca, double preco, int quantidade) {
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}

class CarrinhoDeCompras {
    private ArrayList<Produto> itens = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        itens.add(produto);
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto produto : itens) {
            total += produto.getPreco() * produto.getQuantidade();
        }
        return total;
    }


    public void listarProdutos() {
        System.out.println();
        for (Produto produto : itens) {
            System.out.println("Produto: " + produto.getNome());
            System.out.println("Marca: " + produto.getMarca());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("Quantidade: " + produto.getQuantidade());
            System.out.println();
        }
    }
}

class Cliente {
    private String nome;
    private String endereco;
    private int idade;
    private long telefone;
    private double renda;

    public Cliente(String nome, String endereco, int idade, long telefone, double renda) {
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
        this.telefone = telefone;
        this.renda = renda;
    }
        public void mostrarInformacoes() {
                System.out.println("Nome: " + nome);
                System.out.println("Endereço: " + endereco);
                System.out.println("Idade: " + idade);
                System.out.println("Telefone: " + telefone);
                System.out.println("Renda: " + renda);
            }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    
}
