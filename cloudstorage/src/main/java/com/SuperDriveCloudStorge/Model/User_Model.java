package com.SuperDriveCloudStorge.Model;

import lombok.Data;

@Data
public class User_Model {
      private int userId;
      private String username;
      private String salt;
      private String password;
      private String firstname;
      private String lastname;
}
