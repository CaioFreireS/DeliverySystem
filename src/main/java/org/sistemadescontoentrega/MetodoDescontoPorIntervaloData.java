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

    public MetodoDescontoPorIntervaloData(LocalDate dataInicial, LocalDate dataFinal, double valorDesconto) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.valorDesconto = valorDesconto;
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        pedido.addCupomDescontoEntrega(new CupomDescontoEntrega("Desconto do dia: "+dataInicial+"<>"+dataFinal, (pedido.getTaxaEntrega()*valorDesconto)/100));
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return pedido.getData().isAfter(dataInicial) && pedido.getData().isBefore(dataFinal);
    }

}
