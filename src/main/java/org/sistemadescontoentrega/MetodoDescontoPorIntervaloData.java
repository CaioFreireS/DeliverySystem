package org.sistemadescontoentrega;

import org.model.CupomDescontoEntrega;
import org.model.Pedido;

import java.time.LocalDate;

public class MetodoDescontoPorIntervaloData implements IMetodoDescontoTaxaEntrega {
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private Double valorDesconto;

    public MetodoDescontoPorIntervaloData() {
        this.dataInicial = LocalDate.now();
        this.dataFinal = LocalDate.now();
        this.valorDesconto = 100.0;
    }

    public MetodoDescontoPorIntervaloData(LocalDate dataInicial, LocalDate dataFinal, Double valorDesconto) {
        if(dataInicial == null){
            throw new RuntimeException("ERRO! Data inicial do Desconto não pode ser nulo");
        }
        this.dataInicial = dataInicial;
        if(dataFinal == null){
            throw new RuntimeException("ERRO! Data final do desconto não pode ser nulo");
        }
        this.dataFinal = dataFinal;
        if(valorDesconto == null || valorDesconto < 0){
            throw new RuntimeException("ERRO! Valor do Desconto não pode ser nulo ou menor ou igual a 0");
        }
        this.valorDesconto = valorDesconto;
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        if(pedido == null) {
            throw new RuntimeException("ERRO! Pedido não pode ser nulo");
        }
        pedido.addCupomDescontoEntrega(new CupomDescontoEntrega("Desconto do dia: "+dataInicial+"<>"+dataFinal, (pedido.getTaxaEntrega()*valorDesconto)/100));
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        if(pedido == null) {
            throw new RuntimeException("ERRO! Pedido não pode ser nulo");
        }
        return pedido.getData().isAfter(dataInicial) && pedido.getData().isBefore(dataFinal);
    }

}
