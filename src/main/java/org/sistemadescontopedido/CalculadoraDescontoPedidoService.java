package org.sistemadescontopedido;

import org.model.CupomDescontoPedido;
import org.model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraDescontoPedidoService {
    private List<ICategoriaCupomDescontoPedido> categoriasCupomDescontoPedido;

    public CalculadoraDescontoPedidoService(){
        categoriasCupomDescontoPedido = new ArrayList<ICategoriaCupomDescontoPedido>();
        categoriasCupomDescontoPedido.add(new CategoriaCupomPercentual());
    }

    public void calcularValorDesconto(Pedido pedido, String codigo){
        for (ICategoriaCupomDescontoPedido categoriaCupom : categoriasCupomDescontoPedido){
            if(categoriaCupom.seAplica(pedido,codigo)){
                categoriaCupom.calcularValorDescontado(pedido,codigo);
            }
        }

    }
}
