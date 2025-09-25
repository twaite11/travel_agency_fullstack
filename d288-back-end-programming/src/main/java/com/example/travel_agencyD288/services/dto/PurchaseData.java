package com.example.travel_agencyD288.services.dto;
import com.example.travel_agencyD288.entities.Cart;
import com.example.travel_agencyD288.entities.CartItem;
import com.example.travel_agencyD288.entities.Customer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.Set;
@Data
public class PurchaseData {
    @NotNull(message = "Customer information is required") @Valid
    private Customer customer;
    @NotNull(message = "Cart information is required") @Valid
    private Cart cart;
    @NotNull(message = "At least one cart item is required") @Valid
    private Set<CartItem> cartItems;
}