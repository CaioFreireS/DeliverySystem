package org.module;

import org.model.Pedido;

import java.util.List;
import java.util.ArrayList;

public class CalculadoraDeDescontoService {
    private List<IMetodoDescontoTaxaEntrega> metodosDeDesconto;
    private boolean interruptor;

    public CalculadoraDeDescontoService(){
        metodosDeDesconto = new ArrayList<>();
        metodosDeDesconto.add(new MetodoDescontoTaxaPorBairro());
        metodosDeDesconto.add(new MetodoDescontoTaxaPorTipoCliente());//adicionar o nenhum no tipo
        metodosDeDesconto.add(new MetodoDescontoTipoItem());
        metodosDeDesconto.add(new MetodoDescontoValorPedido(200.0));
    }

    public void calcularDesconto(Pedido pedido) {
        Double penalidade;
        if (interruptor) {
            for (IMetodoDescontoTaxaEntrega metodo : metodosDeDesconto){
                if(metodo.seAplica(pedido) && pedido.getDescontoConcedido()<10){
                    penalidade=penalizaDesconto(pedido, metodo);
                    metodo.calcularDesconto(pedido,penalidade);
                }
            }
        } else {
            System.out.println("Descontos Desligados");
        }
    }

    public void setInterruptor (boolean interruptor) {
        this.interruptor = interruptor;
    }

    public Double penalizaDesconto (Pedido pedido, IMetodoDescontoTaxaEntrega metodo) {
        if(metodo.getValorDesconto(pedido)>10){
            return metodo.getValorDesconto(pedido)-10;
        }
        return 0.0;
    }

}

