package org;


import org.model.*;
import org.sistemadescontopedido.*;
import org.sistemadescontoentrega.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Cliente c1 = new Cliente("Caio","Ouro",10.0,"Rua S Robert Kennedy - 51", "Centro", "Alegre");
        Cliente c2 = new Cliente("Bernardo","Prata",10.0,"Rua S Robert Kennedy - 53", "Bela Vista", "Alegre");
        Cliente c3 = new Cliente("Lukas","Bronze",10.0,"Rua S Robert Kennedy - 53", "Cidade Maravilhosa", "Alegre");
        Cliente c4 = new Cliente("jao","",10.0,"Rua S Robert Kennedy - 53", "Cidade Maravilhosa", "Alegre");


        Pedido p1 = new Pedido(c1, LocalDate.now());
        Pedido p2 = new Pedido(c2, LocalDate.now());

        p1.adicionarItem(new Item("Hamburgue",1, 13.0, "Alimentação"));
        p1.adicionarItem(new Item("Coca-Cola Lata",1,5.0,"Alimentação"));
        p1.adicionarItem(new Item("Batata 500g", 1, 1.0, "Alimentação"));
        p1.adicionarItem(new Item("Conceitos basicos de JAVA", 1, 50.0, "Educação"));
        p1.adicionarItem(new Item("Skate", 1, 40.0, "Lazer"));

        p2.adicionarItem(new Item("Hamburgue",1, 13.0, "Alimentação"));

        System.out.println(p1.toString());

        CalculadoraDescontoEntregaService calc1 = new CalculadoraDescontoEntregaService();
        calc1.setInterruptor(true);

        calc1.calcularDesconto(p1);
        System.out.println("Sua taxa de entrega é: R$ "+ p1.getTaxaEntrega());
        System.out.println("Descontos Concedidos: "+ p1.getCuponsDescontoEntrega());
        System.out.println("Descontos irão dar: R$ "+ p1.getDescontoEntregaConcedido());

        p1.aplicarDescontoEntrega();
        System.out.println("Sua taxa de entrega com os cupons é: R$"+ p1.getTaxaEntrega());

        testeCupomDescontoPedido("DESC10", 0.10, p1);
        testeCupomDescontoPedido("DESC20", 0.20, p1);
        testeCupomDescontoPedido("DESC10", 0.10, p1);
    }
    public static void testeCupomDescontoPedido(String codigo, Double percentual,Pedido pedido){
        System.out.println("");
        CupomDescontoPedidoRepository repo = new CupomDescontoPedidoRepository();
        CalculadoraDescontoPedidoService calc2 = new CalculadoraDescontoPedidoService();
        System.out.println("teste para o desconto " + codigo);
        CupomDescontoPedido cupomNovo = new CupomDescontoPedido(codigo, percentual);
        calc2.calcularValorDesconto(pedido,new RegraCupomPercentual(cupomNovo,repo));
        System.out.println("O preço do seu pedido é: R$ " + pedido.getValorPedidoTotal());
        System.out.println("o codigo " + pedido.getCupomDescontoPedido().getCodigoDescontoPedido() + " te dará: R$ "+ pedido.getCupomDescontoPedido().getValorDescontado());
        pedido.aplicarDescontoPedido();
        System.out.println(pedido.toString());
    }
}
