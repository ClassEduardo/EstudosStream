package com.streams.Exemplos;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;

public class ExemploGrouping {
    public static void main(String[] args) {
        List<Produto> produtos = List.of(
            new Produto("TV", "Eletrônicos", 2000),
            new Produto("Notebook", "Eletrônicos", 3500),
            new Produto("Banana", "Alimentos", 5),
            new Produto("Maçã", "Alimentos", 8),
            new Produto("Camiseta", "Vestuário", 50),
            new Produto("Bermuda", "Vestuário", 25)
        );

        Function<Produto, String> grupingByCategoria = p -> p.categoria;
        Map<String, List<Produto>> agrupados = produtos.stream()
                .collect(Collectors.groupingBy(grupingByCategoria));

        agrupados.forEach((categoria, lista) -> {
            System.out.println(categoria + ": " + lista);
        });
    }
}
