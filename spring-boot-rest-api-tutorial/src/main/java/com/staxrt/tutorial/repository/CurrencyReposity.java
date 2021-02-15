package com.staxrt.tutorial.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

@Repository
public class CurrencyReposity {

    @Autowired
    @Qualifier("webClient")
    private WebClient webClient;

    public CurrencyForeign get(String url){
        System.out.println(webClient);
        CurrencyForeign results = webClient
                .get()
                .uri(URI.create(url))
                .retrieve()
                .onStatus(httpStatus -> httpStatus.value() != 200,response ->response.bodyToMono(String.class).map(s -> new Exception(s)))
                .bodyToMono(CurrencyForeign.class)
                .block();

        return results;
    }

}
