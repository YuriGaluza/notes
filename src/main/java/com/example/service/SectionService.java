package com.example.service;

import com.example.dto.request.SectionDtoRequest;
import com.example.exception.UserNotFoundException;
import com.example.model.Section;
import com.example.repository.SectionRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SectionService {
    private final SectionRepository sectionRepository;
    private final UserService userService;

    public SectionService(SectionRepository sectionRepository, UserService userService) {
        this.sectionRepository = sectionRepository;
        this.userService = userService;
    }

    public void addSection(SectionDtoRequest sectionDtoRequest) throws UserNotFoundException {
        Section section = new Section();
        section.setName(sectionDtoRequest.getName());
        section.setUser(userService.getCurrentUser());
        section.setCreateDate(new Date());
        sectionRepository.save(section);
    }
}
