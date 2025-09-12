package com.streams.Exemplos;

import java.util.List;
import java.util.stream.Collectors;

public class ExemploMedia {
    public static void main(String[] args) {
        List<Produto> produtos = List.of(
                new Produto("TV", 2000),
                new Produto("Notebook", 3500),
                new Produto("Mouse", 80));

        double soma = produtos.stream()
                .mapToDouble(p -> p.preco)
                .sum();

        double media = produtos.stream()
                .collect(Collectors.averagingDouble(p -> p.preco));
                
        System.out.println("Soma: " + soma);
        System.out.println("Media: " + media);
    }
}
