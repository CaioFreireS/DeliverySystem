package org.sistemadescontopedido;

import org.model.CupomDescontoPedido;
import org.model.Pedido;

import java.util.HashMap;
import java.util.Map;

public class RegraCupomPercentual implements IRegraCupomDescontoPedido {

    private CupomDescontoPedido cupom;

    public RegraCupomPercentual(CupomDescontoPedido cupom, CupomDescontoPedidoRepository repoCupom) {
        if(!repoCupom.eValido(cupom.getCodigoDescontoPedido())){
            throw new IllegalArgumentException("Esse Cupom de desconto não é valido!!");
        }
        this.cupom = cupom;
    }


    @Override
    public void calcularValorDescontado(Pedido pedido) {
        if (pedido == null) {
            throw new RuntimeException("Erro! O pedido não pode ser nulo!");
        }
        cupom.setValorDescontado(pedido.getValorPedidoTotal()*cupom.getPercentualDescontoPedido());
        CupomDescontoPedido cupomExistente = pedido.getCupomDescontoPedido();
        if (cupomExistente != null){
            if (cupom.getPercentualDescontoPedido() < cupomExistente.getPercentualDescontoPedido()){
                System.out.println("O desconto que você quer aplicar é menor que o ja existente!");
                return;
            }
        }
        pedido.setCupomDescontoPedido(cupom);
    }
}
