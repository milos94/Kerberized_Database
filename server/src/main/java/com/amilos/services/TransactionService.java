package com.amilos.services;

import com.amilos.models.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Milos on 15.06.2017..
 */
@Service
public interface TransactionService {
    public List<Transaction> findAll() throws Exception;
    public List<Transaction> findAllByUserId(Long Id) throws Exception;
    public void insert(Transaction t);
}
