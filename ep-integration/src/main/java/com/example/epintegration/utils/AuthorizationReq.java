package com.example.epintegration.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.stream.Collectors;

public class AuthorizationReq {

    @Value("${authUrl}")
    private String authUrl;

    public String clientCredentialToken(String clientId, String clientSecret) throws IOException, InterruptedException {

        var values = new HashMap<String, String>() {{
            put("client_id", clientId);
            put("client_secret", clientSecret);
            put("grant_type", "client_credentials");
        }};
        String form = values.keySet().stream()
                .map(key -> key + "=" + URLEncoder.encode(values.get(key), StandardCharsets.UTF_8))
                .collect(Collectors.joining("&"));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(authUrl))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(form))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode responseJson = mapper.readTree(response.body());
        String token = responseJson.get("access_token").textValue();

        return token;
    }
}
