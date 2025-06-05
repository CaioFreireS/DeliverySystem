package org.sistemadescontopedido;

import org.model.CupomDescontoPedido;
import org.model.Pedido;

public interface ICategoriaCupomDescontoPedido {
    void calcularValorDescontado(Pedido pedido, String codigo);
    boolean seAplica(Pedido pedido, String codigo);
}
