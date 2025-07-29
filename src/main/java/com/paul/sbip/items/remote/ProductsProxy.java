package com.paul.sbip.items.remote;

import com.paul.sbip.items.dtos.ApiResponse;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "products-service", url = "${products.service.url}")
public interface ProductsProxy {
    // Define methods to interact with the remote service here

    @GetMapping("/getSchedule")
    ResponseEntity<ApiResponse> getSchedule();

    @GetMapping("/getTaxes")
    ResponseEntity<ApiResponse> getTaxes();

    @GetMapping("/getProducts")
    ResponseEntity<ApiResponse> getProducts();
}
