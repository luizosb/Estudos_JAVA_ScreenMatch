package br.com.alura.modelos;

import br.com.alura.calculos.Classificavel;

public class Episodio implements Classificavel {

    private int numero;
    private Serie serie;
    private int totalDeVisualizacoes;

    @Override
    public int getClassificacao() {
        if (totalDeVisualizacoes > 100){
            return 4;
        } else {
            return 2;
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getTotalDeVisualizacoes() {
        return totalDeVisualizacoes;
    }

    public void setTotalDeVisualizacoes(int totalDeVisualizacoes) {
        this.totalDeVisualizacoes = totalDeVisualizacoes;
    }
}
