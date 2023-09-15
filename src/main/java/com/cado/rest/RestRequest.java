package com.cado.rest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.HttpRetryException;

@Slf4j
@Service
public class RestRequest {

    public ResponseEntity<String> getResponse() throws Exception {
        double ok=Math.floor((Math.random() * 3000) + 1);
        if(ok%9==0){
            RestTemplate request = Mockito.mock(RestTemplate.class);
            Mockito.when(request.exchange(Mockito.anyString(), Mockito.any(), Mockito.any(), Mockito.eq(String.class)))
                    .thenReturn(new ResponseEntity<>("Too many requests", HttpStatus.TOO_MANY_REQUESTS));
            var response =request.exchange("",null,null,String.class);
            return response;
        }
        else{
            return new ResponseEntity<>("OK", HttpStatus.OK);
        }
    }
}
