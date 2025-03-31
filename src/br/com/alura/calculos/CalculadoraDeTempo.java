package br.com.alura.calculos;

import br.com.alura.modelos.Titulo;

public class CalculadoraDeTempo {

    private int tempoTotal;

    public void inclui(Titulo t){
        tempoTotal += t.getDuracaoEmMinutos();
    }

    public int getTempoTotal() {
        return tempoTotal;
    }
}
