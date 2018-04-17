package com.prashant.demo.resource;

import com.prashant.demo.modal.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class NoteResource {
    private Long noteId;
    private String title;
    private String content;
    private Date createdDate;
    private Status noteStatus;
    private String createdBy;
}