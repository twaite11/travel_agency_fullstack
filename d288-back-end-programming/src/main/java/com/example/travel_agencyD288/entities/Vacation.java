package com.example.travel_agencyD288.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="vacations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long id;

    @Column(name = "vacation_title", nullable = false)
    private String vacation_title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "travel_fare_price", nullable = false)
    private BigDecimal travel_price;

    @Column(name = "image_url", nullable = false)
    private String image_URL;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date lastUpdate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacation")
    private Set<Excursion> excursions;
}