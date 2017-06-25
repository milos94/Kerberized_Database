package com.amilos.serviceimplementations;

import com.amilos.models.Transaction;
import com.amilos.repositories.TransactionCrudRepository;
import com.amilos.services.CryptoService;
import com.amilos.services.TransactionService;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.util.List;

/**
 * Created by Milos on 15.06.2017..
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionCrudRepository transactionCrudRepository;

    private CryptoService cryptoService;

    public TransactionServiceImpl(TransactionCrudRepository transactionCrudRepository, CryptoService cryptoService) {
        this.transactionCrudRepository = transactionCrudRepository;
        this.cryptoService = cryptoService;
    }

    @Override
    public List<Transaction> findAll() throws Exception {

        List<Transaction> transactions = transactionCrudRepository.findAll();
        BASE64Decoder decoder = new BASE64Decoder();
        /*transactions.stream().forEach(transaction -> transaction.setValue(new String(
                    cryptoService.decryptDatabaseData(decoder.decodeBuffer(transaction.getValue())))));*/
        for (Transaction t: transactions) {
            t.setValue(new String(
                    cryptoService.decryptDatabaseData(decoder.decodeBuffer(t.getValue()))));
        }
        return transactions;

    }

    @Override
    public List<Transaction> findAllByUserId(Long Id) throws Exception {
        List<Transaction> transactions = transactionCrudRepository.findAllByUserId(Id);
        BASE64Decoder decoder = new BASE64Decoder();
        /*transactions.stream().forEach(transaction -> transaction.setValue(new String(
                cryptoService.decryptDatabaseData(decoder.decodeBuffer(transaction.getValue())))));*/
        for (Transaction t: transactions) {
            t.setValue(new String(
                    cryptoService.decryptDatabaseData(decoder.decodeBuffer(t.getValue()))));
        }
        return transactions;
    }

    @Override
    public void insert(Transaction t) {
        transactionCrudRepository.save(t);
    }
}
