package org.model;

public class Cliente {
    private String nome;
    private String tipo;
    private Double fidelidade;
    private String logradouro;
    private String bairro;
    private String cidade;

    public Cliente(String nome, String tipo, Double fidelidade, String logradouro, String bairro, String cidade){
        if(nome == null || nome.isEmpty()){
            throw new RuntimeException("ERRO! nome não pode ser vazio");
        }
        this.nome=nome;
        if(tipo == null || tipo.isEmpty()){
            tipo = "nenhum";
        }
        this.tipo=tipo;
        if(fidelidade == null){
            throw new RuntimeException("ERRO! fidelidade não pode ser vazia");
        }
        this.fidelidade=fidelidade;
        if(logradouro == null || logradouro.isEmpty()){
            throw new RuntimeException("ERRO! Logradouro não pode ser vazio");
        }
        this.logradouro=logradouro;
        if(bairro == null || bairro.isEmpty()){
            throw new RuntimeException("ERRO! Bairro não pode ser vazio");
        }
        this.bairro=bairro;
        if(cidade == null || cidade.isEmpty()){
            throw new RuntimeException("ERRO! Cidade não pode ser vazio");
        }
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
        if (fidelidade == null) {
            throw new RuntimeException("ERRO! Fidelidade não pode ser vazia");
        }
        this.fidelidade = fidelidade;
    }
}
