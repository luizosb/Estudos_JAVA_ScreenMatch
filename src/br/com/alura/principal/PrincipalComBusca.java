package br.com.alura.principal;

import br.com.alura.exception.ErroDeFormatacaoDeAnoException;
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

        Scanner leitura = new Scanner(System.in); //Scanner para ler os dados a serem inseridos no console
        System.out.println("Digite um filme para busca: ");
        var busca = leitura.nextLine(); //Inserindo dados no console

        String chaveAPI = "497dfcec";
        String endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey="+chaveAPI; //Link da API de busca

        try{
            HttpClient client = HttpClient.newHttpClient();   //Instanciar um cliente
            HttpRequest request = HttpRequest.newBuilder()    //Instanciar um request da API de uma busca
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client  //Instanciar uma resposta do request o qual utilizei acima
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json); //JSON por inteiro chegando da API

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create(); //Utilizando records para
                                                                                                            // não se preocupar caso a variavel venha com letra
                                                                                                            // maiscula
            TituloOMDB meuTituloOMDB = gson.fromJson(json, TituloOMDB.class); //Convertendo os dados para meu objeto
            System.out.println(meuTituloOMDB); // Mostrando os dados convertidos

            Titulo meuTitulo = new Titulo(meuTituloOMDB);
            System.out.println(meuTitulo);
        }catch (NumberFormatException e){
            System.out.println("Deu erro:");
            System.out.println(e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("Erro na busca");
            System.out.println(e.getMessage());
        }catch (ErroDeFormatacaoDeAnoException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Programa finalizado!");
    }
}
