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
public class AddRoomsRequestDto {

	

	
	@NotNull
	
	private Long id;

	@NotNull
	
	private int room_number;

	@NotNull
	
	private String room_types;

	@NotNull
	
	private int bed_count;

	@NotNull
	@Size(max = 40)
	private int price_per_night;

	@NotNull
	
	private String ac_type;

	@NotNull
	
	private String description;

	@NotNull
	
	private String room_image_path;

	@NotNull
	
	private String status;

}
