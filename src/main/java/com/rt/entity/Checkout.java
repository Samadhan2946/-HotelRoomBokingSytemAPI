package com.rt.entity;

import java.time.LocalDate;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "checkout")
public class Checkout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="room_type")
	private String roomType;
	
	@Column(name="booking_date")
	private String bookingDate;
	
	@Column(name="checkout_date")
	private String checkoutDate;
	
	@Column(name="days_stayed")
	private int daysStayed;
	
	@Column(name="price_per_day")
	private double pricePerDay;
	
	@Column(name="total_amount")
	private double totalAmount;

}