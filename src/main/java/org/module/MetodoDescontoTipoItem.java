package org.module;

import org.model.CupomDescontoEntrega;
import org.model.Item;
import org.model.Pedido;

import java.util.HashMap;
import java.util.Map;

public class MetodoDescontoTipoItem implements IMetodoDescontoTaxaEntrega {
    private Map<String,Double> descontosPorTipoItem;

    public MetodoDescontoTipoItem(){
        descontosPorTipoItem = new HashMap<String,Double>();
        descontosPorTipoItem.put("alimentação", 5.0);
        descontosPorTipoItem.put("educação", 2.0);
        descontosPorTipoItem.put("lazer", 1.5);
    }

    @Override
    public void calcularDesconto(Pedido pedido, Double penalidade) {
        for (Item item : pedido.getItens()) {
            if (descontosPorTipoItem.containsKey(item.getTipo().toLowerCase()) && pedido.getDescontoConcedido()<10) {
                if (pedido.getDescontoConcedido()+descontosPorTipoItem.get(item.getTipo().toLowerCase())>10){
                    penalidade=descontosPorTipoItem.get(item.getTipo().toLowerCase())+pedido.getDescontoConcedido()-10;
                }
                pedido.addCupomDescontoEntrega(new CupomDescontoEntrega("Cupom por Item do Tipo -" + item.getTipo(), descontosPorTipoItem.get(item.getTipo().toLowerCase())-penalidade));
            }
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        for (Item item : pedido.getItens()) {
            if (descontosPorTipoItem.containsKey(item.getTipo().toLowerCase())){
                return true;
            }
        }
        return false;
    }

    public Double getValorDesconto(Pedido pedido){
        Double valortotal = 0.0;
        for (Item item : pedido.getItens()) {
            if (descontosPorTipoItem.containsKey(item.getTipo().toLowerCase())) {
                valortotal+=descontosPorTipoItem.get(item.getTipo().toLowerCase());
            }
        }
        return valortotal;
    }

}
