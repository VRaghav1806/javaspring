package com.eduhub.eduhub_backend.component;

import com.eduhub.eduhub_backend.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    List<User> users = new ArrayList<>();

    public UserService(){

        users.add(new User("U101","Ram","123"));
        users.add(new User("U102","Sam","234"));
        users.add(new User("U103","Tom","345"));
        users.add(new User("U104","John","456"));
        users.add(new User("U105","Raj","567"));
    }

    public List<User> getAllUsers(){
        return users;
    }

    public Optional<User> findUser(String userId){

        return users.stream()
                .filter(u ->
                        u.getUserId()
                                .equalsIgnoreCase(userId))
                .findFirst();
    }

    public User addUser(User user){

        users.add(user);

        return user;
    }

    public User updatePassword(
            String userId,
            String password){

        User user =
                findUser(userId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "User",
                                        "userId",
                                        userId));

        user.setPassword(password);

        return user;
    }

    public String deleteUser(
            String userId){

        User user =
                findUser(userId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "User",
                                        "userId",
                                        userId));

        users.remove(user);

        return "Deleted Successfully";
    }
}