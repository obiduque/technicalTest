package com.cado.service;

import java.util.concurrent.CompletableFuture;

public interface GenerateHTML {
    CompletableFuture<String> getHTMLSimple() throws InterruptedException;
    CompletableFuture<String> getHtmlInput() throws InterruptedException;
    CompletableFuture<String> getHtmlButton() throws InterruptedException;
}
