package com.rakuten.rakutenweb.service;

import com.rakuten.rakutenweb.model.User;
import com.rakuten.rakutenweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class UserServices implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    public void save(User user) {
        userRepo.save(user);
    }

    @Transactional
    public Optional<User> findUserByEmail(String email) { return userRepo.findUserByEmail(email);}

    public boolean userExist(String email){
        return findUserByEmail(email).isPresent();
    }

    public Optional<org.springframework.security.core.userdetails.User> findUserByUsername(String username) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new org.springframework.security.core.userdetails.User("admin","password", new ArrayList<>());
    }
}
