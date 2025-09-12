package com.streams.Exemplos;

import java.util.Comparator;
import java.util.List;

import com.streams.Produto;

public class ExemploMaxMin {
    public static void main(String[] args) {
        List<Produto> produtos = List.of(
            new Produto("Monitor", 2000),
            new Produto("Notebook", 3500),
            new Produto("Mouse", 80),
            new Produto("Teclado", 150)
        );
    
        produtos.stream()
                .max(Comparator.comparingDouble(p -> p.preco))
                .ifPresent(p -> System.out.println("+ caro "+p.preco));
        produtos.stream()
                .min(Comparator.comparingDouble(p -> p.preco))
                .ifPresent(p -> System.out.println("- caro "+p.preco));
    }
}
