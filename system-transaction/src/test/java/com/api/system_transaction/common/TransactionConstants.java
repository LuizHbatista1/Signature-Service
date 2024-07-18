package com.api.system_transaction.common;

import com.api.system_transaction.DTOS.TransactionDTO;
import com.api.system_transaction.domain.transaction.Transaction;

public class TransactionConstants {

    public final static TransactionDTO TRANSACTION_DTO = new TransactionDTO(1L , "Test","0000 0000 0000 0000",000,"00/00",20.00);
    public final static Transaction TRANSACTION = new Transaction(TRANSACTION_DTO);
    public final static TransactionDTO INVALID_TRANSACTION = new TransactionDTO(1L , "Test","0000 0000 0000 0000",0000,"00/00",20.00);

}
