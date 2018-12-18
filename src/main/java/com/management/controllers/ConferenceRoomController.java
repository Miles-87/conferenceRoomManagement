package com.management.controllers;

import com.management.model.dto.AddUserToConferenceRoomDto;
import com.management.model.dto.ConferenceRoomDto;
import com.management.model.dto.LoginDataDto;
import com.management.service.ConferecneRoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class ConferenceRoomController {

    private ConferecneRoomService conferecneRoomService;

    public ConferenceRoomController(ConferecneRoomService conferecneRoomService) {
        this.conferecneRoomService = conferecneRoomService;
    }

    @GetMapping
    public ResponseEntity<List<ConferenceRoomDto>> getAllRooms() {
        return ResponseEntity.ok(conferecneRoomService.getAllRooms());
    }

    @PostMapping
    public ResponseEntity<ConferenceRoomDto> createConferenceRoom(@RequestBody ConferenceRoomDto conferenceRoomDto) {
        ConferenceRoomDto conferenceRoomDto1 = conferecneRoomService.addConferenceRoom(conferenceRoomDto);
        return ResponseEntity.ok(conferenceRoomDto1);
    }

    @PutMapping
    public ResponseEntity<ConferenceRoomDto> updateConferenceRoom(@RequestBody ConferenceRoomDto conferenceRoomDto) {
        ConferenceRoomDto conferenceRoomDto1 = conferecneRoomService.updateConferenceRoom(conferenceRoomDto);
        return ResponseEntity.ok(conferenceRoomDto1);
    }

    @DeleteMapping
    public ResponseEntity<ConferenceRoomDto> deleteConferenceRoom(@RequestBody ConferenceRoomDto conferenceRoomDto) {
        ConferenceRoomDto conferenceRoomDto1 = conferecneRoomService.deleteRoom(conferenceRoomDto);
        return ResponseEntity.ok(conferenceRoomDto1);
    }

    @PostMapping("/user")
    public ResponseEntity<ConferenceRoomDto> addUserToConferenceRoom(RequestEntity<AddUserToConferenceRoomDto> request) {
        String token = request.getHeaders().get("Authorization").toString();
        AddUserToConferenceRoomDto addUserToConferenceRoom = request.getBody();
        return new ResponseEntity<>(conferecneRoomService.addUserToConferenceRoom(addUserToConferenceRoom, token), HttpStatus.CREATED);
    }
}
