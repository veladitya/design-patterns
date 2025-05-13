package com.real.interview.facade;

import lombok.Data;

@Data
public class OrderReceipt {
    private String orderId;
    private String customerId;
    private String shipmentId;
}
