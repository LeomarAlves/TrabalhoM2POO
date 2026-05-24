import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();

        int option;
        do{
            System.out.println("---Selecione uma opção---");
            System.out.println("1) Cadasrar cliente. ");
            System.out.println("2) Cadastrar produto. ");
            System.out.println("3) Fazer pedido. ");
            System.out.println("4) Listar pedidos. ");
            System.out.println("5) Sair. ");
            option = input.nextInt();

            switch (option){
                case 1:
                    input.nextLine();
                    System.out.println("--Cadastrar cliente--");
                    System.out.print("Nome: ");
                    String nomeC = input.nextLine();
                    System.out.print("Endereço: ");
                    String enderecoC = input.nextLine();
                    System.out.print("Telefone: ");
                    String telefoneC = input.nextLine();
                    Cliente c = new Cliente(nomeC, enderecoC, telefoneC);
                    clientes.add(c);
                    System.out.println("Cliente cadastrado com sucesso! ");
                    System.out.println("Aperte enter");
                    input.nextLine();
                break;

                case 2:
                    input.nextLine();
                    System.out.println("--Cadastrar produto--");
                    System.out.print("Nome: ");
                    String nomeP = input.nextLine();
                    System.out.print("Código: ");
                    int codigoP = input.nextInt();
                    System.out.print("Preço: ");
                    double precoP = input.nextDouble();
                    Produto p = new Produto(nomeP, codigoP, precoP);
                    produtos.add(p);
                    System.out.println("Produto cadastrado com sucesso!");
                    System.out.println("Aperte Enter ");
                    input.nextLine();
                    input.nextLine();
                break;

                case 3:
                    input.nextLine();
                    System.out.println("--Fazer pedido--");
                    System.out.print("Nome do cliente: ");
                    String nomeBusca = input.nextLine();
                    Cliente clienteEncontrado = null;
                    for(Cliente cl : clientes){
                        if(cl.getNome().equalsIgnoreCase(nomeBusca)){
                            clienteEncontrado = cl;
                            break;
                        }
                    }
                    if(clienteEncontrado == null){
                        System.out.println("Cliente" + nomeBusca + "não encontrado! Finalizar cadastro: ");
                        System.out.print("Endereço: ");
                        String enderecoCn = input.nextLine();
                        System.out.print("Telefone: ");
                        String telefoneCn = input.nextLine();
                        clienteEncontrado = new Cliente(nomeBusca, enderecoCn, telefoneCn);
                        clientes.add(clienteEncontrado);
                        System.out.println("Cliente cadastrado com sucesso! ");
                        input.nextLine();
                    }

                    Pedido novoPedido = new Pedido(clienteEncontrado, new Date());

                    int resp;
                    do{
                        System.out.print("Código do produto: ");
                        int codBusca = input.nextInt();
                        Produto produtoEncontrado = null;
                        for(Produto pe : produtos){
                            if(pe.getCodigo() == codBusca){
                                produtoEncontrado = pe;
                                break;
                            }
                        }
                        if(produtoEncontrado != null){
                            System.out.print("Informe a quantidade: ");
                            int quantP = input.nextInt();
                            ItemPedido itemP = new ItemPedido(produtoEncontrado, quantP);
                            novoPedido.adicionarItem(itemP);
                        }else{
                            System.out.println("Produto não encontrado. ");
                        }
                        System.out.print("Digite 1 para novo produto ou 0 para sair: ");
                        resp = input.nextInt();
                    }while (resp != 0);

                    int opcaoEntrega;
                    System.out.print("Pedido para entrega? \n Digite 1 para SIM ou 0 para NÃO: ");
                    opcaoEntrega = input.nextInt();
                    if (opcaoEntrega == 1){
                        novoPedido.setEntrega(true);
                    }

                    novoPedido.setValor(novoPedido.calcularPreco());
                    System.out.println("Sub total = " + novoPedido.getValor());

                    int opcaoPaga;
                    System.out.println("Forma de pagamento \n Digite 1 para dinheiro ou 0 para cartão:");
                    opcaoPaga = input.nextInt();
                    if(opcaoPaga == 1){
                        double valorPagamento;
                        System.out.println("Sub total: " + novoPedido.getValor() + "\n Informe o valor para troco: ");
                        valorPagamento = input.nextDouble();
                        novoPedido.setTroco(valorPagamento - novoPedido.getValor());
                        System.out.println("Troco: " + novoPedido.getTroco());
                    }

                    pedidos.add(novoPedido);

                break;

                case 4:
                    for(Pedido pedido : pedidos){
                        System.out.println(pedido);
                    }
                break;
            }
        }while (option != 5);

    }
}