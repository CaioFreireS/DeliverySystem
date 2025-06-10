package org.sistemadescontopedido;

import org.model.CupomDescontoPedido;

import java.util.ArrayList;
import java.util.List;

public class CupomDescontoPedidoRepository {
    private List<CupomDescontoPedido> cuponsValidos;

    public CupomDescontoPedidoRepository() {
        cuponsValidos = new ArrayList<CupomDescontoPedido>();
        cuponsValidos.add(new CupomDescontoPedido("NATALFELIZ", 0.10));
        cuponsValidos.add(new CupomDescontoPedido("DIANAM15", 0.15));
        cuponsValidos.add(new CupomDescontoPedido("DESC10", 0.10));
        //...
        cuponsValidos.add(new CupomDescontoPedido("DESC20", 0.20));
    }

    public boolean eValido(String codigoCupom) {
        for(CupomDescontoPedido cupom: cuponsValidos) {
            if (cupom.getCodigoDescontoPedido().equals(codigoCupom)){
                return true;
            }
        }
        return false;
    }

}
