package com.example.entity;

import lombok.Data;

@Data
public class ProductVo {
    private Integer category;
    private Integer count;
    private String description;
    private Integer userId;
    private String userName;
}
