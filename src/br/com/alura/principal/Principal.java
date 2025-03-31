package br.com.alura.principal;

import br.com.alura.calculos.CalculadoraDeTempo;
import br.com.alura.calculos.FiltroRecomendacao;
import br.com.alura.modelos.Episodio;
import br.com.alura.modelos.Filme;
import br.com.alura.modelos.Serie;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Principal {
    public static void main(String[] args) {

        Filme filme1 = new Filme("The Matrix", 1999);
        filme1.setDuracaoEmMinutos(135);
        filme1.setIncluidoNoPlano(true);

        Filme filme2 = new Filme("John Wick", 2014);
        filme2.setDuracaoEmMinutos(101);
        filme2.setIncluidoNoPlano(true);

        Serie serie = new Serie("La Casa de Papel", 2017);
        serie.setIncluidoNoPlano(true);
        serie.setAtiva(true);
        serie.setTemporadas(5);
        serie.setEpisodiosPorTemporada(10);
        serie.setMinutosPorEpisodio(45);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(filme1);
        calculadora.inclui(filme2);
        calculadora.inclui(serie);

        System.out.println("Tempo total: " + calculadora.getTempoTotal());

        Episodio primeiro = new Episodio();
        primeiro.setNumero(1);
        primeiro.setSerie(serie);
        primeiro.setTotalDeVisualizacoes(300);

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtrar(filme1);
        filtro.filtrar(filme2);
        filtro.filtrar(primeiro);

        Filme filme3 = new Filme("Star Wars", 2016);
        filme3.setDuracaoEmMinutos(126);
        filme3.setIncluidoNoPlano(true);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filme1);
        listaDeFilmes.add(filme2);
        listaDeFilmes.add(filme3);
        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Nome do primeiro filme: " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
        System.out.println("toString: " + filme1.toString());



    }
}
