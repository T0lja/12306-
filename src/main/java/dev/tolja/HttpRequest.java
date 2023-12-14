package dev.tolja;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class HttpRequest {
    public static String httpRequest(String uri) throws URISyntaxException, IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newBuilder().build();
        java.net.http.HttpRequest httpRequest = java.net.http.HttpRequest.newBuilder()
                .uri(new URI(uri))
                .headers("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
                .headers("Cookie", "JSESSIONID=08966F61F2AB9941D67997990EAFB2F4;"
                )
                .headers("Content-Type", "application/json;charset=UTF-8")
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
