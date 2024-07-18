package com.api.system_transaction.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;
import com.api.system_transaction.DTOS.TransactionDTO;
import com.api.system_transaction.common.TransactionConstants;
import com.api.system_transaction.domain.product.Product;
import com.api.system_transaction.domain.transaction.Transaction;
import com.api.system_transaction.domain.user.User;
import com.api.system_transaction.repositories.ProductRepository;
import com.api.system_transaction.repositories.TransactionRepository;
import com.api.system_transaction.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = TransactionService.class)
public class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserService userService;

    @MockBean
    private TransactionRepository transactionRepository;


    @Test
    public void createTransaction_WithValidDate_ReturnsTransaction() throws Exception {

        TransactionDTO transactionDTO = TransactionConstants.TRANSACTION_DTO;
        Transaction transaction = TransactionConstants.TRANSACTION;

        Product product = new Product();
        product.setId(1L);
        product.setPrice(10.00);

        User sender = new User();
        sender.setId(1L);
        sender.setProductId(product);

        when(productRepository.save(ArgumentMatchers.any(Product.class))).thenReturn(product);
        when(userService.findUserById(ArgumentMatchers.anyLong())).thenReturn(sender);
        Transaction sut = transactionService.createTransaction(transactionDTO);
        assertThat(sut).isEqualTo(transaction);

    }

    @Test
    public void createTransaction_WithInvalidDate_ThrowsException(){


        TransactionDTO transactionDTO = TransactionConstants.INVALID_TRANSACTION;
        Transaction transaction = TransactionConstants.TRANSACTION;

        Product product = new Product();
        product.setId(1L);
        product.setPrice(10.00);

        User sender = new User();
        sender.setId(1L);
        sender.setProductId(product);

        when(transactionRepository.save(transaction)).thenThrow(RuntimeException.class);

        assertThatThrownBy(()->transactionService.createTransaction(transactionDTO)).isInstanceOf(RuntimeException.class);





    }
}
