package com.prashant.demo.controller;

import com.prashant.demo.convert.NoteConvertService;
import com.prashant.demo.dto.NoteDto;
import com.prashant.demo.modal.Note;
import com.prashant.demo.service.NoteService;
import com.prashant.demo.service.UserProfileService;
import com.prashant.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api")
@Controller
public class TableController {
    private final NoteService noteService;
    private final UserService userService;
    private final UserProfileService userProfileService;
    private final NoteConvertService noteConvertService;



    @Autowired
    public TableController(NoteService noteService, UserService userService, UserProfileService userProfileService, NoteConvertService noteConvertService) {
        this.noteService = noteService;
        this.userService = userService;
        this.userProfileService = userProfileService;
        this.noteConvertService = noteConvertService;
    }


    @GetMapping(value = "/table")
    public String getNoteDisplay(Model model){
        model.addAttribute("notes",noteService.findAllNotes());
        return "notes";
    }

    @GetMapping(value = "/usertable")
    public String getUserDisplay(Model model){
        model.addAttribute("users",userService.findAllUsers());
        return "users";
    }

    @GetMapping(value = "/userprofile")
    public String getUserProfile(Model model){
        model.addAttribute("userprofiles",userProfileService.getAllUserProfile());
        return "userprofile";
    }

    @GetMapping(value = "/addnotes")
    public String helloForm(Model model){
        model.addAttribute("note",new NoteDto());
        return "addnotes";
    }

    @PostMapping(value = "/addnotes")
    public String submitNote(@ModelAttribute NoteDto noteDto, Model model){
        noteService.insertDetails(noteDto);
        model.addAttribute("notes",noteService.findAllNotes());
        return "notes";
    }


}
