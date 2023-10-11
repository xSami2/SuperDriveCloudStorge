package com.SuperDriveCloudStorge.Model;

import lombok.Data;

@Data
public class User_Model {
      private int user_id;
      private String username;
      private String salt;
      private String password;
      private String first_name;
      private String last_name;
}
