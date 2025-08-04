package com.rt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomBookingRequestDto {
	 private Long id; //roomId
	    private int customerId;
	    private String bookingDate;

}
