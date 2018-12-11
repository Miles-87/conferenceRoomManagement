package com.management.controllers;

import com.management.model.dto.ConferenceRoomDto;
import com.management.service.ConferecneRoomService;
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

}
