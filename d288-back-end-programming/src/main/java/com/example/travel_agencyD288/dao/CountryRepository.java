package com.example.travel_agencyD288.dao;

import com.example.travel_agencyD288.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface CountryRepository extends JpaRepository<Country, Long> {
}