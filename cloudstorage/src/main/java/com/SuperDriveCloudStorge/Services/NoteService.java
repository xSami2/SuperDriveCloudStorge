package com.SuperDriveCloudStorge.Services;


import com.SuperDriveCloudStorge.Mapper.NotesMapper;
import com.SuperDriveCloudStorge.Model.FileModel;
import com.SuperDriveCloudStorge.Model.NoteModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

       private final NotesMapper notesMapper;
       private final UserService userService;


    public Boolean isNoteExist(Integer noteid , Integer userId){return notesMapper.isNoteExist(noteid , userId) != 0;}

    public Boolean createNote(NoteModel noteModel)  {
        Integer noteid = noteModel.getNoteid();
        Integer currentUserId = userService.getUserId();
        noteModel.setUserid(currentUserId);
        boolean isNoteExistInDatabase =  isNoteExist(noteid , currentUserId);
        if(isNoteExistInDatabase){
            notesMapper.update(noteModel);
            return false;
        }
            notesMapper.insert(noteModel);
            return true;

    }

    public NoteModel getNoteById(Integer noteid){return notesMapper.getNoteById(noteid);}
    public void deleteNoteById(Integer noteid){
        notesMapper.deleteNoteById(noteid);
    }

    public List<NoteModel> getUserNote(Integer currentUserId){
        return notesMapper.getUserNoteByUserId(currentUserId);
    }
}
