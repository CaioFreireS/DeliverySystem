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
        pedido.addCupomDescontoEntrega(new CupomDescontoEntrega("Cupom Por Tipo de Cliente ("+tipoCliente+")",descontosPorTipoCliente.get(tipoCliente.toLowerCase())));
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        tipoCliente=pedido.getClient().getTipo();
        if (tipoCliente.isEmpty()){
            tipoCliente="nenhum";
        }
        return descontosPorTipoCliente.containsKey(tipoCliente.toLowerCase());
    }

}
