package com.rj.bookmanagement.DAO;

import org.springframework.data.repository.CrudRepository;

import com.rj.bookmanagement.Model.User;

public interface UserRepo extends CrudRepository<User, Integer> {
    public User findById(int id);

    public User findByEmail(String email);

}
