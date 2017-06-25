package com.amilos.repositories;

import com.amilos.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Milos on 13.06.2017..
 */
@Repository
public interface UserCrudRepository extends CrudRepository<User,Long> {

    public User findFirstByUserId(Long id);
    public List<User> findAll();

}
