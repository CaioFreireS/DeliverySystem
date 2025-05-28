package org.module;

import org.model.CupomDescontoEntrega;
import org.model.Pedido;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class CalculadoraDeDescontoService {
    private List<IMetodoDescontoTaxaEntrega> metodosDeDesconto;
    private boolean interruptor;

    public CalculadoraDeDescontoService(){
        metodosDeDesconto = new ArrayList<>();
        metodosDeDesconto.add(new MetodoDescontoTaxaPorBairro());
        metodosDeDesconto.add(new MetodoDescontoTaxaPorTipoCliente());
        metodosDeDesconto.add(new MetodoDescontoPorDiaSemana());
        metodosDeDesconto.add(new MetodoDescontoPorIntervaloData(LocalDate.of(2025,5,23),LocalDate.of(2025,5,28),10.0));
        metodosDeDesconto.add(new MetodoDescontoTipoItem());
        metodosDeDesconto.add(new MetodoDescontoValorPedido(200.0));}

    public void calcularDesconto(Pedido pedido) {
        if (interruptor) {
            for (IMetodoDescontoTaxaEntrega metodo : metodosDeDesconto){
                if(metodo.seAplica(pedido) && pedido.getDescontoConcedido()<pedido.getTaxaEntrega()){
                    metodo.calcularDesconto(pedido);
                    penalizaDesconto(pedido);
                }
            }
        } else {
            System.out.println("Descontos Desligados");
        }
    }

    public void setInterruptor (boolean interruptor) {
        this.interruptor = interruptor;
    }

    public void penalizaDesconto(Pedido pedido) {
        Double descontoAtual = pedido.getDescontoConcedido();
        ArrayList<CupomDescontoEntrega> cupons = pedido.getCuponsDescontoEntrega();
        CupomDescontoEntrega cupomFinal = cupons.get(cupons.size()-1);
        Double penalidade = descontoAtual - pedido.getTaxaEntrega();

        if (descontoAtual > pedido.getTaxaEntrega()){
            cupomFinal.setNomeMetodo(cupomFinal.getNomeMetodo() + " -Penalizado em " + penalidade + "R$");
            cupomFinal.setValorDesconto(cupomFinal.getValorDesconto() - penalidade);
        }
    }


}

