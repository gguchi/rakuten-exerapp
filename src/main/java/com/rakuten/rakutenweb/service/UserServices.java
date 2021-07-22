package com.rakuten.rakutenweb.service;

import com.rakuten.rakutenweb.model.Product;
import com.rakuten.rakutenweb.model.User;
import com.rakuten.rakutenweb.repository.ProductRepository;
import com.rakuten.rakutenweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServices implements UserService{

    @Autowired
    private UserRepository userRepo;

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

}
