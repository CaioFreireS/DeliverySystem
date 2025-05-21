package org.model;

public class CupomDescontoEntrega {
    private String nomeMetodo;
    private Double valorDesconto;

    public CupomDescontoEntrega(String nomeMetodo, Double valorDesconto){
        this.nomeMetodo=nomeMetodo;
        this.valorDesconto=valorDesconto;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }

    @Override
    public String toString() {
        return "CupomDescontoEntrega{" +
                "nomeMetodo='" + nomeMetodo + '\'' +
                ", valorDesconto=" + valorDesconto +
                '}';
    }
}
