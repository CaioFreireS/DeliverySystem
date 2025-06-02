package org.SistemaDesconto;

import org.model.Pedido;

public interface IMetodoDescontoTaxaEntrega {
    public void calcularDesconto(Pedido pedido);
    public boolean seAplica(Pedido pedido);
}
