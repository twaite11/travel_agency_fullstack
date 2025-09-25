package com.example.travel_agencyD288.controllers;

import com.example.travel_agencyD288.services.CheckoutService;
import com.example.travel_agencyD288.services.dto.PurchaseData;
import com.example.travel_agencyD288.services.dto.PurchaseResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
@CrossOrigin("http://localhost:4200") // Add this annotation
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@Valid @RequestBody PurchaseData purchaseData) {
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchaseData);
        return purchaseResponse;
    }
}