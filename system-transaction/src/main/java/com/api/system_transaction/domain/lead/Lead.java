package com.api.system_transaction.domain.lead;


import com.api.system_transaction.DTOS.LeadDTO;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;

@Entity(name = "leads")
@Table(name = "leads")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String message;
    @Column(unique = true , nullable = false)
    private String email;

    public Lead (LeadDTO data){

        this.name = data.name();
        this.message = data.message();
        this.email = data.email();

    }



}
