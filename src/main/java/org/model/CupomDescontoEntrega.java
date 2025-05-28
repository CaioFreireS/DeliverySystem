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

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public void setNomeMetodo(String nomeMetodo) {
        this.nomeMetodo = nomeMetodo;
    }

    @Override
    public String toString() {
        return "CupomDescontoEntrega{" +
                "nomeMetodo='" + nomeMetodo + '\'' +
                ", valorDesconto=" + valorDesconto +
                '}';
    }
}
