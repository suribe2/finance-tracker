package com.financetracker.finance_tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")

public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    //Returns all the transactions from the database
    @GetMapping
    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    //Save the transaction to the database
    @PostMapping
    public Transaction saveTransaction(@RequestBody Transaction transaction){
        return transactionRepository.save(transaction);
    }

    //Searches for ID whenever asked
    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    //Allows program to delete an ID when called upon
    @DeleteMapping("/{id}")
    public void deleteTransactionById(@PathVariable Long id){
        transactionRepository.deleteById(id);
    }

}
