package com.api.system_transaction.controller;

import com.api.system_transaction.DTOS.TransactionDTO;
import com.api.system_transaction.domain.transaction.Transaction;
import com.api.system_transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


    @PostMapping("/create")
    public ResponseEntity<Transaction>createTransaction (@RequestBody TransactionDTO transactionDTO) throws Exception {

        Transaction newTransaction = transactionService.createTransaction(transactionDTO);
        return new ResponseEntity<>(newTransaction , HttpStatus.CREATED);


    }


}
