package com.amilos.serviceimplementations;

import com.amilos.models.User;
import com.amilos.repositories.UserCrudRepository;
import com.amilos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Milos on 13.06.2017..
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Override
    public User getFirsByUserId(Long id) {
        return userCrudRepository.findFirstByUserId(id);
    }

    @Override
    public List<User> findAll() {
        return userCrudRepository.findAll();
    }
}
