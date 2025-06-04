package org.SistemaDescontoPedido;

import org.model.CupomDescontoPedido;
import org.model.Pedido;

import java.util.HashMap;
import java.util.Map;

public class CupomPercentual implements iCategoriaDescontoPedido{

    private Map<String, Double> descontoPercentual;

    public CupomPercentual(){
        descontoPercentual = new HashMap<String, Double>();
        descontoPercentual.put("DESC10", 10.0);
        descontoPercentual.put("DESC20", 20.0);
        descontoPercentual.put("DESC30", 30.0);
        descontoPercentual.put("NATAL12", 12.0);
        descontoPercentual.put("DIAPAIS12", 12.0);
        descontoPercentual.put("PROMO10", 10.0);
        descontoPercentual.put("DIAMAES15", 15.0);
        descontoPercentual.put("RELAMPAGO50", 50.0);
    }

    @Override
    public void calcularValorDescontado(Pedido pedido) {
        CupomDescontoPedido cupom = pedido.getCupomDescontoPedido();
        cupom.setPercentualDescontoPedido(descontoPercentual.get(cupom.getCodigoDescontoPedido().toUpperCase()));
        cupom.setValorDescontado(pedido.getValorPedido()*(descontoPercentual.get(cupom.getCodigoDescontoPedido().toUpperCase()))/100);
    }
}
