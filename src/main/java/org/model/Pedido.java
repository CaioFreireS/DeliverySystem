package org.model;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Pedido {
    private double taxaEntrega;
    private LocalDate data;
    private Cliente cliente;
    private List<Item> itens;
    private List<CupomDescontoEntrega> cuponsDescontoEntrega;
    private CupomDescontoPedido cupomDescontoPedido;
    private Double valorPedidoTotal;
    private Double descontoPedido;

    public Pedido(Cliente cliente, LocalDate data){
        this.taxaEntrega = 10;
        if (data == null){
            throw new RuntimeException("ERRO! Data não pode ser vazia.");
        }
        this.data = data;
        if (cliente == null){
            throw new RuntimeException("ERRO! Cliente não pode ser vazio.");
        }
        this.cliente = cliente;
        this.itens = new ArrayList<Item>();
        this.cuponsDescontoEntrega = new ArrayList<CupomDescontoEntrega>();
        this.cupomDescontoPedido = null;
        this.valorPedidoTotal = 0.0;
        this.descontoPedido = 0.0;
    }

    public Double getValorPedidoTotal() {
        return valorPedidoTotal + this.taxaEntrega;
    }

    public Double getValorPedido(){
        if(this.valorPedidoTotal == 0){
            Double valorTotal=0.0;

            for (Item item : this.getItens()) {
                valorTotal += item.getValorTotal();
            }

            this.valorPedidoTotal=(valorTotal);
        }
        return(this.getValorPedidoTotal() - this.descontoPedido);
    }

    public Cliente getClient(){
        return this.cliente;
    }

    public ArrayList<Item> getItens(){
        return (ArrayList<Item>) this.itens;
    }

    public Double getTaxaEntrega(){
        return this.taxaEntrega;
    }

    public Double getDescontoEntregaConcedido(){
        Double descontoConcedido = 0.0;

        for (CupomDescontoEntrega cupom : cuponsDescontoEntrega){
            descontoConcedido += cupom.getValorDesconto();
        }

        return descontoConcedido;
    }

    public ArrayList<CupomDescontoEntrega> getCuponsDescontoEntrega(){
        return (ArrayList<CupomDescontoEntrega>) this.cuponsDescontoEntrega;
    }

    public LocalDate getData() {
        return data;
    }

    public CupomDescontoPedido getCupomDescontoPedido() {
        return cupomDescontoPedido;
    }

    public void setDescontoPedido(Double descontoPedido) {
        if (descontoPedido == null){
            throw new RuntimeException("ERRO! Desconto por pedido não pode ser vazio.");
        }
        this.descontoPedido = descontoPedido;
    }

    public void setCupomDescontoPedido(CupomDescontoPedido novoCupom) {
        if (novoCupom == null){
            throw new RuntimeException("ERRO! Cupom de Desconto para Pedido não pode ser vazio.");
        }
        this.cupomDescontoPedido = novoCupom;
    }

    public void adicionarItem(Item item){
        if (item == null){
            throw new RuntimeException("ERRO! Item não pode ser vazio.");
        }
        itens.add(item);
    }

    public void addCupomDescontoEntrega(CupomDescontoEntrega desconto){
        if (desconto == null){
            throw new RuntimeException("ERRO! Cupom de Desconto para Entrega não pode ser vazio.");
        }
        cuponsDescontoEntrega.add(desconto);
    }

    public void aplicarDescontoEntrega(){
        Double descontoEntregaTotal = 0.0;
        for(CupomDescontoEntrega cupom : cuponsDescontoEntrega){
            descontoEntregaTotal += cupom.getValorDesconto();
        }
        this.taxaEntrega -= descontoEntregaTotal;
        if(this.taxaEntrega < 0){
            throw new RuntimeException("ERRO! Aplicou descontos de entrega a mais do limite.");
        }
    }

    public void aplicarDescontoPedido(){
        if (cupomDescontoPedido.getValorDescontado() <= 0){
            throw new RuntimeException("ERRO! Desconto por Pedido não pode ser menor ou igual a 0.");
        }
        this.setDescontoPedido(this.cupomDescontoPedido.getValorDescontado());
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "valor do Pedido= R$ " + getValorPedido() +
                ", taxaEntrega=" + taxaEntrega +
                ", cliente=" + cliente.getNome() +
                ", itens=" + itens +
                ", cuponsDescontoEntrega=" + cuponsDescontoEntrega +
                ", cupomDescontoPedido=" + cupomDescontoPedido +
                '}';
    }
}
