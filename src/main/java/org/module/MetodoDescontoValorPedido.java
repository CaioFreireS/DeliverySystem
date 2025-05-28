package org.module;

import org.model.CupomDescontoEntrega;
import org.model.Pedido;

public class MetodoDescontoValorPedido implements IMetodoDescontoTaxaEntrega {
    private Double limiteValorPedido;
    private Double VALOR_DESCONTO;

    public MetodoDescontoValorPedido(Double limiteValorPedido) {
        this.limiteValorPedido = limiteValorPedido;
        this.VALOR_DESCONTO = 5.0;
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        pedido.addCupomDescontoEntrega(new CupomDescontoEntrega("Desconto para Pedido acima de "+limiteValorPedido+" R$", this.VALOR_DESCONTO));
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return (pedido.getValorPedido()>limiteValorPedido && pedido.getDescontoConcedido()<10);
    }

    public Double getValorDesconto(Pedido pedido) {
        return VALOR_DESCONTO;
    }
}
