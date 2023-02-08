package com.Geekster.UserManagementSystem.contoller;

import com.Geekster.UserManagementSystem.model.User;
import com.Geekster.UserManagementSystem.server.userServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class userController {
   @Autowired
    private userServer userserver ;


    @GetMapping("/getAllUsers")
    public List<User> getAllUser(){
      return userserver.getall();
    }
    @GetMapping("/getUser/userid/{userid}")
    public User getUser(@PathVariable int userid){

        return userserver.getUser(userid);
    }
    @PostMapping("/addUser")
//    http://localhost:8080/User/addUser
    public void adduser(@RequestBody User use){
        userserver.AddUser(use);
        System.out.println("User Saved : "+use.getUserName());
    }
    @DeleteMapping("/deleteUser/userId/{userId}")
    public void deleteUser(@PathVariable int userId){
        userserver.DeleteUser(userId);
    }
    @PutMapping("/UpdateUser/userId/{userId}")
    public void UpdateUser(@PathVariable int userId,@RequestBody User use){
        userserver.UpdateUser(userId,use);
    }

}
