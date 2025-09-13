package com.streams.Exemplos;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Aluno {
    String nome;
    Double nota;
    
    public Aluno(String nome, Double nota) {
        this.nome = nome;
        this.nota = nota;
    }
} 

class Media {

	private double total;
	private int quantidade;
	
	public Media adicionar(double valor) {
		total += valor;
		quantidade++;
		return this;
	}
	
	public double getValor() {
		return total / quantidade;
	}
	
	public static Media combinar(Media m1, Media m2) {
		Media resultante = new Media();
		resultante.total = m1.total + m2.total;
		resultante.quantidade = m1.quantidade + m2.quantidade;
		return resultante;
	}
}

public class ExemploMedia {
    public static void main(String[] args) {
        Aluno a1 = new Aluno("Eduardo", 10.0);
        Aluno a2 = new Aluno("Juliana", 7.1);
        Aluno a3 = new Aluno("Guilherme", 6.1);
        Aluno a4 = new Aluno("Felipe", 8.1);
        
        List<Aluno> alunos = List.of(a1,a2,a3,a4);

        Predicate<Aluno> aprovado = a -> a.nota >= 7.0;

        Function<Aluno, Double> apenasNota = a -> a.nota;

        BiFunction<Media, Double, Media> calcularMedia = (media, nota) -> media.adicionar(nota);

        BinaryOperator<Media> combinarMedia = (m1, m2) -> Media.combinar(m1, m2);

        Media media = alunos.parallelStream()
                .filter(aprovado)
                .map(apenasNota)
                .reduce(new Media(), calcularMedia, combinarMedia);

        System.out.println("A média da turma é " + media);

        // List<Produto> produtos = List.of(
        //         new Produto("TV", 2000),
        //         new Produto("Notebook", 3500),
        //         new Produto("Mouse", 80));

        // double soma = produtos.stream()
        //         .mapToDouble(p -> p.preco)
        //         .sum();

        // double media = produtos.stream()
        //         .collect(Collectors.averagingDouble(p -> p.preco));
                
        // System.out.println("Soma: " + soma);
        // System.out.println("Media: " + media);
    }
}
