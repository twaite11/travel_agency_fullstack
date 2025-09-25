package com.example.travel_agencyD288.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 255)
    @Column(name = "customer_first_name", nullable = false)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 255)
    @Column(name = "customer_last_name", nullable = false)
    private String lastName;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 255)
    @Column(name = "address", nullable = false)
    private String address;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 255)
    @Column(name = "postal_code", nullable = false)
    private String postal_code;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 255)
    @Column(name = "phone", nullable = false)
    private String phone;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false)
    private Division division;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Cart> carts;
}