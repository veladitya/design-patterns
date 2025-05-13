package com.real.interview.facade;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFacadeImpl implements OrderFacade {

    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final ShippingService shippingService;
    private final NotificationService notificationService;

    public OrderFacadeImpl(InventoryService inventoryService, PaymentService paymentService, ShippingService shippingService, NotificationService notificationService) {
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
        this.shippingService = shippingService;
        this.notificationService = notificationService;
    }


    @Override
    public OrderReceipt placeOrder(Customer customer, List<Item> items) {
        if(!this.inventoryService.isInventoryEmpty()){
            if(this.paymentService.processPayment(items.stream().mapToDouble(Item::getAmount).sum())) {
                if(this.notificationService.sendNotification(this.shippingService.processShipmentRequest())){
                    System.out.println("Notification sent successfully");
                }
            }
        }
        return null;
    }
}
