package br.com.cdb.core.model.customer;

import br.com.cdb.core.model.phone.PhoneType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerPhoneDTO {

    private String number;

    private String description;

    private boolean main;

    private PhoneType type;

    private Long idNetwork;
}
