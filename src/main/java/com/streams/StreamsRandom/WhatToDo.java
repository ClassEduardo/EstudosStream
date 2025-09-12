package com.streams.StreamsRandom;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class WhatToDo {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7);
        Predicate<Integer> num = n -> n % 2 == 0;
        numeros.stream()
                .filter(num)
                .forEach(System.out::println);

        List<String> nomes = List.of("ana", "pedro", "maria");
        UnaryOperator<String> toUpperCase = s -> s.toUpperCase();
        nomes.stream()
                .map(toUpperCase)
                .forEach(System.out::println);

        List<Integer> unsortedNumbers = List.of(3, 7, 1, 9, 8, 5, 2);
        unsortedNumbers.stream()
                        .sorted()
                        .forEach(System.out::println);

        List<Integer> numsToReduce = Arrays.asList(1, 2, 3, 4);
        BinaryOperator<Integer> somaFunc = (ac, n) -> ac + n;
        Optional<Integer> soma = numsToReduce.stream().reduce(somaFunc);
        System.out.println(soma);


        List<String> nomesToCollect = List.of("Eduardo", "Felipe", "Juliana", "Guilherme");
        Function<String, Integer> length = s -> s.length();
        nomesToCollect.stream()
                        .map(length)
                        .collect(Collectors.toList())
                        .forEach(System.out::println);


        List<Integer> numsToOthers = List.of(1, 2, 3, 4, 5);
        System.out.println(numsToOthers.stream().count()); // 5
        System.out.println(numsToOthers.stream().findFirst()); // Optional[1]
        System.out.println(numsToOthers.stream().anyMatch(n -> n > 4)); // true
        

        Object obj;
        obj = 25;
        System.out.println(obj);
        obj = "OI";
        System.out.println(obj);
        obj = numsToOthers;
        System.out.println(obj);
        
    }
}
