package br.com.alura.principal;

import br.com.alura.modelos.Filme;
import br.com.alura.modelos.Serie;
import br.com.alura.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalListas {

    public static void main(String[] args) {
        Filme filme1 = new Filme("The Matrix", 1999);
        Filme filme2 = new Filme("John Wick", 2014);
        Filme filme3 = new Filme("Star Wars", 2016);
        Serie serie = new Serie("Lost", 2010);

        ArrayList<Titulo> listaTitulos = new ArrayList<>();
        listaTitulos.add(filme1);
        filme1.avaliar(9);
        listaTitulos.add(filme2);
        filme2.avaliar(9);
        listaTitulos.add(filme3);
        filme3.avaliar(9);
        listaTitulos.add(serie);
        serie.avaliar(6);

        //For each basico
        for (Titulo item : listaTitulos){
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2){
                System.out.println("Classificação " + filme.getClassificacao());
            }
        }

//        Collections.sort(listaTitulos);
//        System.out.println(listaTitulos);
        listaTitulos.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(listaTitulos);

        /*
        For each com lambda
        listaTitulos.forEach(item -> System.out.println(item.getNome()));

        For Each mais simplificado > utiliza o toString
         listaTitulos.forEach((System.out::println));
         */

    }
}
