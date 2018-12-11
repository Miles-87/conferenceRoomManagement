package com.management.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConferenceRoomDto {
    private String roomName;
    private String description;
    private Boolean projector;
    private String phoneNumber;
    private Integer numberOfSeats;
}
