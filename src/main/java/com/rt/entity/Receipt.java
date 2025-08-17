package com.rt.entity;


import java.time.LocalDate;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "receipt")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private AddRooms room;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @Column(name = "booking_date")
    private LocalDate bookingDate;

    @Column(name = "checkout_date")
    private LocalDate checkoutDate;

    @Column(name = "days_stayed")
    private Long daysStayed;

    @Column(name = "price_per_day")
    private Double pricePerDay;

    @Column(name = "total_amount")
    private Double totalAmount;
}
