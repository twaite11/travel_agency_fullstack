package com.example.travel_agencyD288.services;

import com.example.travel_agencyD288.dao.CustomerRepository;
import com.example.travel_agencyD288.dao.DivisionRepository;
import com.example.travel_agencyD288.entities.Customer;
import com.example.travel_agencyD288.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public DataLoader(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (customerRepository.count() == 1 || customerRepository.count() == 0  ) {
            Division division = divisionRepository.findById(31L).orElseThrow(() -> new RuntimeException("Division not found"));

            Customer customer1 = new Customer(null, "Jane", "Doe", "123 Main St", "12345", "555-1234", null, null, division, null);
            Customer customer2 = new Customer(null, "Mike", "Smith", "456 Oak Ave", "54321", "555-5678", null, null, division, null);
            Customer customer3 = new Customer(null, "Lisa", "Johnson", "789 Pine Ln", "67890", "555-9012", null, null, division, null);
            Customer customer4 = new Customer(null, "David", "Williams", "101 Cedar Dr", "09876", "555-3456", null, null, division, null);
            Customer customer5 = new Customer(null, "Sarah", "Brown", "202 Birch Rd", "13579", "555-7890", null, null, division, null);

            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);
            customerRepository.save(customer4);
            customerRepository.save(customer5);
        }
    }
}