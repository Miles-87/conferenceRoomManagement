package com.management.service;

import com.management.exceptions.MyException;
import com.management.model.ConferenceRoom;
import com.management.model.dto.ConferenceRoomDto;
import com.management.repository.ConferenceRoomRepository;
import com.management.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ConferecneRoomService {
    private ConferenceRoomRepository conferenceRoomRepository;
    private ModelMapper modelMapper;
    private UserRepository userRepository;

    public ConferecneRoomService(
            ConferenceRoomRepository conferenceRoomRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.conferenceRoomRepository = conferenceRoomRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    public List<ConferenceRoomDto> getAllRooms() {
        return conferenceRoomRepository
                .findAll()
                .stream()
                .map(modelMapper::fromConferenceRoomToConferenceRoomDto)
                .collect(Collectors.toList());
    }

    public ConferenceRoomDto addConferenceRoom(ConferenceRoomDto conferenceRoomDto) {

        if (conferenceRoomDto == null) {
            log.error("CONFERENCE ROOM OBJECT IS NULL");
            throw new MyException("CONFERENCE ROOM OBJECT IS NULL");
        }

        if (conferenceRoomRepository.findByRoomName(conferenceRoomDto.getRoomName()).isPresent()) {
            log.error("CONFERENCE ROOM NAME ALREADY EXISTS");
            throw new MyException("CONFERENCE ROOM NAME ALREADY EXISTS");
        }

        ConferenceRoom conferenceRoom = conferenceRoomRepository
                .save(modelMapper.fromConferenceRoomDtoToConferenceRoom(conferenceRoomDto));
        return modelMapper.fromConferenceRoomToConferenceRoomDto(conferenceRoom);
    }

    public ConferenceRoomDto updateConferenceRoom(ConferenceRoomDto conferenceRoomDto) {

        if (conferenceRoomDto == null) {
            log.error("CONFERENCE ROOM OBJECT IS NULL");
            throw new MyException("CONFERENCE ROOM OBJECT IS NULL");
        }

        ConferenceRoom conferenceRoom = conferenceRoomRepository
                .findByRoomName(conferenceRoomDto.getRoomName())
                .orElseThrow(() -> new MyException("CONFERENCE ROOM NAME IS NOT CORRECT"));

        conferenceRoom.setDescription(conferenceRoomDto.getDescription() == null ? conferenceRoom.getDescription() : conferenceRoomDto.getDescription());
        conferenceRoom.setNumberOfSeats(conferenceRoomDto.getNumberOfSeats() == null ? conferenceRoom.getNumberOfSeats() : conferenceRoomDto.getNumberOfSeats());
        conferenceRoom.setPhoneNumber(conferenceRoomDto.getPhoneNumber() == null ? conferenceRoom.getPhoneNumber() : conferenceRoomDto.getPhoneNumber());
        conferenceRoomRepository.save(conferenceRoom);
        return modelMapper.fromConferenceRoomToConferenceRoomDto(conferenceRoom);
    }

    public ConferenceRoomDto deleteRoom(ConferenceRoomDto conferenceRoomDto) {
        if (conferenceRoomDto == null) {
            log.error("CONFERENCE ROOM OBJECT IS NULL");
            throw new MyException("CONFERENCE ROOM OBJECT IS NULL");
        }

        ConferenceRoom conferenceRoom = conferenceRoomRepository.findByRoomName(conferenceRoomDto.getRoomName())
                .orElseThrow(() -> new MyException("INCORRECT ROOM NAME"));
        conferenceRoomRepository.delete(conferenceRoom);
        return modelMapper.fromConferenceRoomToConferenceRoomDto(conferenceRoom);
    }

}
