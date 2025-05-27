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

    public Pedido(Cliente cliente, LocalDate data){
        this.taxaEntrega = 10;
        this.data = data;
        this.cliente = cliente;
        this.itens = new ArrayList<Item>();
        this.cuponsDescontoEntrega = new ArrayList<CupomDescontoEntrega>();
    }

    public void adicionarItem(Item item){
        itens.add(item);
    }

    public Double getValorPedido(){
        Double valorTotal=0.0;

        for (Item item : this.itens) {
            valorTotal += item.getValorTotal();
        }

        aplicarDesconto();

        return valorTotal + this.taxaEntrega;
    }

    public Cliente getClient(){
        return this.cliente;
    }

    public ArrayList<Item> getItens(){
        return (ArrayList<Item>) this.itens;
    }

    public Double getTaxaEntrega(){
        aplicarDesconto();
        return this.taxaEntrega;
    }

    public void addCupomDescontoEntrega(CupomDescontoEntrega desconto){
        cuponsDescontoEntrega.add(desconto);
    }

    public void aplicarDesconto(){
        for(CupomDescontoEntrega cupom : cuponsDescontoEntrega){
            this.taxaEntrega -= cupom.getValorDesconto();
            if (this.taxaEntrega < 0) {
                this.taxaEntrega = 0;
            }
        }
    }

    public Double getDescontoConcedido(){
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

    @Override
    public String toString() {
        return "Pedido{" +
                "taxaEntrega=" + taxaEntrega +
                ", cliente=" + cliente.getNome() +
                ", itens=" + itens +
                ", cuponsDescontoEntrega=" + cuponsDescontoEntrega +
                ", valor do Pedido=" + getValorPedido() +
                '}';
    }
}
