package com.example.demo.service;

import com.example.demo.pojo.User;



public interface UserService {

    User findByUserNameNote(String userName, String note);
}
