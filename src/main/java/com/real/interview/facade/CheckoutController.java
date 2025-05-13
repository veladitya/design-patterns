package com.real.interview.facade;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckoutController {
  private final OrderFacade orderFacade;
  
  public CheckoutController(OrderFacade orderFacade) {
    this.orderFacade = orderFacade;
  }

  @PostMapping("/checkout")
  public OrderReceipt checkout(@RequestBody OrderRequest req) {
    return orderFacade.placeOrder(req.getCustomer(), req.getItems());
  }
}
