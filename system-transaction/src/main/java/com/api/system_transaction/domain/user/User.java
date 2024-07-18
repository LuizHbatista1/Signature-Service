package com.api.system_transaction.domain.user;


import com.api.system_transaction.DTOS.UserDTO;
import com.api.system_transaction.domain.product.Product;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;


@Entity(name = "users")
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String phone;
    @Column(unique = true)
    private String document;
    @JoinColumn(name = "product_id")
    @OneToOne
    private Product productId;

    public User (UserDTO data){

        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.email = data.email();
        this.document = data.document();
        this.phone = data.phone();
        this.productId = getProductId();

    }

    @Override
    public boolean equals(Object object){

        return  EqualsBuilder.reflectionEquals(object , this);

    }

}
