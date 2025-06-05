package org.sistemadescontoentrega;

import org.model.CupomDescontoEntrega;
import org.model.Pedido;

import java.util.HashMap;
import java.util.Map;

public class MetodoDescontoTaxaPorTipoCliente implements IMetodoDescontoTaxaEntrega {
    private Map<String, Double> descontosPorTipoCliente;
    private String tipoCliente;

    public MetodoDescontoTaxaPorTipoCliente() {
        descontosPorTipoCliente = new HashMap<>();
        descontosPorTipoCliente.put("ouro", 3.0);
        descontosPorTipoCliente.put("prata", 2.0);
        descontosPorTipoCliente.put("bronze", 1.0);
        descontosPorTipoCliente.put("nenhum",0.0);
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        if(pedido == null) {
            throw new RuntimeException("ERRO! Pedido não pode ser nulo");
        }
        pedido.addCupomDescontoEntrega(new CupomDescontoEntrega("Cupom Por Tipo de Cliente ("+tipoCliente+")",descontosPorTipoCliente.get(tipoCliente.toLowerCase())));
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        if(pedido == null) {
            throw new RuntimeException("ERRO! Pedido não pode ser nulo");
        }
        tipoCliente=pedido.getClient().getTipo();
        return descontosPorTipoCliente.containsKey(tipoCliente.toLowerCase());
    }

}
