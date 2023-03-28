package com.rj.bookmanagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.rj.bookmanagement.DAO.UserRepo;
// import com.rj.bookmanagement.DTO.UserDTO;
import com.rj.bookmanagement.Model.User;

@Component
public class UserService {

    @Autowired
    private UserRepo userRepo;

    // get all Users
    public List<User> getAllUsers() {
        List<User> list = (List<User>) this.userRepo.findAll();
        return list;
    }

    // Add User
    public User addUser(User user) {

        user.setPassword(user.getPassword());
        User result = userRepo.save(user);
        return result;
    }

    // public String addUser(UserDTO userDTO) {
    // return null;
    // }

    // User Authenticate
    // public User authenticate(String email, String password) throws Exception {
    // User user = userRepo.findByEmail(email);
    // System.out.println("User>>> " + user);
    // if (user == null) {
    // throw new Exception("Invalid email or password");
    // }

    // // Compare the entered password with the stored hash
    // boolean passwordsMatch = new BCryptPasswordEncoder().matches(password,
    // user.getPassword());

    // if (!passwordsMatch) {
    // throw new Exception("Invalid email or password");
    // }
    // return user;
    // }
}
