package com.cado.service;

import org.springframework.http.ResponseEntity;

import java.util.concurrent.CompletableFuture;

public interface GetResponse {
    ResponseEntity<String> getResponse() throws Exception;
}
