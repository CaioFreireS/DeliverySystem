package org.model;

public class CupomDescontoEntrega {
    private String nomeMetodo;
    private Double valorDesconto;

    public CupomDescontoEntrega(String nomeMetodo, Double valorDesconto){
        if(nomeMetodo == null || nomeMetodo.isEmpty()){
            throw new RuntimeException("ERRO! Nome do Metodo de Desconto não pode ser vazio!");
        }
        this.nomeMetodo=nomeMetodo;
        if(valorDesconto == null){
            throw new RuntimeException("ERRO! Valor do Desconto não pode ser vazio!");
        }
        this.valorDesconto=valorDesconto;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }

    public void setValorDesconto(Double valorDesconto) {
        if(valorDesconto == null){
            throw new RuntimeException("ERRO! Valor do Desconto não pode ser vazio!");
        }
        this.valorDesconto = valorDesconto;
    }

    public void setNomeMetodo(String nomeMetodo) {
        if(nomeMetodo == null || nomeMetodo.isEmpty()){
            throw new RuntimeException("ERRO! Nome do Metodo de Desconto não pode ser vazio!");
        }
        this.nomeMetodo = nomeMetodo;
    }

    @Override
    public String toString() {
        return "CupomDescontoEntrega{" +
                "nomeMetodo='" + nomeMetodo + '\'' +
                ", valorDesconto= R$ " + valorDesconto +
                '}';
    }
}
