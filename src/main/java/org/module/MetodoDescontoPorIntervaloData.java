package org.module;

import org.model.Pedido;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

public class MetodoDescontoPorIntervaloData implements IMetodoDescontoTaxaEntrega{
    private Map<Period,Double> descontosPorPeriodo;

    public MetodoDescontoPorIntervaloData(){
        descontosPorPeriodo= new HashMap<>();
        Period.between(LocalDate.of(2025,5, 22), LocalDate.of(2025,5, 22))
        descontosPorPeriodo.put();
    }

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