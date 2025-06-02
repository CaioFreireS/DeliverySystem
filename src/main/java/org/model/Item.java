package org.model;

public class Item {
    private String nome;
    private Integer quantidade;
    private Double valorUnitario;
    private String tipo;

    public Item(String nome, Integer quantidade, Double valorUnitario, String tipo){
        this.nome=nome;
        this.quantidade=quantidade;
        this.valorUnitario=valorUnitario;
        this.tipo=tipo;
    }

    public Double getValorTotal(){
        return this.valorUnitario*this.quantidade;
    }

    public String getTipo(){
        return this.tipo;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", valorUnitario= R$ " + valorUnitario +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
