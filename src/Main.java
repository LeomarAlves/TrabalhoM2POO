import java.util.ArrayList;
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
                    System.out.println("--Cadastrar cliente--");
                    System.out.println("Nome: ");
                    String nomeC = input.nextLine();
                    System.out.println("Endereço: ");
                    String enderecoC = input.nextLine();
                    System.out.println("Telefone: ");
                    String telefoneC = input.nextLine();
                    Cliente c = new Cliente(nomeC, enderecoC, telefoneC);
                    clientes.add(c);
                    System.out.println("Cliente cadastrado com sucesso! ");
                    input.nextLine();
                break;

                case 2:
                    System.out.println("--Cadastrar produto--");
                    System.out.println("Nome: ");
                    String nomeP = input.nextLine();
                    System.out.println("Código: ");
                    int codigoP = input.nextInt();
                    System.out.println("Preço: ");
                    double precoP = input.nextDouble();
                    Produto p = new Produto(nomeP, codigoP, precoP);
                    produtos.add(p);
                    System.out.println("Produto cadastrado com sucesso!");
                    input.nextLine();
                break;

                case 3:
                    System.out.println("--Fazer pedido--");
                    System.out.println("Nome do cliente: ");
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
                        System.out.println("Endereço: ");
                        String enderecoCn = input.nextLine();
                        System.out.println("Telefone: ");
                        String telefoneCn = input.nextLine();
                        clienteEncontrado = new Cliente(nomeBusca, enderecoCn, telefoneCn);
                        clientes.add(clienteEncontrado);
                        System.out.println("Cliente cadastrado com sucesso! ");
                        input.nextLine();
                    }

            }
        }while (option != 5);

    }
}