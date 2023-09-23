import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


class produto{
    private int id;
    private String nome;
    private float preco;
    private int quantidade;
    private String marca;

    public produto(String nome, float preco, int quantidade, String marca){
    this.id = gerarProximoId();
    this.nome = nome;
    this.preco = preco;
    this.quantidade = quantidade;
    this.marca = marca;
    }

    private static int proximoId = 1;

    private static int gerarProximoId() {
        return proximoId++;
    }
    public void editarProduto(int id, String nome, float preco, int quantidade, String marca) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.marca = marca;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public static int getProximoId() {
        return proximoId;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
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

class usuario{
    private String nome;
    private String email;
    private int idade;
    private String endereco;
    private long telefone;

    public usuario(String nome, String email, int idade, String endereco, long telefone){
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public long getTelefone() {
        return telefone;
    }
    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
}

class funcionario{
    private String nome;
    private String email;
    private long telefone;
    private String cargo;
    private float salario;

    public funcionario(String nome, String email, long telefone, String cargo, float salario){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelefone() {
        return telefone;
    }
    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }
    public void setSalario(float salario) {
        this.salario = salario;
    }

    
}

class carrinho{
    private ArrayList<produto> produtos = new ArrayList<>();
    private ArrayList<Integer> quantidades = new ArrayList<>();

    public void adicionarProduto(produto produto, int quantidade) {
        produtos.add(produto);
        quantidades.add(quantidade);
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < produtos.size(); i++) {
            total += produtos.get(i).getPreco() * quantidades.get(i);
        }
        return total;
    }

    public void listarProdutos() {
          System.out.println("Itens no Carrinho:");
          for (int i = 0; i < produtos.size(); i++) {
          produto produto = produtos.get(i);
          int quantidade = quantidades.get(i);
          System.out.println("ID: " + produto.getId());
          System.out.println("Produto: " + produto.getNome());
          System.out.println("Preço: " + produto.getPreco());
          System.out.println("Quantidade: " + quantidade);
          System.out.println();
        }
    }
    public ArrayList<produto> getProdutos() {
        return produtos;
    }

    public ArrayList<Integer> getQuantidades() {
        return quantidades;
    }
}

//Classe principal
public class MarketONE {
    static ArrayList<produto> produtos = new ArrayList<>();
    static ArrayList<usuario> clientes = new ArrayList<>();
    ArrayList<carrinho> carrinhos = new ArrayList<>();
   static Scanner scanner = new Scanner(System.in);

    // (0) limpar terminal
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

    // (1) menu mercado
    public static void mercado() throws Exception{
        limpeza();
        System.out.println("Área do Mercado");
        System.out.println("");
        Thread.sleep(2000);
        
        System.out.println("Digite a opção desejada:");
        System.out.println("1. Comprar Produtos");
        System.out.println("2. Adicionar Produtos");
        System.out.println("3. Editar Produtos");
        System.out.println("4. Remover Produtos");
        System.out.println("5. Lista de Produtos");
        System.out.println("6. Retornar ao Menu Inicial");

        try {
             int opcao= scanner.nextInt();
             limpeza();

            switch (opcao) {
            case 1:
                comprarProdutos(null);
                break;
            case 2:
                adicionarProduto();
                break;
            case 3:
                editarProduto();
                break;
            case 4:
                removerProduto();
                break;
            case 5:
                listarProdutos();
            case 6:
                main(null);
                break;
            default:
                mercado();
                break;
        }
        } catch (Exception e) {
            System.out.println("insira uma opção valida!");
            Thread.sleep(1000);
            scanner.nextLine();
            limpeza();
            mercado();
        }
    }

    // (1-1) Comprar produtos
    public static void comprarProdutos(carrinho carrinho) throws Exception {
        while (true) {
            listarProdutos();
    
            System.out.println("Digite o ID do produto que deseja comprar (ou 0 para voltar ao menu anterior):");
            int idProduto = scanner.nextInt();
            
            if (idProduto == 0) {
                mercado();
                break;
            }
    
            produto produtoSelecionado = null;
            for (produto p : produtos) {
                if (p.getId() == idProduto) {
                    produtoSelecionado = p;
                    break;
                }
            }
    
            if (produtoSelecionado != null) {
                System.out.println("Digite a quantidade desejada:");
                int quantidade = scanner.nextInt();
                carrinho.adicionarProduto(produtoSelecionado, quantidade);
                System.out.println("Produto adicionado ao carrinho com sucesso!");
                Thread.sleep(1000);
                mercado();
            } else {
                System.out.println("Produto não encontrado.");
                Thread.sleep(1000);
                mercado();
            }
        }
    }
    
    // (1-2) Adicionar Produtos
    public static void adicionarProduto() throws Exception {
        try {
            scanner.nextLine();
            System.out.println("Digite o nome do produto:");
            String nomeProduto = scanner.nextLine();
            System.out.println("Digite o preço do produto:");
            float precoProduto = scanner.nextFloat();
            System.out.println("Digite a quantidade em estoque do produto:");
            int quantidadeProduto = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println("Digite a marca do produto:");
            String marcaProduto = scanner.nextLine();
    
            int proximoId= 1;
            if (!produtos.isEmpty()) {
                proximoId = produtos.get(produtos.size() - 1).getId() + 1;
            }
    
            produto novoProduto = new produto(nomeProduto, precoProduto, quantidadeProduto, marcaProduto);
            produtos.add(novoProduto);
    
            System.out.println("Produto adicionado com sucesso!");
            Thread.sleep(1000);
            mercado(); 
        } catch (Exception e) {
            System.out.println("Insira valores válidos!");
            Thread.sleep(1000);
            mercado();
        }
    }

    // (1-3) Editar produtos
    public static void editarProduto() throws Exception {
        try {
            System.out.println("Digite o ID do produto que deseja editar:");
            int idProduto = scanner.nextInt();

            for (produto p : produtos) {
                if (p.getId() == idProduto) {
                    scanner.nextLine();
                    System.out.println("Digite o novo nome do produto:");
                    String nomeProduto = scanner.nextLine();
                    System.out.println("Digite o novo preço do produto:");
                    float precoProduto = scanner.nextFloat();
                    System.out.println("Digite a nova quantidade em estoque do produto:");
                    int quantidadeProduto = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.println("Digite a nova marca do produto:");
                    String marcaProduto = scanner.nextLine();

                    p.setNome(nomeProduto);
                    p.setPreco(precoProduto);
                    p.setQuantidade(quantidadeProduto);
                    p.setMarca(marcaProduto);

                    System.out.println("Produto editado com sucesso!");
                    Thread.sleep(1000);
                    mercado();
                    return;
                }
            }

            System.out.println("Produto não encontrado.");
            Thread.sleep(1000);
            mercado(); 
        } catch (Exception e) {
            System.out.println("Insira um ID válido!");
            Thread.sleep(1000);
            mercado();
        }
    }

    // (1-4) Excluir produtos
    public static void removerProduto() throws Exception {
        try {
            scanner.nextLine();
            System.out.println("Digite o ID do produto que deseja remover:");
            int idProdutoRemover = scanner.nextInt();
    
            for (produto p : produtos) {
                if (p.getId() == idProdutoRemover) {
                    produtos.remove(p);
                    System.out.println("Produto removido com sucesso!");
                    Thread.sleep(1000);
                    mercado();
                    return;
                }
            }
    
            System.out.println("Produto não encontrado.");
            Thread.sleep(1000);
            mercado(); 
        } catch (Exception e) {
            System.out.println("Insira um ID válido!");
            Thread.sleep(1000);
            mercado();
        }
    }

    // (1-5) Listar produtos
    public static void listarProdutos() throws Exception {
        System.out.println("Lista de Produtos:");
        for (produto p : produtos) {
            System.out.println("ID: " + p.getId());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Preço: " + p.getPreco());
            System.out.println("Quantidade: " + p.getQuantidade());
            System.out.println("Marca: " + p.getMarca());
            System.out.println();
        }
        Thread.sleep(6000);
    }

    // (2) carrinho de compras
    public static void carrinho(){
        
    }

    // (3) area do cliente
    public static void cliente() throws Exception{
        limpeza();
        System.out.println("Área do Cliente");
        System.out.println("");
        Thread.sleep(2000);
        
        System.out.println("Digite a opção desejada:");
        System.out.println("1. Adicionar Cliente");
        System.out.println("2. Remover Cliente");
        System.out.println("3. Lista de Clientes");
        System.out.println("4. Retornar ao Menu Inicial");

        int opcao= scanner.nextInt();
        limpeza();
        switch (opcao) {
            case 1:
                try {
                    System.out.println("Adicione as informações requisitadas");
                    scanner.nextLine(); 
                    System.out.println("Nome:");
                    String nomeCliente = scanner.nextLine();
                    System.out.println("Email: ");
                    String emailCliente = scanner.nextLine();
                    System.out.println("idade: ");
                    int idadeCliente = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.println("Endereco: ");
                    String enderecoCliente = scanner.nextLine();
                    System.out.println("telefone: ");
                    long telefoneCliente = scanner.nextLong();

                    usuario cliente = new usuario(nomeCliente, emailCliente, idadeCliente, enderecoCliente, telefoneCliente);
                    clientes.add(cliente);

                    System.out.println("Usuário adicionado com sucesso");
                    Thread.sleep(1000);
                    cliente();
                    break;
                } catch (Exception e) {
                    System.out.println("insira um valor válido!");
                    Thread.sleep(1000);
                    cliente();
                }
            case 2:
                scanner.nextLine(); 
                System.out.println("Digite o nome do cliente que deseja remover:");
                String nomeClienteRemover = scanner.nextLine();
                for (int i = 0; i < clientes.size(); i++) {
                    usuario cliente = clientes.get(i);
                    if (cliente.getNome().equals(nomeClienteRemover)) {
                        clientes.remove(i);
                        System.out.println("Cliente removido com sucesso!");
                        return; 
                    }
                }
                System.out.println("Cliente não encontrado.");
                break;
            case 3:
                System.out.println("Lista de Clientes:");
                System.out.println("");
                for (usuario cliente : clientes) {
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("Email: " + cliente.getEmail());
                    System.out.println("Idade: " + cliente.getIdade());
                    System.out.println("Endereço: " + cliente.getEndereco());
                    System.out.println("Telefone: " + cliente.getTelefone());
                    System.out.println();
               }

                 Thread.sleep(8000);
                 cliente();
            case 4:
                main(null);
                break;
            default:
                break;
        }

    }

    // (4) area do funcionario
    public static void funcionario(){

    }

    //metodo principal (Menu principal)
    public static void main(String[] args) throws Exception {
        
        limpeza();
        System.out.println("Menu Inicial");
        System.out.println("");
        Thread.sleep(2000);
        
         System.out.println("Digite a opção desejada:");
        System.out.println("1. Mercado");
        System.out.println("2. Carrinho de Compras");
        System.out.println("3. Área do Cliente");
        System.out.println("4. Área do Funcionário"); 
        System.out.println("5. Sair do Aplicativo");
        System.out.println("");
        int opcao= scanner.nextInt();

        switch (opcao) {
            case 1:
                mercado();
                break;
            case 2:
                carrinho();
                break;
            case 3:
                cliente();
                break;
            case 4:
                funcionario();
                break;
            case 5:
                scanner.close();
                System.out.println("Obrigado por utilizar nosso mercado!");
                System.out.println("Até mais");
                Thread.sleep(2000);
                System.exit(0);
                break;
            default:
                System.out.println("Insira uma opção válida!");
                Thread.sleep(2000);
                main(null);
                break;
        }
    }
}