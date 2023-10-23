package com.SuperDriveCloudStorge.Controller;

import com.SuperDriveCloudStorge.Model.NoteModel;
import com.SuperDriveCloudStorge.Services.NoteService;
import com.SuperDriveCloudStorge.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping({"/note"})
public class NoteController {

        private final UserService userService;
        private final NoteService noteService;

    @PostMapping
    public String createNote(NoteModel noteModel){
      System.out.println(noteModel.toString());
      noteService.createNote(noteModel);
        return "redirect:/home";
    }

    @GetMapping("/delete/{noteid}")
    public String deleteNoteById(@PathVariable Integer noteid){
        noteService.deleteNoteById(noteid);
        return "redirect:/home";
    }

    @GetMapping("/edit/{noteid}")
    public String editNote(@PathVariable Integer noteid){
        System.out.println(noteid);
        return "redirect:/home";
    }

}
