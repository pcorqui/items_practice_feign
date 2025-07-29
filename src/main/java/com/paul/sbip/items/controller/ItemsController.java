package com.paul.sbip.items.controller;

import com.paul.sbip.items.dtos.ApiResponse;
import com.paul.sbip.items.service.ItemsService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
public class ItemsController {

    private final ItemsService itemsService;

    @GetMapping("/items")
    public ApiResponse getItems(){
       return itemsService.getSomeProducts();
    }
}
