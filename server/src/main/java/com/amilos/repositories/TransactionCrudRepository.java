package com.amilos.repositories;

import com.amilos.models.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Milos on 15.06.2017..
 */
@Repository
public interface TransactionCrudRepository extends CrudRepository<Transaction , Long> {

    public List<Transaction> findAll();
    public List<Transaction> findAllByUserId(Long userId);
}
