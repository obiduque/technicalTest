package com.cado.controller;

import com.cado.service.GenerateHTML;
import com.cado.service.GetResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(path = "${controller.properties.base-path}", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Service
@Slf4j
public class EndPoints extends Thread{

    @Autowired
    GenerateHTML generateHTML;

    @Autowired
    GetResponse getResponse;

    @GetMapping(path = "/generateHTML", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "generateHTML", notes = "Mocking a HTML generator")
    public CompletableFuture<ResponseEntity<String>> generateHTML() throws InterruptedException, ExecutionException {
        CompletableFuture<ResponseEntity<String>> htmlSimple = simple();
        CompletableFuture<ResponseEntity<String>> htmlInput = input();
        CompletableFuture<ResponseEntity<String>> htmlButton = button();
        CompletableFuture.allOf(htmlSimple, htmlInput, htmlButton);
        return CompletableFuture.completedFuture(ResponseEntity.ok(htmlSimple.get().getBody() + htmlInput.get().getBody() + htmlButton.get().getBody()));
    }

    @GetMapping(path = "/getResponse", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "getResponse", notes = "Mocking a HTML generator")
    public ResponseEntity<String> getResponse() throws Exception {
        return getResponse.getResponse();
    }

    public CompletableFuture<ResponseEntity<String>> simple() throws InterruptedException {
        return generateHTML.getHTMLSimple().thenApply(ResponseEntity::ok);
    }

    public CompletableFuture<ResponseEntity<String>> input() throws InterruptedException {
        return generateHTML.getHtmlInput().thenApply(ResponseEntity::ok);
    }

    public CompletableFuture<ResponseEntity<String>> button() throws InterruptedException {
        return generateHTML.getHtmlButton().thenApply(ResponseEntity::ok);
    }

}
