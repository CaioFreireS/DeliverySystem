package org.module;

import org.model.CupomDescontoEntrega;
import org.model.Pedido;

import java.util.HashMap;
import java.util.Map;

public class MetodoDescontoTaxaPorBairro implements IMetodoDescontoTaxaEntrega {
    private Map<String, Double> descontosPorBairro;
    private String bairroCliente;

    public MetodoDescontoTaxaPorBairro(){
        descontosPorBairro=new HashMap<>();
        descontosPorBairro.put("centro",2.0);
        descontosPorBairro.put("bela vista", 3.0);
        descontosPorBairro.put("cidade maravilhosa", 1.5);

    }

    @Override
    public void calcularDesconto(Pedido pedido, Double penalidade) {
        pedido.addCupomDescontoEntrega(new CupomDescontoEntrega("Cupom por Bairro -"+bairroCliente, descontosPorBairro.get(bairroCliente.toLowerCase())-penalidade));
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        bairroCliente=pedido.getClient().getBairro();
        return descontosPorBairro.containsKey(bairroCliente.toLowerCase());
    }

    public Double getValorDesconto(Pedido pedido){
        return descontosPorBairro.get(bairroCliente);
    }
}
