package org.model;

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
    public String getTipo() { return tipo; }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public Double getFidelidade() {
        return fidelidade;
    }

    public void setFidelidade(Double fidelidade) {
        this.fidelidade = fidelidade;
    }
}
