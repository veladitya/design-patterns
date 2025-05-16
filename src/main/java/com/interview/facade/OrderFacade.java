package com.interview.facade;

import java.util.List;

public interface OrderFacade {
    OrderReceipt placeOrder(Customer customer, List<Item> items);
}
