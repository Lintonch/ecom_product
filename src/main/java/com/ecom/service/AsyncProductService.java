package com.ecom.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncProductService {
	
	@Async
    public void indexProductInSearchEngine(Long productId) {
        System.out.println("Started indexing product ID: " + productId);
        try {
            Thread.sleep(3000); // Simulate 3s indexing delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Finished indexing product ID: " + productId);
    }

}
