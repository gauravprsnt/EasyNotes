package com.prashant.demo.service;

import com.prashant.demo.dto.NoteDto;
import com.prashant.demo.modal.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    List<Note> findAllNotes();

    Note insertDetails(NoteDto noteDto);

    Optional<Note> getIndividualData(Long noteId);



    Note updateNoteValue(Long noteId, NoteDto noteDto);

    Note updateNoteStatus(Long noteId, NoteDto noteDto);

    String fetchData(Long noteId);

    List<Note> displayAllData(Long noteId);

    List<Note> displayJoinData(Long noteId);


    //Optional<Note> findWithId(Long noteId);
}
