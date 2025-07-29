package com.paul.sbip.items.dtos;

import lombok.Data;

@Data
public class Meta {

    private String transactionId;
    private String time;
    private String status;
    private Integer statusCode;
    private String message;

}
