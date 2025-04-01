package br.com.alura.modelos;

import br.com.alura.exception.ErroDeFormatacaoDeAnoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {

    @SerializedName("Nome")
    private String nome;
    @SerializedName("AnoDeLancamento")
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDeAvaliacoes;
    private int totalDeAvaliacao;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOMDB meuTituloOMDB) {
        this.nome = meuTituloOMDB.title();

        if(meuTituloOMDB.year().length() > 4){ //Criação da mensagem de erro dentro do construtor. Utilize throw new
              throw new ErroDeFormatacaoDeAnoException("O tamanho do ano tem mais de 4 caracteres");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOMDB.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOMDB.runtime().substring(0,2));
    }

    public void exibirFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Nome do filme: " + anoDeLancamento);
    }

    public void avaliar(double nota){
        somaDeAvaliacoes += nota;
        totalDeAvaliacao++;
    }

    public double mediaDasAvaliacoes(){
        return somaDeAvaliacoes / totalDeAvaliacao;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalDeAvaliacao() {
        return totalDeAvaliacao;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    @Override
    public int compareTo(Titulo t) {
        return this.getNome().compareTo(t.getNome());
    }

    @Override
    public String toString() {
        return
                "(nome= " + nome +
                ", ano de lançamento= " + anoDeLancamento +
                ", duração em minutos= " + duracaoEmMinutos + ")";
    }
}
