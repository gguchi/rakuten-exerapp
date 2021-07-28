package com.rakuten.rakutenweb.service;

import com.rakuten.rakutenweb.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    void save(User user);
}
