package com.api.system_transaction.domain.transaction;

import com.api.system_transaction.DTOS.TransactionDTO;
import com.api.system_transaction.domain.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.math.BigDecimal;

@Entity(name = "transactions")
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @JoinColumn(name = "sender_id")
    @ManyToOne
    private User sender;
    @Column(nullable = false)
    private String nameOfCard;
    @Column(nullable = false)
    private String numberOfCard;
    @Column(length = 3 , nullable = false)
    private Integer codeSecurity;
    @Column(nullable = false)
    private String validate;
    @Column(nullable = false)
    private Double balance;

    public Transaction (TransactionDTO data){

        this.nameOfCard = data.nameOfCard();
        this.numberOfCard = data.numberOfCard();
        this.codeSecurity = data.codeSecurity();
        this.validate = data.validate();
        this.balance = data.balance();
        this.sender = getSender();

    }

}
