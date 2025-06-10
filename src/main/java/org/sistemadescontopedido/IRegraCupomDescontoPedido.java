package org.sistemadescontopedido;

import org.model.Pedido;

public interface IRegraCupomDescontoPedido {
    void calcularValorDescontado(Pedido pedido);
}
