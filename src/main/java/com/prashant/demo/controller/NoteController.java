package com.prashant.demo.controller;

import com.prashant.demo.convert.NoteConvertService;
import com.prashant.demo.dto.NoteDto;
import com.prashant.demo.modal.Note;
import com.prashant.demo.resource.NoteResource;
import com.prashant.demo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class NoteController {
    private final NoteService noteService;
    private final NoteConvertService noteConvertService;



    @Autowired
    public NoteController(NoteService noteService, NoteConvertService noteConvertService) {
        this.noteService = noteService;
        this.noteConvertService = noteConvertService;

    }

    @GetMapping(value = "/notes")
    public List<Note> getNotes(){
        return noteService.findAllNotes();
    }

    @PostMapping(value = "/notes")
    public NoteResource createNote(@RequestBody NoteDto noteDto){
        return noteConvertService.convertNote(noteService.insertDetails(noteDto));
    }

    @GetMapping(value = "/notes/{id}")
    public Optional<Note> getId(@PathVariable(value = "id")Long noteId){
        return noteService.getIndividualData(noteId);
    }

    @PutMapping(value = "/notes/{id}")
    public NoteResource updateNote(@PathVariable(value = "id")Long noteId,
                                   @RequestBody NoteDto noteDto){
        return noteConvertService.convertNote(noteService.updateNoteValue(noteId,noteDto));
    }

    @PutMapping(value = "/notes/{id}/delete")
    public NoteResource updateStatus(@PathVariable(value="id")Long noteId,
                                     @RequestBody NoteDto noteDto){
        return noteConvertService.convertNote(noteService.updateNoteStatus(noteId,noteDto));
    }

    @GetMapping(value = "/jpa/{id}")
    public String usingQuery(@PathVariable(value = "id") Long noteId){
        return noteService.fetchData(noteId);
    }

    @GetMapping(value = "/all/{id}")
    public List<Note> display(@PathVariable(value = "id")Long noteId){
        return  noteService.displayAllData(noteId);
    }

    @GetMapping(value = "/join/{id}")
    public List<Note> usingJoin(@PathVariable(value = "id")Long noteId){
        return  noteService.displayJoinData(noteId);
    }





}
