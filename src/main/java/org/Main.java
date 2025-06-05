package org;


import org.sistemadescontopedido.CalculadoraDescontoPedidoService;
import org.model.Cliente;
import org.model.Item;
import org.model.Pedido;
import org.sistemadescontoentrega.CalculadoraDescontoEntregaService;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("","Ouro",10.0,"Rua S Robert Kennedy - 51", "Centro", "Alegre");
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



        CalculadoraDescontoPedidoService calc2 = new CalculadoraDescontoPedidoService();

        System.out.println("aplicar o desconto desc10");
        calc2.calcularValorDesconto(p1,"DESC10");
        System.out.println("O preço do seu pedido é: R$ " + p1.getValorPedidoTotal());
        System.out.println("o codigo " + p1.getCupomDescontoPedido().getCodigoDescontoPedido() + " te dará: R$ "+ p1.getCupomDescontoPedido().getValorDescontado());
        p1.aplicarDescontoPedido();
        System.out.println(p1.toString());

        System.out.println("trocar para o desconto desc20");
        calc2.calcularValorDesconto(p1,"DESC20");
        System.out.println("O preço do seu pedido é: R$ " + p1.getValorPedidoTotal());
        System.out.println("o codigo " + p1.getCupomDescontoPedido().getCodigoDescontoPedido() + " te dará: R$ "+ p1.getCupomDescontoPedido().getValorDescontado());
        p1.aplicarDescontoPedido();
        System.out.println(p1.toString());

        System.out.println("trocar para o desconto desc10");
        calc2.calcularValorDesconto(p1,"DESC10");
        System.out.println("O preço do seu pedido é: R$ " + p1.getValorPedidoTotal());
        System.out.println("o codigo " + p1.getCupomDescontoPedido().getCodigoDescontoPedido() + " te dará: R$ "+ p1.getCupomDescontoPedido().getValorDescontado());
        p1.aplicarDescontoPedido();
        System.out.println(p1.toString());
    }
}