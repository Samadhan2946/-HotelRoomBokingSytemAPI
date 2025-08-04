package com.rt.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomBookingResponseDto {
	private int id;
    private Long roomId;
    private String customerName;
    private LocalDate bookingDate;

}
