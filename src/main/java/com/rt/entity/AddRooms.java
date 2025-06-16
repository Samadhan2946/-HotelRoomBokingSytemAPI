package com.rt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rooms")
public class AddRooms {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "room_number")
	private int room_number;

	@Column(name = "room_types")
	private String room_types;

	@Column(name = "bed_count")
	private int bed_count;

	@Column(name = "price_per_night")
	private double price_per_night;

	@Column(name = "ac_type")
	private String ac_type;

	private String description;

	@Column(name = "room_image_path")
	private String room_image_path;

	@Column(name = "status")
	private String status;

}
