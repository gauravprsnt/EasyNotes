package com.prashant.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NoteDto {
    private String title;
    private String content;
    private Long userId;
}
