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
        this.data = data;
        this.cliente = cliente;
        this.itens = new ArrayList<Item>();
        this.cuponsDescontoEntrega = new ArrayList<CupomDescontoEntrega>();
        this.cupomDescontoPedido = null;
        this.valorPedidoTotal = 0.0;
        this.descontoPedido = 0.0;
    }

    public void adicionarItem(Item item){
        itens.add(item);
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

    public void addCupomDescontoEntrega(CupomDescontoEntrega desconto){
        cuponsDescontoEntrega.add(desconto);
    }

    public void aplicarDescontoEntrega(){
        Double descontoEntregaTotal = 0.0;
        for(CupomDescontoEntrega cupom : cuponsDescontoEntrega){
            descontoEntregaTotal += cupom.getValorDesconto();
        }
        this.taxaEntrega -= descontoEntregaTotal;
    }

    public Double getDescontoEntregaConcedido(){
        Double descontoConcedido = 0.0;

        for (CupomDescontoEntrega cupom : cuponsDescontoEntrega){
            descontoConcedido += cupom.getValorDesconto();
        }

        return descontoConcedido;
    }

    public CupomDescontoPedido getCupomDescontoPedido() {
        return cupomDescontoPedido;
    }

    public void setDescontoPedido(Double descontoPedido) {
        this.descontoPedido = descontoPedido;
    }

    public void aplicarDescontoPedido(){
        this.setDescontoPedido(this.cupomDescontoPedido.getValorDescontado());
    }

    public void setCupomDescontoPedido(CupomDescontoPedido novoCupom) {
        this.cupomDescontoPedido = novoCupom;
    }

    public ArrayList<CupomDescontoEntrega> getCuponsDescontoEntrega(){
        return (ArrayList<CupomDescontoEntrega>) this.cuponsDescontoEntrega;
    }

    public LocalDate getData() {
        return data;
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
