package org;


import org.AuxClass.CalculadoraValorItensPedido;
import org.SistemaDescontoPedido.CalculadoraDescontoPedidoService;
import org.model.Cliente;
import org.model.Item;
import org.model.Pedido;
import org.SistemaDescontoEntrega.CalculadoraDescontoEntregaService;

import java.sql.SQLOutput;
import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
        CalculadoraValorItensPedido calc0 = new CalculadoraValorItensPedido();
        calc0.calcularValorPedido(p1);

        CalculadoraDescontoEntregaService calc1 = new CalculadoraDescontoEntregaService();
        calc1.setInterruptor(true);

        calc1.calcularDesconto(p1);
        System.out.println("Sua taxa de entrega é: R$ "+ p1.getTaxaEntrega());
        System.out.println("Descontos Concedidos: "+ p1.getCuponsDescontoEntrega());
        System.out.println("Descontos irão dar: - R$ "+ p1.getDescontoConcedido());

        p1.aplicarDescontoEntrega();
        calc0.calcularValorPedido(p1);
        System.out.println("Sua taxa de entrega com os cupons é: R$"+ p1.getTaxaEntrega());

        CalculadoraDescontoPedidoService calc2 = new CalculadoraDescontoPedidoService();
        calc2.calcularValorDesconto(p1,"DESC10");
        System.out.println("O preço do seu pedido é: R$ " + p1.getValorPedido());
        System.out.println("Apos o desconto ficará: R$ "+ (p1.getValorPedido() - p1.getCupomDescontoPedido().getValorDescontado()));
        p1.aplicarDescontoPedido();
        calc0.calcularValorPedido(p1);
        System.out.println(p1.toString());

        System.out.println(p1.toString());
    }
}