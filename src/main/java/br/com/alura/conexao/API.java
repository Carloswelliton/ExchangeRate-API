package br.com.alura.conexao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {
  HttpClient client = HttpClient.newHttpClient();

  HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create("https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP/AMOUNT"))
      .build();
  {
    try {
      HttpResponse<String> response = client
          .send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

}
