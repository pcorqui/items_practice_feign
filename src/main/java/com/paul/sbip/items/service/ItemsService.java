package com.paul.sbip.items.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paul.sbip.items.dtos.ApiResponse;
import com.paul.sbip.items.dtos.Product;
import com.paul.sbip.items.dtos.Schedule;
import com.paul.sbip.items.remote.ProductsProxy;
import lombok.Data;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class ItemsService {

    private final ProductsProxy productsProxy;
    private final ObjectMapper objectMapper;

    public ApiResponse getSomeProducts() {
        // This method would typically call the ProductsProxy to retrieve products;
        ApiResponse response = productsProxy.getSchedule().getBody();
        List<Schedule> schedule = objectMapper.convertValue(response.getData(), new TypeReference<>() {});

        try {
            // Assuming the response data is a JSON array of Schedule objects
            ApiResponse response1 = productsProxy.getProducts().getBody();
            List<Product> products = objectMapper.convertValue(response1.getData(), new TypeReference<>() {});
        } catch (Exception e) {
            e.printStackTrace();
            List<Product> products = List.of(); // Fallback to an empty list if there's an error// Handle the exception appropriately
        }

        ApiResponse taxResponse = productsProxy.getTaxes().getBody();



        response.setData(schedule);
        // Logic to retrieve items would go here
        return response;
    }
}
