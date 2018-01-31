package net.wasdev.sample.microprofile.user;

import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;


import net.wasdev.sample.microprofile.user.User;

public class UserList {

  private static ArrayList<User> users = new ArrayList<>();

  public void addUser(User newUser) {
    users.add(newUser);
    //System.out.println("add user" + user.toString());
  }

  public User getUser(String name) {
    for (User user : users) {
      if (user.getName().equals(name)) {
        //System.out.println("get user" + user.toString());
        return user;
      }
    }
    return null;
  }

  public ArrayList<User> getUsersList() {
    return users;
  }

}
