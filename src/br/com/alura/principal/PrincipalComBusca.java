package br.com.alura.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um filme para busca: ");
        var busca = leitura.nextLine();

        String endereco = "http://www.omdbapi.com/?t=" + busca + "&apikey=497dfcec";

        HttpClient client = HttpClient.newHttpClient();   //Instanciar um cliente
        HttpRequest request = HttpRequest.newBuilder()      //Instanciar um request da API de uma busca
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client  //Instanciar uma resposta do request o qual utilizei acima
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
