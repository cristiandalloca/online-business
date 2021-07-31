package br.com.cdb.core.enviroment;

import br.com.cdb.core.model.customer.Customer;
import br.com.cdb.core.model.customer.CustomerPhone;

public class PhonesEnviroment {

    public static CustomerPhone customerPhone1(Customer customer) {
        CustomerPhone customerPhone = new CustomerPhone();
        customerPhone.setNumber("+5518981832227");
        customerPhone.setDescription("Principal");
        customerPhone.setMain(Boolean.TRUE);
        customerPhone.setCustomer(customer);
        return customerPhone;
    }
}
