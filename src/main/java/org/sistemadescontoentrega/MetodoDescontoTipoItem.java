package org.sistemadescontoentrega;

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
    public void calcularDesconto(Pedido pedido) {
        if(pedido == null) {
            throw new RuntimeException("ERRO! Pedido não pode ser nulo");
        } else if (pedido.getItens() == null) {
            throw new RuntimeException("ERRO! Seu pedido não possui nenhum item");
        }
        for (Item item : pedido.getItens()) {
            if (descontosPorTipoItem.containsKey(item.getTipo().toLowerCase()) && pedido.getDescontoEntregaConcedido()<pedido.getTaxaEntrega()) {
                pedido.addCupomDescontoEntrega(new CupomDescontoEntrega("Cupom por Item do Tipo (" + item.getTipo() + ")", descontosPorTipoItem.get(item.getTipo().toLowerCase())));
            }
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        if(pedido == null) {
            throw new RuntimeException("ERRO! Pedido não pode ser nulo");
        } else if (pedido.getItens() == null) {
            throw new RuntimeException("ERRO! Seu pedido não possui nenhum item");
        }
        for (Item item : pedido.getItens()) {
            if (descontosPorTipoItem.containsKey(item.getTipo().toLowerCase())){
                return true;
            }
        }
        return false;
    }



}
