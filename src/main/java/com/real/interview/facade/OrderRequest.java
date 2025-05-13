package com.real.interview.facade;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private Customer customer;
    private List<Item> items;
}
