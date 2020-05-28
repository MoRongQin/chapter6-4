package com.forezp.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TokenInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {

        System.err.println("进入RestTemplate拦截器");
        HttpHeaders headers = request.getHeaders();
        headers.add("Authorization", "Basic c2FiZXI6c2FiZXJfc2VjcmV0");
        headers.add("Blade-Auth", "bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhbGwiXSwiZXhwIjoxNTg5MDE0MTIxLCJqdGkiOiJhN2M1MzZhMi1lZTBkLTRlNjgtOTNlMi1mMjg2MWZmZjM1MTAiLCJjbGllbnRfaWQiOiJzYWJlciJ9.1Bp_MrAHbj0Fq-q5MyPFaw2oMnWfb_UP0CSYW18L3qM");
        return execution.execute(request, body);
    }

}



