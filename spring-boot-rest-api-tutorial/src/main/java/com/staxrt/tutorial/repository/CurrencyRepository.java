package com.staxrt.tutorial.repository;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
 

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Repository
public class CurrencyRepository  {
	
	@Autowired
	@Qualifier("webClient")
	private WebClient webClient;
	
	
	public String get(String url) {
		 System.out.println(webClient);
		//https://exchangeratesapi.io/
		String relults = webClient
				  .get()
				  .uri(URI.create(url))
				  .retrieve()
				  .onStatus(httpStatus -> httpStatus.value() != 200, 
					        response -> response.bodyToMono(String.class)
					        .map(s -> new Exception(s)))
				  .bodyToMono(String.class)
				  .block();
 
		return relults;
	}

	
	
	 
	
	 
//	
//	public Result post(String url, String token, Object body) {
//		// 			headersBet.put("TabcorpAuth", token);
//
//		RequestBodySpec requestBodySpec = getWebClient()
//				  .post()
//				  .uri(URI.create(url))
//				  .header("Content-Type", "application/json")
//				  .header("User-Agent",
//							"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
//		
//		if(token != null) {
//			requestBodySpec = requestBodySpec.header("TabcorpAuth", token);
//		}		 
//				  
//				  
//				  
//		Mono<ClientResponse> relults = requestBodySpec
//				.body(BodyInserters.fromValue(body))
//				.exchange();
////				.onStatus(httpStatus -> !httpStatus.is2xxSuccessful(), 
////		        		response -> response.bodyToMono(ClientResponse.class).map(s -> new Exception(s.toString())))
////				.bodyToMono(ClientResponse.class)
////				.block();
//				   
//		ClientResponse clientResponse = relults.block();
//		return new Result(clientResponse.statusCode().value() + "", clientResponse.bodyToMono(String.class).block());		 
//	}

}