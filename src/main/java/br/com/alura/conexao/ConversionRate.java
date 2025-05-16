package br.com.alura.conexao;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversionRate {
  String chave = "72becd5c6b504f7c2a717eb1";
  public ConversionTable conversion(String origem){

    URI endereco = URI.create("https://v6.exchangerate-api.com/v6/"+chave+"latest/"+origem);
    HttpClient client = HttpClient.newHttpClient();

    HttpRequest request = HttpRequest.newBuilder()
        .uri(endereco)
        .GET()
        .build();

    HttpResponse<String> response = null;

    try {
      response = client
          .send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
    }

    //System.out.println(response.body());


    Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .create();

    return gson.fromJson(response.body(), ConversionTable.class);
  }
}
