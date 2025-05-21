package org.module;

import org.model.Pedido;

public interface IMetodoDescontoTaxaEntrega {
    public void calcularDesconto(Pedido pedido, Double penalidade);
    public boolean seAplica(Pedido pedido);
    public Double getValorDesconto(Pedido pedido);
}
