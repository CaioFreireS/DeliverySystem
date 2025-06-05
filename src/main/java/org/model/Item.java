package org.model;

public class Item {
    private String nome;
    private Integer quantidade;
    private Double valorUnitario;
    private String tipo;

    public Item(String nome, Integer quantidade, Double valorUnitario, String tipo){
        if(nome==null || nome.isEmpty()){
            throw new RuntimeException("ERRO! Nome não pode ser vazio.");
        }
        this.nome=nome;
        if(quantidade==null || quantidade<=0){
            throw new RuntimeException("ERRO! Quantidade não pode ser vazia ou menor ou igual a 0.");
        }
        this.quantidade=quantidade;
        if(valorUnitario==null || valorUnitario<=0){
            throw new RuntimeException("ERRO! Valor unitario do item não pode ser vazio ou menor ou igual a 0.");
        }
        this.valorUnitario=valorUnitario;
        if(tipo==null || tipo.isEmpty()){
            throw new RuntimeException("ERRO! Tipo do item não pode ser vazio.");
        }
        this.tipo=tipo;
    }

    public Double getValorTotal(){
        return this.valorUnitario*this.quantidade;
    }

    public String getTipo(){
        return this.tipo;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", valorUnitario= R$ " + valorUnitario +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
