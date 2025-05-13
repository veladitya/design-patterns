package com.real.interview.facade;

import java.util.List;

public interface OrderFacade {
    public OrderReceipt placeOrder(Customer customer, List<Item> items);
}
