package com.rj.bookmanagement.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rj.bookmanagement.Model.User;
import com.rj.bookmanagement.Service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    // Add new user
    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User u = null;
        try {
            u = this.userService.addUser(user);
            System.out.println(u);
            return ResponseEntity.of(Optional.of(u));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // // User Login
    // @PostMapping("/login")
    // public ResponseEntity<User> userLogin(@RequestBody User user) {
    // User u = null;
    // try {
    // u = this.userService.authenticate(user.getemail(), user.getPassword());
    // return ResponseEntity.of(Optional.of(u));
    // } catch (Exception e) {
    // e.printStackTrace();
    // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    // }
    // }
}
