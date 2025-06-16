package com.rt.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddRoomsResponseDto {
	
	private Long id;

	private int room_number;

	private String room_types;

	private int bed_count;

	private double price_per_night;

	private String ac_type;

	private String description;

	private String room_image_path;

	private String status;

}
