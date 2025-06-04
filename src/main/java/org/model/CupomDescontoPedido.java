package org.model;

public class CupomDescontoPedido {
    private String codigoDescontoPedido;
    private Double percentualDescontoPedido;
    private Double valorDescontado;

    public CupomDescontoPedido(String codigo) {
        this.codigoDescontoPedido = codigo;
    }
    public String getCodigoDescontoPedido() {
        return codigoDescontoPedido;
    }

    public Double getPercentualDescontoPedido() {
        return percentualDescontoPedido;
    }

    public void setPercentualDescontoPedido(Double percentualDescontoPedido) {
        this.percentualDescontoPedido = percentualDescontoPedido;
    }

    public Double getValorDescontado() {
        return valorDescontado;
    }

    public void setValorDescontado(Double valorDescontado) {
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
