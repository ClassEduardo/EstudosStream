package com.streams.Exemplos;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ExemploPipeline {
    public static void main(String[] args) {
        List<Produto> produtos = List.of(
                new Produto("TV", "Eletrônicos", 2000),
                new Produto("Banana", "Alimentos", 5),
                new Produto("Maçã", "Alimentos", 8),
                new Produto("Notebook", "Eletrônicos", 3500),
                new Produto("Arroz", "Alimentos", 20));

        Predicate<Produto> categoriaAlimentos = p -> p.categoria.equals("Alimentos");

        Function<Produto, Produto> alimentoComDesconto = p -> new Produto(p.nome, p.categoria, p.preco * 0.9);

        Collector<Produto, ?, Map<String, Double>> collector = Collectors.groupingBy(
                p -> p.categoria,
                Collectors.summingDouble(p -> p.preco));

        Map<String, Double> totalPorCategoria = produtos.stream()
                .filter(categoriaAlimentos)
                .map(alimentoComDesconto)
                .collect(collector);

        System.out.println(totalPorCategoria);

        totalPorCategoria.forEach((nome, preco) -> {
            System.out.println(nome + " " + preco);
        });
    }
}
