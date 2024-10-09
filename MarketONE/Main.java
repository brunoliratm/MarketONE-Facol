package MarketONE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Produto> produtos = new ArrayList<>();
    static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static Carrinho carrinhoCompras = new Carrinho();
    static Usuario cliente;

    //menu principal
    public static void menu() throws Exception{
        limpeza();
        System.out.println("Menu Inicial\n");
        Thread.sleep(2000);

        System.out.println("Digite a opção desejada:");
        System.out.println("1. Mercado");
        System.out.println("2. Carrinho de Compras");
        System.out.println("3. Área do Cliente");
        System.out.println("4. Área do Funcionário");
        System.out.println("5. Sair do Aplicativo\n");
        int opcao= scanner.nextInt();
        limpeza();

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
                menu();
                break;
        }
    }

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
        System.out.println("Área do Mercado\n");
        Thread.sleep(2000);

        System.out.println("Digite a opção desejada:");
        System.out.println("1. Comprar Produtos");
        System.out.println("2. Adicionar Produtos ao Carrinho");
        System.out.println("3. Adicionar Novos Produtos");
        System.out.println("4. Editar Produtos");
        System.out.println("5. Remover Produtos");
        System.out.println("6. Lista de Produtos");
        System.out.println("7. Retornar ao Menu Inicial\n");


        try {
            int opcao= scanner.nextInt();
            limpeza();

            switch (opcao) {
                case 1:
                    comprarProdutos();
                    break;
                case 2:
                    adicionarAoCarrinho();
                    break;
                case 3:
                    adicionarProduto();
                    break;
                case 4:
                    editarProduto();
                    break;
                case 5:
                    removerProduto();
                    break;
                case 6:
                    listarProdutos();
                    break;
                case 7:
                    menu();
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
    public static void comprarProdutos() throws Exception {
        while (true) {
            System.out.println("Lista de Produtos:");
            for (Produto p : produtos) {
                System.out.println("ID: " + p.getId());
                System.out.println("Nome: " + p.getNome());
                System.out.println("Preço: " + p.getPreco());
                System.out.println("Quantidade: " + p.getQuantidade());
                System.out.println("Marca: " + p.getMarca());
                System.out.println();
            }

            System.out.println("Digite o ID do produto que deseja comprar (ou 0 para voltar ao menu anterior):");
            int idProduto = scanner.nextInt();
            scanner.nextLine();

            if (idProduto == 0) {
                mercado();

            }

            Produto produtoSelecionado = null;
            for (Produto p : produtos) {
                if (p.getId() == idProduto) {
                    produtoSelecionado = p;
                    break;
                }
            }

            if (produtoSelecionado != null) {
                System.out.println("Digite a quantidade desejada:");
                int quantidade = scanner.nextInt();
                scanner.nextLine();

                if (quantidade <= produtoSelecionado.getQuantidade()) {
                    produtoSelecionado.setQuantidade(produtoSelecionado.getQuantidade() - quantidade);

                    if (produtoSelecionado.getQuantidade() == 0) {
                        produtos.remove(produtoSelecionado);
                    }
                    double valorTotal = produtoSelecionado.getPreco() * quantidade;
                    ArrayList<Produto> produtosComprados = new ArrayList<>();
                    produtosComprados.add(produtoSelecionado);
                    cliente.adicionarCompra(produtosComprados);
                    System.out.println("Compra realizada com sucesso!");
                    System.out.println("Valor Total: " + valorTotal);
                    Thread.sleep(1000);
                    mercado();
                    break;
                } else {
                    System.out.println("Quantidade insuficiente em estoque.");
                    Thread.sleep(1000);
                    mercado();
                    break;
                }
            } else {
                System.out.println("Produto não encontrado.");
                Thread.sleep(1000);
                mercado();
            }
        }
    }

    // (1-2) adicionar ao carrinho
    public static void adicionarAoCarrinho() throws Exception {
        System.out.println("Lista de Produtos:");
        while (true) {
            for (Produto p : produtos) {
                System.out.println("ID: " + p.getId());
                System.out.println("Nome: " + p.getNome());
                System.out.println("Preço: " + p.getPreco());
                System.out.println("Quantidade: " + p.getQuantidade());
                System.out.println("Marca: " + p.getMarca());
                System.out.println();
            }

            System.out.println("Digite o ID do produto que deseja adicionar ao carrinho (ou 0 para voltar ao menu anterior):");
            int idProduto = scanner.nextInt();
            scanner.nextLine();

            if (idProduto == 0) {
                mercado();
                break;
            }

            Produto produtoSelecionado = null;
            for (Produto p : produtos) {
                if (p.getId() == idProduto) {
                    produtoSelecionado = p;
                    break;
                }
            }

            if (produtoSelecionado != null) {
                System.out.println("Digite a quantidade desejada:");
                int quantidade = scanner.nextInt();
                scanner.nextLine();

                if (quantidade <= produtoSelecionado.getQuantidade()) {
                    carrinhoCompras.adicionarProduto(produtoSelecionado, quantidade);
                    produtoSelecionado.setQuantidade(produtoSelecionado.getQuantidade() - quantidade);

                    if (produtoSelecionado.getQuantidade() == 0) {
                        produtos.remove(produtoSelecionado);
                    }

                    System.out.println("Produto adicionado ao carrinho com sucesso!");
                    Thread.sleep(1000);
                    mercado();
                    break;
                } else {
                    System.out.println("Quantidade insuficiente em estoque.");
                    Thread.sleep(1000);
                    mercado();
                    break;
                }
            } else {
                System.out.println("Produto não encontrado.");
                Thread.sleep(1000);
                mercado();
                break;
            }
        }
    }

    // (1-3) Adicionar Produtos
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


            if (!produtos.isEmpty()) {
                produtos.get(produtos.size() - 1).getId();
            }

            Produto novoProduto = new Produto(nomeProduto, precoProduto, quantidadeProduto, marcaProduto);
            produtos.add(novoProduto);

            System.out.println("Produto adicionado com sucesso!");
            Thread.sleep(1000);
            mercado();
        } catch (Exception e) {
            System.out.println("Insira um valor válido!");
            Thread.sleep(1000);
            mercado();
        }
    }

    // (1-4) Editar produtos
    public static void editarProduto() throws Exception {
        scanner.nextLine();
        System.out.println("Insira seu Login\n");
        System.out.println("Nome do Funcionário: ");
        String user = scanner.nextLine();
        System.out.println("Senha: ");
        String senha = scanner.nextLine();

        boolean credenciaisValidas = false;

        for (Funcionario func : funcionarios) {
            if (func.getNome().equals(user) && func.getSenha().equals(senha)) {
                System.out.println("Autenticação bem-sucedida!\n");

                credenciaisValidas = true;

                try {
                    System.out.println("Digite o ID do produto que deseja editar:");
                    int idProduto = scanner.nextInt();
                    for (Produto p : produtos) {
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
                break;
            }
        }

        if (!credenciaisValidas) {
            System.out.println("Credenciais inválidas. Tente novamente.");
            Thread.sleep(1000);
            mercado();
        }
    }

    // (1-5) Excluir produtos
    public static void removerProduto() throws Exception {
        try {
            scanner.nextLine();
            System.out.println("Digite o ID do produto que deseja remover:");
            int idProdutoRemover = scanner.nextInt();

            for (Produto p : produtos) {
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

    // (1-6) Listar produtos
    public static void listarProdutos() throws Exception {
        System.out.println("Lista de Produtos:\n");
        for (Produto p : produtos) {
            System.out.println("ID: " + p.getId());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Preço: " + p.getPreco());
            System.out.println("Quantidade: " + p.getQuantidade());
            System.out.println("Marca: " + p.getMarca());
            System.out.println();
        }
        Thread.sleep(6000);
        mercado();
    }

    // (2) carrinho de compras
    public static void carrinho() throws Exception{
        limpeza();
        System.out.println("Carrinho de Compras\n");
        Thread.sleep(2000);

        System.out.println("Escolha uma opção:");
        System.out.println("1. Listar Produtos no Carrinho");
        System.out.println("2. Calcular Valor Total do Carrinho");
        System.out.println("3. Finalizar compra");
        System.out.println("4. Retornar ao Menu Inicial\n");

        int opcao = scanner.nextInt();
        limpeza();

        switch (opcao) {
            case 1:
                carrinhoCompras.listarProdutos();
                carrinho();
                break;
            case 2:
                double total = carrinhoCompras.calcularTotal();
                System.out.println("Total do Carrinho: " + total);
                Thread.sleep(2000);
                carrinho();
                break;
            case 3:
                carrinhoCompras.finalizarCompra();
                Thread.sleep(2000);
                carrinho();
                break;
            case 5:
                carrinhoCompras.limparCarrinho();
                System.out.println("O Carrinho agora está vazio");
                Thread.sleep(2000);
                carrinho();
                break;
            case 4:
                menu();
                break;
            default:
                System.out.println("Opção inválida.");
                Thread.sleep(1000);
                scanner.nextLine();
                limpeza();
                carrinho();
                break;
        }
    }

    // (3) area do cliente
    public static void cliente() throws Exception{
        limpeza();
        System.out.println("Área do Cliente");
        System.out.println("");
        Thread.sleep(2000);

        System.out.println("Digite a opção desejada:");
        System.out.println("1. Dados do Cliente");
        System.out.println("2. Histórico de compras");
        System.out.println("3. Retornar ao Menu Inicial\n");

        try {
            int opcao= scanner.nextInt();
            limpeza();
            switch (opcao) {
                case 1:
                    System.out.println("Dados do Cliente:");
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("Email: " + cliente.getEmail());
                    System.out.println("Idade: " + cliente.getIdade());
                    System.out.println("Endereço: " + cliente.getEndereco());
                    System.out.println("Telefone: " + cliente.getTelefone());
                    Thread.sleep(5000);
                    cliente();
                    break;
                case 2:
                    cliente.exibirHistoricoDeCompras();
                    Thread.sleep(5000);
                    cliente();
                    break;
                case 3:
                    menu();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Insira um valor válido");
            Thread.sleep(2000);
            scanner.nextLine();
            cliente();
        }
    }

    // (4) area do funcionario
    public static void funcionario() throws InterruptedException{
        limpeza();
        System.out.println("Área do Funcionário\n");
        Thread.sleep(2000);

        System.out.println("Digite a opção desejada:");
        System.out.println("1. Adicionar Funcionário");
        System.out.println("2. Remover Funcionário");
        System.out.println("3. Lista de Funcionário");
        System.out.println("4. Retornar ao Menu Inicial\n");

        try {
            int opcao= scanner.nextInt();
            limpeza();
            switch (opcao) {
                case 1:
                    try {
                        System.out.println("Adicione as informações requisitadas");
                        scanner.nextLine();
                        System.out.println("Nome:");
                        String nomeFuncionario = scanner.nextLine();
                        System.out.println("Email: ");
                        String emailFuncionario = scanner.nextLine();
                        System.out.println("Telefone: ");
                        long telefoneFuncionario = scanner.nextLong();
                        scanner.nextLine();
                        System.out.println("Cargo: ");
                        String cargoFuncionario = scanner.nextLine();
                        System.out.println("Salário: ");
                        float salarioFuncionario = scanner.nextFloat();
                        scanner.nextLine();
                        System.out.println("Senha: ");
                        String senhaFuncionario = scanner.nextLine().toUpperCase();

                        Funcionario novoFuncionario = new Funcionario(nomeFuncionario, emailFuncionario, telefoneFuncionario, cargoFuncionario, salarioFuncionario, senhaFuncionario);
                        funcionarios.add(novoFuncionario);


                        System.out.println("Funcionário adicionado com sucesso!");
                        Thread.sleep(1000);
                        funcionario();
                        break;
                    } catch (Exception e) {
                        System.out.println("insira um valor válido!");
                        Thread.sleep(1000);
                        scanner.nextLine();
                        limpeza();
                        funcionario();
                        break;
                    }
                case 2:
                    scanner.nextLine();
                    System.out.println("Digite o nome do funcionário que deseja remover:");
                    String nomeFuncionarioRemover = scanner.nextLine();
                    for (int i = 0; i < funcionarios.size(); i++) {
                        Funcionario func = funcionarios.get(i);
                        if (func.getNome().equals(nomeFuncionarioRemover)) {
                            funcionarios.remove(i);
                            System.out.println("Funcionário removido com sucesso!");
                            Thread.sleep(2000);
                            funcionario();
                        }
                    }
                    System.out.println("Funcionário não encontrado.");
                    Thread.sleep(2000);
                    funcionario();
                    break;
                case 3:
                    System.out.println("Lista de Funcionários:\n");
                    for (Funcionario func : funcionarios) {
                        System.out.println("Nome: " + func.getNome());
                        System.out.println("Email: " + func.getEmail());
                        System.out.println("Telefone: " + func.getTelefone());
                        System.out.println("Cargo: " + func.getCargo());
                        System.out.println("Salário: " + func.getSalario());
                        System.out.println();
                    }
                    Thread.sleep(8000);
                    funcionario();
                    break;
                case 4:
                    menu();
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("insira um valor válido!");
            Thread.sleep(1000);
            limpeza();
            scanner.nextLine();
            funcionario();
        }
    }

    //metodo principal
    public static void main(String[] args) throws Exception {
        limpeza();
        System.out.println("Bem-Vindo ao MarketONE\n");
        Thread.sleep(2000);
        try {
            System.out.println("Adicione as informações requisitadas para poder acessar o aplicativo\n");
            System.out.println("Seu Nome:");
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

            cliente = new Usuario(nomeCliente, emailCliente, idadeCliente, enderecoCliente, telefoneCliente);

            System.out.println("\nUsuário adicionado com sucesso");
            Thread.sleep(1000);
            menu();
        } catch (Exception e) {
            System.out.println("insira um valor válido!");
            Thread.sleep(1000);
            scanner.nextLine();
            limpeza();
            main(null);
        }
    }
}
