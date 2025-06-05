package org.sistemadescontopedido;

import org.model.CupomDescontoPedido;
import org.model.Pedido;

import java.util.HashMap;
import java.util.Map;

public class CategoriaCupomPercentual implements ICategoriaCupomDescontoPedido {

    private Map<String, Double> descontoPercentual;
    private CupomDescontoPedido cupom;

    public CategoriaCupomPercentual(){
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
    public void calcularValorDescontado(Pedido pedido, String codigo) {
        if(pedido == null) {
            throw new RuntimeException("ERRO! Pedido não pode ser nulo");
        }
        if (codigo == null || codigo.isEmpty()) {
            throw new RuntimeException("ERRO! o Codigo do Desconto não pode ser nulo");
        }
        CupomDescontoPedido cupom = new CupomDescontoPedido(codigo);
        cupom.setPercentualDescontoPedido(descontoPercentual.get(cupom.getCodigoDescontoPedido().toUpperCase()));
        cupom.setValorDescontado(pedido.getValorPedidoTotal()*(descontoPercentual.get(cupom.getCodigoDescontoPedido().toUpperCase()))/100);
        pedido.setCupomDescontoPedido(cupom);
    }

    @Override
    public boolean seAplica(Pedido pedido, String codigo) {
        if(pedido == null) {
            throw new RuntimeException("ERRO! Pedido não pode ser nulo");
        }
        if (codigo == null || codigo.isEmpty()) {
            throw new RuntimeException("ERRO! o Codigo do Desconto não pode ser nulo");
        }
        return (descontoPercentual.containsKey(codigo.toUpperCase()) && pedido.getCupomDescontoPedido() == null || descontoPercentual.get(codigo.toUpperCase()) > pedido.getCupomDescontoPedido().getPercentualDescontoPedido());
    }
}
