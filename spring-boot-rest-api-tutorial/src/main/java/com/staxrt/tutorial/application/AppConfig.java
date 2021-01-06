package com.staxrt.tutorial.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.netty.http.client.HttpClient;

@Configuration
public class AppConfig {
 
    @Bean(name="webClient")
    public WebClient webClient(){
    	//System.out.println("aaaaaa");
	    HttpClient httpClient = HttpClient.create()
	            .tcpConfiguration(client ->
	                    client.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30000)
	                    .doOnConnected(conn -> conn
	                            .addHandlerLast(new ReadTimeoutHandler(30))
	                            .addHandlerLast(new WriteTimeoutHandler(30))));
	     
	    ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);     
	 
	    WebClient webC = WebClient.builder()
	            .clientConnector(connector)
	            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
	            .build();
	    System.out.println("client "+webC);
	    return webC;
	}
}