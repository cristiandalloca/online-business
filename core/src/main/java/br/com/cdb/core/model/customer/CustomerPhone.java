package br.com.cdb.core.model.customer;

import br.com.cdb.core.model.phone.Phone;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "customer_phone")
@Entity
@Getter
@Setter
public class CustomerPhone extends Phone {

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer = new Customer();

}