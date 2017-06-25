package com.amilos.services;

import com.amilos.models.User;

import java.util.List;

/**
 * Created by Milos on 13.06.2017..
 */
public interface UserService {

    public User getFirsByUserId(Long id);
    public List<User> findAll();
}
