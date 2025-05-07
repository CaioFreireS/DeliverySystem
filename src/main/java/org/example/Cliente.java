package org.example;

public class Cliente {
    private String nome;
    private String tipo;
    private Double fidelidade;
    private String logradouro;
    private String bairro;
    private String cidade;

    public Cliente(String nome, String tipo, Double fidelidade, String logradouro, String bairro, String cidade){
        this.nome=nome;
        this.tipo=tipo;
        this.fidelidade=fidelidade;
        this.logradouro=logradouro;
        this.bairro=bairro;
        this.cidade=cidade;
    }

    public String getNome() {
        return nome;
    }
}
