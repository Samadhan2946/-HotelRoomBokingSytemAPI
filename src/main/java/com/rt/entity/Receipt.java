package com.rt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "receipt")
public class Receipt {

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

	@Column(name="payment_mode")
	private String paymentMode; // CASH / ONLINe

}
