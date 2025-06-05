package org.sistemadescontoentrega;

import org.model.CupomDescontoEntrega;
import org.model.Pedido;

import java.util.HashMap;
import java.util.Map;


public class MetodoDescontoPorDiaSemana implements IMetodoDescontoTaxaEntrega {
    private Map<String, Double> descontoPorDiaSemana;

    public MetodoDescontoPorDiaSemana(){
        descontoPorDiaSemana=new HashMap<>();
        descontoPorDiaSemana.put("tuesday", 100.0);
        descontoPorDiaSemana.put("thursday", 60.0);
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        if(pedido == null) {
            throw new RuntimeException("ERRO! Pedido não pode ser nulo");
        }
        pedido.addCupomDescontoEntrega(new CupomDescontoEntrega("Desconto por dia da semana "+pedido.getData().getDayOfWeek().toString(), (pedido.getTaxaEntrega()*descontoPorDiaSemana.get(pedido.getData().getDayOfWeek().toString().toLowerCase()))/100));
    }
    @Override
    public boolean seAplica(Pedido pedido) {
        if(pedido == null) {
            throw new RuntimeException("ERRO! Pedido não pode ser nulo");
        }
        return descontoPorDiaSemana.containsKey(pedido.getData().getDayOfWeek().toString().toLowerCase());
    }

}
