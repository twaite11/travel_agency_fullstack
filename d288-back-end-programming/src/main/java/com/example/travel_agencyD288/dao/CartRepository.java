package com.example.travel_agencyD288.dao;

import com.example.travel_agencyD288.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface CartRepository extends JpaRepository<Cart, Long> {
}