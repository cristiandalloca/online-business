package br.com.cdb.core.model.customer;

import br.com.cdb.core.model.phone.Phone;

import javax.persistence.*;

@Table(name = "customer_phone")
@Entity
public class CustomerPhone extends Phone {

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer = new Customer();

}