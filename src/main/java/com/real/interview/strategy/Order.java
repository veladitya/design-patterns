package com.real.interview.strategy;

import com.real.interview.facade.Item;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
public class Order {

    private String orderId;
    List<Item> items;
}
