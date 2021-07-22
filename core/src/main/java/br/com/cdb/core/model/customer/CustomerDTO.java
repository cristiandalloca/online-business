package br.com.cdb.core.model.customer;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CustomerDTO {

    private String name;

    private CustomerType type;

    private LocalDate birthday;

    private String email;

    private List<CustomerPhoneDTO> phones;
}
