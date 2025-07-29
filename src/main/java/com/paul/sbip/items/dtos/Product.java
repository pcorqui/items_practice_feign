package com.paul.sbip.items.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    private String id;
    private String name;
    private String description;
    private double price; // e.g., 19.99
    private int tax; // e.g., 15 for 15%
}
