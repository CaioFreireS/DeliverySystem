package org.AuxClass;

import org.model.Item;
import org.model.Pedido;

public class CalculadoraValorItensPedido {

    public void calcularValorPedido(Pedido pedido){
        Double valorTotal=0.0;

        for (Item item : pedido.getItens()) {
            valorTotal += item.getValorTotal();
        }

        pedido.setValorPedido(valorTotal + pedido.getTaxaEntrega());
    }
}
