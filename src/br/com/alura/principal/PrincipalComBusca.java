package br.com.alura.principal;

import br.com.alura.modelos.Titulo;
import br.com.alura.modelos.TituloOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        HttpRequest request = HttpRequest.newBuilder()    //Instanciar um request da API de uma busca
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client  //Instanciar uma resposta do request o qual utilizei acima
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

        TituloOMDB meuTituloOMDB = gson.fromJson(json, TituloOMDB.class);
        System.out.println(meuTituloOMDB);

        Titulo meuTitulo = new Titulo(meuTituloOMDB);
        System.out.println(meuTitulo);
    }
}
