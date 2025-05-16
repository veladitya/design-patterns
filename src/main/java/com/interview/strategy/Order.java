package com.interview.strategy;

import com.interview.facade.Item;
import lombok.Data;

import java.util.List;

@Data
public class Order {

    List<Item> items;
    private String orderId;
}
