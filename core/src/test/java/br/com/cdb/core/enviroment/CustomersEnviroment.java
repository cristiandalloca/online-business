package br.com.cdb.core.enviroment;

import br.com.cdb.core.model.customer.Customer;
import br.com.cdb.core.model.customer.CustomerPhone;
import br.com.cdb.core.model.customer.CustomerType;
import br.com.cdb.core.model.user.User;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomersEnviroment {

    public static Customer customerJoaoDaSilva(Long userId) {
        Customer customer = new Customer();
        customer.setName("João da Silva");
        customer.setEmail("joao.da.silva@gmail.com");

        customer.setBirthday(LocalDate.of(1997, Month.FEBRUARY, 6));
        customer.setType(CustomerType.DEFAULT);

        User user = new User();
        user.setId(userId);
        customer.setUser(user);

        CustomerPhone customerPhone = PhonesEnviroment.customerPhone1(customer);
        Set<CustomerPhone> phones = new HashSet<>();
        phones.add(customerPhone);
        customer.setPhones(phones);

        return customer;
    }
}
