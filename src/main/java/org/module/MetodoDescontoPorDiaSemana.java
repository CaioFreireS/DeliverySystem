package org.module;

import org.model.Pedido;

public class MetodoDescontoPorDiaSemana implements IMetodoDescontoTaxaEntrega {
    @Override
    public void calcularDesconto(Pedido pedido, Double penalidade) {
    }
    @Override
    public boolean seAplica(Pedido pedido) {
        return false;
    }
    @Override
    public Double getValorDesconto(Pedido pedido) {
        return null;
    }
}
