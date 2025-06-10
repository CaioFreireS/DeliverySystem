package org.model;

public class CupomDescontoPedido {
    private String codigoDescontoPedido;
    private Double percentualDescontoPedido;
    private Double valorDescontado;

    public CupomDescontoPedido(String codigo, Double percentualDescontoPedido) {
        if(codigo == null || codigo.isEmpty()){
            throw new NullPointerException("ERRO! Codigo do cupom não pode ser vazio.");
        }
        this.codigoDescontoPedido = codigo;
        this.percentualDescontoPedido = percentualDescontoPedido;
        this.valorDescontado = 0.0;
    }
    public String getCodigoDescontoPedido() {
        return codigoDescontoPedido;
    }

    public Double getPercentualDescontoPedido() {
        return percentualDescontoPedido;
    }

    public Double getValorDescontado() {
        return valorDescontado;
    }

    public void setValorDescontado(Double valorDescontado) {
        if(valorDescontado == null || valorDescontado < 0){
            throw new RuntimeException("ERRO! Valor Descontado não pode ser vazio.");
        }
        this.valorDescontado = valorDescontado;
    }

    @Override
    public String toString() {
        return "CupomDescontoPedido{" +
                "codigoDescontoPedido='" + codigoDescontoPedido + '\'' +
                ", percentualDescontoPedido=" + percentualDescontoPedido + "%" +
                ", valorDescontado= R$" + valorDescontado +
                '}';
    }
}
