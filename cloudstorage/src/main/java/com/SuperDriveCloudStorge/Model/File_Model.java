package com.SuperDriveCloudStorge.Model;

import lombok.Data;

@Data
public class File_Model {


       private int file_id;

       private String file_name;

       private String content_type;

       private String file_size;

       private int user_id;

       private byte[] file_data;


}
