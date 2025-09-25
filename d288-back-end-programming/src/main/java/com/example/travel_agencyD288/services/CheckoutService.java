package com.example.travel_agencyD288.services;

import com.example.travel_agencyD288.services.dto.PurchaseData;
import com.example.travel_agencyD288.services.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(PurchaseData purchaseData);
}