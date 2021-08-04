package br.com.cdb.core.model.customer.repository;

import br.com.cdb.core.enviroment.CustomersEnviroment;
import br.com.cdb.core.enviroment.UsersEnviroment;
import br.com.cdb.core.model.customer.Customer;
import br.com.cdb.core.model.customer.CustomerType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository repository;

    @Test
    void shouldInsertANewCustomer() {
        Long userId = entityManager.persist(UsersEnviroment.userMaria()).getId();
        assertNotNull(userId);

        entityManager.persist(CustomersEnviroment.customerJoaoDaSilva(userId));

        List<Customer> customers = repository.findAllByNameContaining("João");
        assertFalse(customers.isEmpty());
        assertCustomerJoao(customers.get(0));
    }

    private void assertCustomerJoao(Customer customer) {
        assertNotNull(customer.getId());
        assertEquals("João da Silva", customer.getName());
        assertEquals("joao.da.silva@gmail.com", customer.getEmail());
        assertEquals(LocalDate.of(1997, Month.FEBRUARY, 6), customer.getBirthday());
        assertEquals(CustomerType.DEFAULT, customer.getType());
        assertNotNull(customer.getPhones());

        assertNotNull(customer.getUser());
        assertNotNull(customer.getUser().getId());

        assertNotNull(customer.getPhones());
        assertFalse(customer.getPhones().isEmpty());
    }
}