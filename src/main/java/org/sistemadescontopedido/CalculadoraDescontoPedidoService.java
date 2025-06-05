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
        if(pedido == null) {
            throw new RuntimeException("ERRO! Pedido não pode ser nulo");
        }
        if (codigo == null || codigo.isEmpty()) {
            throw new RuntimeException("ERRO! o Codigo do Desconto não pode ser nulo");
        }
        for (ICategoriaCupomDescontoPedido categoriaCupom : categoriasCupomDescontoPedido){
            if(categoriaCupom.seAplica(pedido,codigo)){
                categoriaCupom.calcularValorDescontado(pedido,codigo);
            }
        }

    }
}
