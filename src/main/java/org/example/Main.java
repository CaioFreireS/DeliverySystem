package org.example;


import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("caio","Pessoa Fisica",10.0,"Rua S Robert Kennedy - 51", "Guararema", "Alegre");
        Cliente c2 = new Cliente("Bernardo","Pessoa Fisica",10.0,"Rua S Robert Kennedy - 53", "Guararema", "Alegre");

        Item i1 = new Item("Hamburgue",10, 13.0, "Lanche");
        Item i2 = new Item("Coca-Cola Lata",2,5.0,"Bebida");
        Item i3 = new Item("Batata 500g", 1, 1.0, "Porção");

        ArrayList<Item> itens1 = new ArrayList<Item>();
        ArrayList<Item> itens2 = new ArrayList<Item>();

        CupomDescontoEntrega d1 = new CupomDescontoEntrega("Entrega", 100.0);
        CupomDescontoEntrega d2 = new CupomDescontoEntrega("Pedido", 15.0);

        ArrayList<CupomDescontoEntrega> cupons1 = new ArrayList<CupomDescontoEntrega>();
        ArrayList<CupomDescontoEntrega> cupons2 = new ArrayList<CupomDescontoEntrega>();

        Pedido p1 = new Pedido(c1,itens1,cupons1);
        Pedido p2 = new Pedido(c2,itens2,cupons2);

        p1.addItem(i1);
        p1.addItem(i2);
        p1.addItem(i3);

        p2.addItem(i1);

        System.out.println(p1.toString());
    }
}