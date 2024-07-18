package com.api.system_transaction.common;

import com.api.system_transaction.DTOS.TransactionDTO;
import com.api.system_transaction.DTOS.UserDTO;
import com.api.system_transaction.domain.transaction.Transaction;
import com.api.system_transaction.domain.user.User;

public class UserConstants {

    public static final UserDTO USER_DTO = new UserDTO("Teste", "Teste","teste@gmail.com", "(xx)0000-0000","000.000.000-00",1L);
    public static final UserDTO INVALID_USER = new UserDTO("", "","", "","",1L);
    public static final User USER = new User(USER_DTO);

}
