package com.SuperDriveCloudStorge.Model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class UserModel {


      private Integer userId;
      private String username;
      private String salt;
      private String password;
      private String firstname;
      private String lastname;

      public UserModel(Integer userId, String username, String salt, String password, String firstname, String lastname) {
            this.userId = userId;
            this.username = username;
            this.salt = salt;
            this.password = password;
            this.firstname = firstname;
            this.lastname = lastname;
      }

}
