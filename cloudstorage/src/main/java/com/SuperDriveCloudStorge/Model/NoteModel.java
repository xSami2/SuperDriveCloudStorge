package com.SuperDriveCloudStorge.Model;


import lombok.Data;

@Data
public class NoteModel {
      private int note_id;
      private String note_title;
      private String note_description;
      private int user_id;

}
