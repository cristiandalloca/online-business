package br.com.cdb.core.model.customer;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CustomerDTO {

    @NotBlank
    private String name;

    private CustomerType type;

    private LocalDate birthday;

    @Email
    private String email;

    private List<CustomerPhoneDTO> phones;
}
