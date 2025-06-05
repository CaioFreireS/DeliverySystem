package org.sistemadescontoentrega;

import org.model.CupomDescontoEntrega;
import org.model.Pedido;

public class MetodoDescontoValorPedido implements IMetodoDescontoTaxaEntrega {
    private Double limiteValorPedido;
    private Double VALOR_DESCONTO;

    public MetodoDescontoValorPedido(Double limiteValorPedido) {
        if(limiteValorPedido == null || limiteValorPedido < 0){
            throw new RuntimeException("ERRO! O limite do valor do pedido não pode ser vazio ou negativo.");
        }
        this.limiteValorPedido = limiteValorPedido;
        this.VALOR_DESCONTO = 5.0;
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        if(pedido == null) {
            throw new RuntimeException("ERRO! Pedido não pode ser nulo");
        }
        pedido.addCupomDescontoEntrega(new CupomDescontoEntrega("Desconto para Pedido acima de "+limiteValorPedido+" R$", this.VALOR_DESCONTO));
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        if(pedido == null) {
            throw new RuntimeException("ERRO! Pedido não pode ser nulo");
        }
        return (pedido.getValorPedido()>limiteValorPedido && pedido.getDescontoEntregaConcedido()<10);
    }

}
