package com.cado.service.impl;
import com.cado.config.RetryAnnotation;
import com.cado.rest.RestRequest;
import com.cado.service.GenerateHTML;
import com.cado.service.GetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class GetResponseImpl implements GetResponse {

    @Autowired
    private RestRequest restRequest;

    @RetryAnnotation(maxAttempts = 10, backoff = 3000)
    public ResponseEntity<String> getResponse() throws Exception {
        return restRequest.getResponse();
    }
}
