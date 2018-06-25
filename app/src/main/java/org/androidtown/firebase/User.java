package org.androidtown.firebase;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {

  public String id;
  public String username;
  public String email;

  public User() {
    // Default constructor required for calls to DataSnapshot.getValue(User.class)
  }

  public User(String id, String username, String email) {
    this.id = id;
    this.username = username;
    this.email = email;
  }
} // end of password
