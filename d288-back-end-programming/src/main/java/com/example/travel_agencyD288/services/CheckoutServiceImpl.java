package com.example.travel_agencyD288.services;

import com.example.travel_agencyD288.dao.CartRepository;
import com.example.travel_agencyD288.entities.Cart;
import com.example.travel_agencyD288.entities.CartItem;
import com.example.travel_agencyD288.services.dto.PurchaseData;
import com.example.travel_agencyD288.services.dto.PurchaseResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.Set;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CartRepository cartRepository;

    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(PurchaseData purchaseData) {
        // Retrieve the cart from the purchase data
        Cart cart = purchaseData.getCart();

        // Check if the cart has a default ID from the front end and set it to null
        if (cart.getId() == 0) {
            cart.setId(null);
        }

        // Generate a unique order tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        // Populate the cart with its cartItems
        Set<CartItem> cartItems = purchaseData.getCartItems();
        if (cartItems != null && !cartItems.isEmpty()) {
            cartItems.forEach(item -> cart.add(item));
        }

        // Set the cart to the customer
        cart.setCustomer(purchaseData.getCustomer());

        // Save the cart and its items to the database
        cartRepository.save(cart);

        // Return a response with the order tracking number
        PurchaseResponse purchaseResponse = new PurchaseResponse();
        purchaseResponse.setOrderTrackingNumber(orderTrackingNumber);
        return purchaseResponse;
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}