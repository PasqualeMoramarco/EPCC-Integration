package com.example.epintegration.utils;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class HttpReq {
    private static final Logger logger = LoggerFactory.getLogger(HttpReq.class);

    public <T> HttpResponse<String> httpPost(T obj, String url, String token) throws IOException, InterruptedException {

        logger.info("Http post request: " + url);

        Gson gson = new Gson();
        String requestBody = gson.toJson(obj);

        HttpClient client = HttpClient.newHttpClient();
        java.net.http.HttpRequest request = java.net.http.HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + token)
                .header("content-type", "application/json")
                .POST(java.net.http.HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        logger.info(response.body());

        return response;
    }

    public <T> HttpResponse<String> httpPut(T obj, String url, String token) throws IOException, InterruptedException {

        logger.info("Http put request: " + url);

        Gson gson = new Gson();
        String requestBody = gson.toJson(obj);

        HttpClient client = HttpClient.newHttpClient();
        java.net.http.HttpRequest request = java.net.http.HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + token)
                .header("content-type", "application/json")
                .PUT(java.net.http.HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        logger.info(response.body());

        return response;
    }
}
