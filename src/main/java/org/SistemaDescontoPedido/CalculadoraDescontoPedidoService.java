package org.SistemaDescontoPedido;

import org.model.CupomDescontoPedido;
import org.model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraDescontoPedidoService {
    private List<iCategoriaDescontoPedido> cuponsAtivos;

    public CalculadoraDescontoPedidoService(){
        cuponsAtivos = new ArrayList<iCategoriaDescontoPedido>();
        cuponsAtivos.add(new CupomPercentual());
    }

    public void calcularValorDesconto(Pedido pedido, String codigo){
        pedido.setCupomDescontoPedido(new CupomDescontoPedido(codigo));
        for (iCategoriaDescontoPedido cupom : cuponsAtivos){
            cupom.calcularValorDescontado(pedido);
        }
        if (pedido.getCupomDescontoPedido().getValorDescontado()==null){
            pedido.setCupomDescontoPedido(null);
        }
    }
}
