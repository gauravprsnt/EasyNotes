package com.prashant.demo.convert;

import com.prashant.demo.modal.Note;
import com.prashant.demo.resource.NoteResource;

public interface NoteConvertService {
    NoteResource convertNote(Note note);

    //NoteResource display(Note note);
}
