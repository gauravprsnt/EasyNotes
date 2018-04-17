package com.prashant.demo.service.impl;

import com.prashant.demo.dto.NoteDto;
import com.prashant.demo.exception.ResourceNotFoundException;
import com.prashant.demo.modal.Note;
import com.prashant.demo.modal.Status;
import com.prashant.demo.repository.NoteRepository;
import com.prashant.demo.service.NoteService;
import com.prashant.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceimpl implements NoteService {

    private final NoteRepository noteRepository;
    private final UserService userService;

    @Autowired
    public NoteServiceimpl(NoteRepository noteRepository, UserService userService) {
        this.noteRepository = noteRepository;
        this.userService = userService;
    }

    @Override
    public List<Note> findAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note insertDetails(NoteDto noteDto) {

        Note note=new Note();
        note.setContent(noteDto.getContent());
        note.setTitle(noteDto.getTitle());
        note.setStatus(Status.ACTIVE);
        note.setUser(userService.findByUserId(noteDto.getUserId()));
        return noteRepository.save(note);
    }

    @Override
    public Optional<Note> getIndividualData(Long noteId) {
        return noteRepository.findById(noteId);
    }


    @Override
    public Note updateNoteValue(Long noteId, NoteDto noteDto) {
        Note note=noteRepository.findById(noteId).orElseThrow(()-> new ResourceNotFoundException("Note","id",noteId));
        note.setContent(noteDto.getContent());
        note.setTitle(noteDto.getTitle());
        return noteRepository.save(note);
    }

    @Override
    public Note updateNoteStatus(Long noteId, NoteDto noteDto) {
        Note note=noteRepository.findById(noteId).orElseThrow(()-> new ResourceNotFoundException("Note","id",noteId));
        note.setContent(noteDto.getContent());
        note.setTitle(noteDto.getTitle());
        note.setStatus(Status.INACTIVE);
        return noteRepository.save(note);
    }

    @Override
    public String fetchData(Long noteId) {
        return noteRepository.findTitleById(noteId);
    }

    @Override
    public List<Note> displayAllData(Long noteId) {
        return noteRepository.findAllData(noteId);
    }

    @Override
    public List<Note> displayJoinData(Long noteId) {
        return noteRepository.findJoinData(noteId);
    }
}
