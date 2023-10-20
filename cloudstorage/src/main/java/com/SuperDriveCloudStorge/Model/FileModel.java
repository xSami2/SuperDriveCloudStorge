package com.SuperDriveCloudStorge.Model;

import lombok.Data;

@Data
public class FileModel {


       public FileModel(Integer fileId, String filename, String contenttype, long filesize, int userid, byte[] filedata) {
              this.fileId = fileId;
              this.filename = filename;
              this.contenttype = contenttype;
              this.filesize = String.valueOf(filesize);
              this.userid = userid;
              this.filedata = filedata;
       }

       private Integer fileId;

       private String filename;

       private String contenttype;

       private String filesize;

       private int userid;

       private byte[] filedata;


}
