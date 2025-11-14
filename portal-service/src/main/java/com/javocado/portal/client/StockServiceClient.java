// portal-service/src/main/java/com/javocado/portal/service/StockServiceClient.java
package com.javocado.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockServiceClient {
    @Autowired
    private RestTemplate restTemplate;

    public String fetchHelloFromStockService() {
        String url = "http://localhost:8081/api/ytd-returns";
        return restTemplate.getForObject(url, String.class);
    }
}