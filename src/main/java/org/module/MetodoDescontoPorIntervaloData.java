package org.module;

import org.model.Pedido;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

public class MetodoDescontoPorIntervaloData implements IMetodoDescontoTaxaEntrega{
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private Double descontoPorIntervaloDataPercentual;

    public MetodoDescontoPorIntervaloData(){
        dataInicial=LocalDate.now();
        dataFinal=LocalDate.now();
    }

    public MetodoDescontoPorIntervaloData(LocalDate dataInicial, LocalDate dataFinal, Double descontoPorIntervaloDataPercentual){
        this.dataInicial=dataInicial;
        this.dataFinal=dataFinal;
        this.descontoPorIntervaloDataPercentual=descontoPorIntervaloDataPercentual;
    }

    @Override
    public void calcularDesconto(Pedido pedido, Double penalidade) {
    }
    @Override
    public boolean seAplica(Pedido pedido) {
        return(pedido.getData().isAfter(dataInicial) && pedido.getData().isBefore(dataFinal));
    }
    @Override
    public Double getValorDesconto(Pedido pedido) {
        return (pedido.getTaxaEntrega()-(pedido.getTaxaEntrega()/100)*descontoPorIntervaloDataPercentual);
    }
}