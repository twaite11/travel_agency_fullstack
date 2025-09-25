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
@Table(name="excursions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    private Long id;

    @Column(name = "excursion_title", nullable = false)
    private String excursion_title;

    @Column(name = "excursion_price", nullable = false)
    private BigDecimal excursion_price;

    @Column(name = "image_url", nullable = false)
    private String image_URL;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "vacation_id", nullable = false)
    private Vacation vacation;

    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems;
}