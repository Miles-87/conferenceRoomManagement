package com.management.service;

import com.management.model.ConferenceRoom;
import com.management.model.User;
import com.management.model.dto.ConferenceRoomDto;
import com.management.model.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class ModelMapper {
    public ConferenceRoomDto fromConferenceRoomToConferenceRoomDto(ConferenceRoom conferenceRoom) {
        return conferenceRoom == null ? null : ConferenceRoomDto.builder()
                .roomName(conferenceRoom.getRoomName())
                .description(conferenceRoom.getDescription())
                .projector(conferenceRoom.getProjector())
                .phoneNumber(conferenceRoom.getPhoneNumber())
                .numberOfSeats(conferenceRoom.getNumberOfSeats())
                .build();

    }

    public ConferenceRoom fromConferenceRoomDtoToConferenceRoom(ConferenceRoomDto conferenceRoomDto) {
        return conferenceRoomDto == null ? null : ConferenceRoom.builder()
                .roomName(conferenceRoomDto.getRoomName())
                .description(conferenceRoomDto.getDescription())
                .projector(conferenceRoomDto.getProjector())
                .phoneNumber(conferenceRoomDto.getPhoneNumber())
                .numberOfSeats(conferenceRoomDto.getNumberOfSeats())
                .build();
    }

    public UserDto fromUsertoUserDto(User user) {
        return user == null ? null : UserDto.builder()
                .userName(user.getUsername())
                .surname(user.getSurname())
                .login(user.getLogin())
                .password(user.getPassword())
                .build();
    }

    public User fromUserDtoToUser(UserDto userDto) {
        return userDto == null ? null : User.builder()
                .username(userDto.getUserName())
                .surname(userDto.getSurname())
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .build();
    }
}
