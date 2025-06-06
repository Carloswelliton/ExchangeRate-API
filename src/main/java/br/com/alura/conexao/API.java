package br.com.alura.conexao;

import br.com.alura.variable.Variable;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {
  String chave = "72becd5c6b504f7c2a717eb1";
  public ExchangePanel exchange(String origem, String destino, String valor){

    URI endereco = URI.create("https://v6.exchangerate-api.com/v6/"+chave+"/pair/"+origem+"/"+destino+"/"+valor);
    HttpClient client = HttpClient.newHttpClient();

    HttpRequest request = HttpRequest.newBuilder()
        .uri(endereco)
        .build();

    HttpResponse<String> response = null;

    try {
      response = client
          .send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println(response.body());


    Gson gson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create();

    if(response.statusCode() != 200){
      throw new RuntimeException("Erro na requisição da API" + response.body());
    }

    return gson.fromJson(response.body(), ExchangePanel.class);
  }

}
