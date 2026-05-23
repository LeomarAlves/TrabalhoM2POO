import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    Cliente cliente;
    private ArrayList<ItemPedido> itens;
    private boolean entrega;
    private double taxa_entrega, valor, troco;
    private int forma_pagamento;
    Date data;

    public Pedido(Cliente cliente, ArrayList<ItemPedido> itens, boolean entrega, double taxa_entrega, double valor, double troco, int forma_pagamento, Date data) {
        this.cliente = cliente;
        this.itens = itens;
        this.entrega = entrega;
        this.taxa_entrega = taxa_entrega;
        this.valor = valor;
        this.troco = troco;
        this.forma_pagamento = forma_pagamento;
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemPedido> itens) {
        this.itens = itens;
    }

    public boolean isEntrega() {
        return entrega;
    }

    public void setEntrega(boolean entrega) {
        this.entrega = entrega;
    }

    public double getTaxa_entrega() {
        return taxa_entrega;
    }

    public void setTaxa_entrega(double taxa_entrega) {
        this.taxa_entrega = taxa_entrega;
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
                ", itens=" + getItens() +
                ", entrega=" + entrega +
                ", taxa_entrega=" + getTaxa_entrega() +
                ", valor=" + getValor() +
                ", troco=" + getTroco() +
                ", forma_pagamento=" + getForma_pagamento() +
                ", data=" + getData() +
                '}';
    }
}
