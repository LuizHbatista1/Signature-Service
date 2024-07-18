package com.api.system_transaction.service;




import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;
import com.api.system_transaction.DTOS.UserDTO;
import com.api.system_transaction.common.ProductConstants;
import com.api.system_transaction.common.UserConstants;
import com.api.system_transaction.domain.user.User;
import com.api.system_transaction.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.management.RuntimeMBeanException;

@SpringBootTest(classes = UserService.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private ProductService productService;

    @MockBean
    private UserRepository userRepository;


    @Test
    public void createUser_WithValidDate_ReturnsUser() throws Exception {

        UserDTO userDTO = UserConstants.USER_DTO;
        User user = new User(userDTO);

        when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);

        User sut = userService.createUser(userDTO);
        assertThat(sut).isEqualTo(user);

    }

    @Test
    public void createUser_WithInvalidDate_ThrowsException(){


        UserDTO userDTO = UserConstants.INVALID_USER;
        User user = new User(userDTO);

        when(userRepository.save(user)).thenThrow(RuntimeMBeanException.class);
        assertThatThrownBy(()->userService.createUser(userDTO)).isInstanceOf(RuntimeMBeanException.class);



    }



}
