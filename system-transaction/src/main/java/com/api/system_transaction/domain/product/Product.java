package com.api.system_transaction.domain.product;

import com.api.system_transaction.DTOS.ProductDTO;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;

@Entity(name = "products")
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Double price;

    public Product (ProductDTO data){

        this.title = data.title();
        this.description = data.description();
        this.price = data.price();

    }

    @Override
    public boolean equals(Object object){

       return  EqualsBuilder.reflectionEquals(object , this);

    }

}
