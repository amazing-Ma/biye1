package com.example.demo.eneity;

import lombok.Data;

@Data
public class Query {
    private int pageSize;

    private int total;

    private int currentPage;
}
