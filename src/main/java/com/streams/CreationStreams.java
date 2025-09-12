package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreationStreams {
    public static void main(String[] args) {
        // Collection to Stream
        List<String> collectionToStream = Arrays.asList("Eduardo", "Felipe", "Juliana", "Guilherme");
        Stream<String> stream = collectionToStream.stream(); 
        stream.forEach(System.out::println);

        // Array to Stream
        String[] arrayToStream = {"Eduardo", "Felipe", "Juliana", "Guilherme"};
        Arrays.stream(arrayToStream).forEach(System.out::println);

        // StremOf
        Stream.of("A", "B", "C").forEach(System.out::println);

        // StreamGenerate
        Stream.generate(() -> Math.random())
                .limit(5)
                .forEach(System.out::println);

        // Iterate sequência
        Stream.iterate(1, n -> n + 2)
                .limit(5)
                .forEach(System.out::println);

        
    }
}
