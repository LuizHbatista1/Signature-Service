package com.api.system_transaction.service;

import com.api.system_transaction.DTOS.UserDTO;
import com.api.system_transaction.domain.product.Product;
import com.api.system_transaction.domain.user.User;
import com.api.system_transaction.infra.exceptions.NotFoundIdException;
import com.api.system_transaction.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductService productService;


    public User findUserById(Long id){

        return this.userRepository.findById(id).orElseThrow(()-> new RuntimeException(new NotFoundIdException(id)));

    }

    public User createUser(UserDTO userDTO){

        Product product = productService.findProductById(userDTO.productId());
        User newUser = new User(userDTO);
        newUser.setFirstName(newUser.getFirstName());
        newUser.setLastName(newUser.getLastName());
        newUser.setEmail(newUser.getEmail());
        newUser.setPhone(newUser.getPhone());
        newUser.setDocument(newUser.getDocument());
        newUser.setProductId(product);
        this.saveUser(newUser);
        this.productService.saveProduct(product);
        return newUser;

    }

    public void saveUser (User user){

        this.userRepository.save(user);

    }

}
