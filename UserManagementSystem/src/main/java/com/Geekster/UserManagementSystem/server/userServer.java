package com.Geekster.UserManagementSystem.server;

import com.Geekster.UserManagementSystem.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class userServer {

   private static List<User> UserList = new ArrayList<>();
    public List<User> getall(){
        return UserList;
    }
    public User getUser(int id){
        for(User user:UserList){
            if(user.getUserId()==id){
                return user;
            }
        }
        return new User();
    }
    public void AddUser(User use){
        UserList.add(use);
    }
    public void DeleteUser(int id){
        for(User req:UserList){
            if(req.getUserId()==id){
                UserList.remove(req);
            }
        }
    }
    public void UpdateUser(int UserId,User user){

        User use = getUser(UserId);
        use.setName(user.getName());
        use.setAddress(user.getAddress());
        use.setUserId(user.getUserId());
    }

}
