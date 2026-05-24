import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private Cliente cliente;
    private ArrayList<ItemPedido> produtos = new ArrayList<>();
    private boolean entrega;
    private double valor, troco;
    private static final double taxa_entrega = 9.99;
    private int forma_pagamento;
    private Date data;

    public Pedido(Cliente cliente, ArrayList<ItemPedido> produtos, boolean entrega, double valor, double troco, int forma_pagamento, Date data) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.entrega = entrega;
        this.valor = valor;
        this.troco = troco;
        this.forma_pagamento = forma_pagamento;
        this.data = data;
    }

    public Pedido(Cliente cliente, Date data) {
        this.cliente = cliente;
        this.data = data;
    }

    public void adicionarItem(ItemPedido item){
        produtos.add(item);
    }

    public double calcularPreco(){
        double total = 0.0;

        for(ItemPedido item : produtos){
            total += item.getProduto().getPreco() * item.getQuantidade();
        }
        if(entrega){
            total += taxa_entrega;
        }
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ItemPedido> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<ItemPedido> produtos) {
        this.produtos = produtos;
    }

    public boolean isEntrega() {
        return entrega;
    }

    public void setEntrega(boolean entrega) {
        this.entrega = entrega;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public int getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(int forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "cliente=" + getCliente() +
                ", produtos=" + getProdutos() +
                ", entrega=" + entrega +
                ", valor=" + getValor() +
                ", troco=" + getTroco() +
                ", forma_pagamento=" + getForma_pagamento() +
                ", data=" + getData() +
                '}';
    }
}
