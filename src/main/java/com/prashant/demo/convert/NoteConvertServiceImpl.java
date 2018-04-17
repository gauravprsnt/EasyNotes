package com.prashant.demo.convert;

import com.prashant.demo.modal.Note;
import com.prashant.demo.resource.NoteResource;
import org.springframework.stereotype.Service;

@Service
public class NoteConvertServiceImpl implements NoteConvertService {

    @Override
    public NoteResource convertNote(Note note) {
        NoteResource noteResource = new NoteResource();
        noteResource.setContent(note.getContent());
        noteResource.setCreatedDate(note.getCreatedAt());
        noteResource.setNoteId(note.getId());
        noteResource.setNoteStatus(note.getStatus());
        noteResource.setTitle(note.getTitle());
        noteResource.setCreatedBy(note.getUser().getDisplayName());
        return noteResource;
        }




}
