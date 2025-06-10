package org.sistemadescontopedido;

import org.model.CupomDescontoPedido;
import org.model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraDescontoPedidoService {

    public void calcularValorDesconto(Pedido pedido, IRegraCupomDescontoPedido cupomDescontoPedido) {
        if(pedido == null) {
            throw new RuntimeException("ERRO! Pedido não pode ser nulo");
        }
        if (cupomDescontoPedido == null) {
            throw new RuntimeException("ERRO! o Cupom de Desconto não pode ser nulo");
        }

        cupomDescontoPedido.calcularValorDescontado(pedido);

    }
}
