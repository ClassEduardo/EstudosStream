package com.streams.Exemplos;

import java.util.Comparator;
import java.util.List;

public class ExemploTop3 {
    public static void main(String[] args) {
        List<Produto> produtos = List.of(
                new Produto("TV", 2000),
                new Produto("Notebook", 3500),
                new Produto("Mouse", 80),
                new Produto("Celular", 2500),
                new Produto("Tablet", 1500));
    
        produtos.stream()
                .sorted(Comparator.comparingDouble(p -> p.preco))
                .limit(3)
                .forEach(System.out::println);
    }
}
