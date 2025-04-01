package br.com.alura.exception;

public class ErroDeFormatacaoDeAnoException extends RuntimeException { //Se eu usar extends Exception dá erro, pois pede que use trycatch

    private String mensagem;

    public ErroDeFormatacaoDeAnoException(String mensagem) {
        this.mensagem = mensagem;
    }


    //Para utilizar a exceção que eu criar devo usar um override para mostrar a mensagem o qual criei.
    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
