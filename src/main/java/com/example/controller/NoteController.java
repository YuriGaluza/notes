package com.example.controller;

import com.example.dto.request.NoteDtoRequest;
import com.example.dto.request.SectionDtoRequest;
import com.example.dto.response.NoteDtoResponse;
import com.example.dto.response.SectionDtoResponse;
import com.example.exception.UserNotFoundException;
import com.example.service.AuthenticationService;
import com.example.service.SectionService;
import com.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {
    private final SectionService sectionService;
    private final AuthenticationService authenticationService;

    public NoteController(SectionService sectionService, AuthenticationService authenticationService) {
        this.sectionService = sectionService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/add_note")
    public ResponseEntity<NoteDtoResponse> addNote(@RequestBody NoteDtoRequest note,
                                        @RequestBody SectionDtoRequest sectionDtoRequest) {
        NoteDtoResponse noteDtoResponse = new NoteDtoResponse();
        return ResponseEntity.ok(noteDtoResponse);
    }

    @PutMapping("/add_section")
    public ResponseEntity<SectionDtoResponse> addSection(@RequestBody SectionDtoRequest sectionDtoRequest)
            throws UserNotFoundException {
        sectionService.addSection(sectionDtoRequest);
        SectionDtoResponse sectionDtoResponse = new SectionDtoResponse();
        sectionDtoResponse.setName("Section " + sectionDtoRequest.getName() + " saved");
        return ResponseEntity.ok(sectionDtoResponse);
    }
}
