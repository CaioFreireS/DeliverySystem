package org.model;

public class CupomDescontoPedido {
    private String codigoDescontoPedido;
    private Double percentualDescontoPedido;
    private Double valorDescontado;

    public CupomDescontoPedido(String codigo) {
        if(codigo == null || codigo.isEmpty()){
            throw new NullPointerException("ERRO! Codigo do cupom não pode ser vazio.");
        }
        this.codigoDescontoPedido = codigo;
        this.percentualDescontoPedido = 0.0;
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

    public void setPercentualDescontoPedido(Double percentualDescontoPedido) {
        if(percentualDescontoPedido == null || percentualDescontoPedido < 0){
            throw new RuntimeException("ERRO! Percentual de desconto não pode ser vazio.");
        }
        this.percentualDescontoPedido = percentualDescontoPedido;
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
