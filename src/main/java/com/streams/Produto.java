package com.streams;

public class Produto {
    public String nome;
    public String categoria;
    public double preco;

    public Produto(String nome, double preco ){
        this.nome = nome;
        this.preco = preco;
    }

    public Produto(String nome, String categoria, double preco ){
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return nome + " - R$ " + preco;
    }   
}
