package com.api.system_transaction.service;

import com.api.email_service.service.emailService.EmailSESService;
import com.api.system_transaction.DTOS.TransactionDTO;
import com.api.system_transaction.domain.transaction.Transaction;
import com.api.system_transaction.domain.user.User;
import com.api.system_transaction.infra.constants.BodyConstants;
import com.api.system_transaction.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailSESService emailSESService;

    public Transaction createTransaction(TransactionDTO transactionDTO) throws Exception {

        User sender = userService.findUserById(transactionDTO.sender());
        String subject = "Congratulations !";
        String body = "thank to choose the plan " + sender.getProductId().getTitle();
        Transaction newTransaction = new Transaction(transactionDTO);
        newTransaction.setNameOfCard(newTransaction.getNameOfCard());
        newTransaction.setNumberOfCard(newTransaction.getNumberOfCard());
        newTransaction.setCodeSecurity(newTransaction.getCodeSecurity());
        newTransaction.setValidate(newTransaction.getValidate());
        newTransaction.setBalance(newTransaction.getBalance());
        newTransaction.setSender(sender);
        validateTransaction(sender, transactionDTO.balance());
        emailSESService.sendEmail(sender.getEmail() ,subject , body );
        this.saveTransaction(newTransaction);
        userService.saveUser(sender);
        return newTransaction;

    }

    public void saveTransaction(Transaction transaction){

        this.transactionRepository.save(transaction);

    }

    public void validateTransaction(User sender , Double value) throws Exception {

        if(sender.getProductId().getPrice().compareTo(value) > 0) {

            throw new Exception(" Invalid Transaction ! ");

        }

    }

}
