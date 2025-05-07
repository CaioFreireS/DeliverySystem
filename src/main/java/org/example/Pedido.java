package org.example;

import java.util.ArrayList;

public class Pedido {
    private double taxaEntrega;
    private Cliente cliente;
    private ArrayList<Item> itens;
    private ArrayList<CupomDescontoEntrega> cuponsDescontoEntrega;

    public Pedido(Cliente cliente, ArrayList<Item> itens, ArrayList<CupomDescontoEntrega> cuponsDescontoEntrega){
        this.taxaEntrega=10;
        this.cliente=cliente;
        this.itens= itens;
        this.cuponsDescontoEntrega = cuponsDescontoEntrega;
    }

    public void addItem(Item item){
        itens.add(item);
    }

    public void addDesconto(CupomDescontoEntrega cupom){
        cuponsDescontoEntrega.add(cupom);
    }

    public String getItens(){
        String itensEscritos = "";
        this.itens.forEach(item -> {
            itensEscritos= itensEscritos+"nome: "+;
        });
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "taxaEntrega=" + taxaEntrega +
                ", cliente=" + cliente.getNome() +
                ", itens=" + itens +
                ", cuponsDescontoEntrega=" + cuponsDescontoEntrega +
                '}';
    }
}
