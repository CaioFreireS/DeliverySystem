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
    private Double valorPedido;

    public Pedido(Cliente cliente, LocalDate data){
        this.taxaEntrega = 10;
        this.data = data;
        this.cliente = cliente;
        this.itens = new ArrayList<Item>();
        this.cuponsDescontoEntrega = new ArrayList<CupomDescontoEntrega>();
        this.cupomDescontoPedido =  null;
    }

    public void adicionarItem(Item item){
        itens.add(item);
    }

    public Double getValorPedido(){
        return this.valorPedido;
    }

    public void setValorPedido(Double valorPedido) {
        this.valorPedido = valorPedido;
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
        for(CupomDescontoEntrega cupom : cuponsDescontoEntrega){
            this.taxaEntrega -= cupom.getValorDesconto();
            if (this.taxaEntrega < 0) {
                this.taxaEntrega = 0;
            }
        }
    }

    public void aplicarDescontoPedido(){
        this.valorPedido-=this.cupomDescontoPedido.getValorDescontado();
    }

    public Double getDescontoConcedido(){
        Double descontoConcedido = 0.0;

        for (CupomDescontoEntrega cupom : cuponsDescontoEntrega){
            descontoConcedido += cupom.getValorDesconto();
        }

        return descontoConcedido;
    }

    public CupomDescontoPedido getCupomDescontoPedido() {
        return cupomDescontoPedido;
    }

    public void setCupomDescontoPedido(CupomDescontoPedido cupomDescontoPedido) {
        this.cupomDescontoPedido = cupomDescontoPedido;
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
                "taxaEntrega=" + taxaEntrega +
                ", cliente=" + cliente.getNome() +
                ", itens=" + itens +
                ", cuponsDescontoEntrega=" + cuponsDescontoEntrega +
                ", cupomDescontoPedido=" + cupomDescontoPedido +
                ", valor do Pedido= R$ " + getValorPedido() +
                '}';
    }
}
