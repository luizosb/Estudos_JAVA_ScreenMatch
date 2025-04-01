package br.com.alura.principal;

import br.com.alura.exception.ErroDeFormatacaoDeAnoException;
import br.com.alura.modelos.Titulo;
import br.com.alura.modelos.TituloOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in); //Scanner para ler os dados a serem inseridos no console
        String busca = "";
        List<Titulo> listaTitulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)  //Utilizei o GSON para se conectar com o objeto para criar um arquivo.
                .setPrettyPrinting()                                       //Metodo utilizado para deixar o JSON mais legivel
                .create();

        while (!finalizarAplicacao(busca)) {

            busca = filme(leitura);

            if (finalizarAplicacao(busca)) break;

            String chaveAPI = "497dfcec";
            String endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=" + chaveAPI; //Link da API de busca

            try {
                HttpResponse<String> response = instanciarUmaAPI(endereco);

                String json = response.body();
                System.out.println(json); //JSON por inteiro chegando da API


                TituloOMDB meuTituloOMDB = gson.fromJson(json, TituloOMDB.class); //Convertendo os dados para meu objeto
                System.out.println(meuTituloOMDB); // Mostrando os dados convertidos

                Titulo meuTitulo = new Titulo(meuTituloOMDB);
                System.out.println(meuTitulo);

                listaTitulos.add(meuTitulo);
            } catch (NumberFormatException e) {
                System.out.println("Deu erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Erro na busca");
                System.out.println(e.getMessage());
            } catch (ErroDeFormatacaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Lista de titulos: ");
        System.out.println(listaTitulos);

        criacaoDeArquivoJson(gson, listaTitulos);
        System.out.println("Programa finalizado!");
    }

    private static void criacaoDeArquivoJson(Gson gson, List<Titulo> listaTitulos) throws IOException {
        FileWriter arquivo = new FileWriter("filmes.json"); //Criando um arquivo json, dei um nome
        arquivo.write(gson.toJson(listaTitulos));                   // Utilizei a biblioteca gson para transformar a lista de filmes em json com o toJson
        arquivo.close();                                            //Ao fechar um arquivo, não é possivel abri o mesmo mais uma vez
    }

    private static HttpResponse<String> instanciarUmaAPI(String endereco) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();   //Instanciar um cliente
        HttpRequest request = HttpRequest.newBuilder()    //Instanciar um request da API de uma busca
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client  //Instanciar uma resposta do request o qual utilizei acima
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }

    private static String filme(Scanner leitura) {
        String busca;
        System.out.println("Digite um filme para busca: ");
        busca = leitura.nextLine(); //Inserindo dados no console
        return busca;
    }

    private static boolean finalizarAplicacao(String busca) {
        if(busca.equalsIgnoreCase("sair")){
            return true;
        }
        return false;
    }
}
