package br.com.alura.modelos;

public class Titulo implements Comparable<Titulo> {

    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDeAvaliacoes;
    private int totalDeAvaliacao;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
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
}
