package br.com.cdb.core.model.user;

import br.com.cdb.core.model.phone.Phone;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "user_phone")
@Entity
@Getter
@Setter
public class UserPhone extends Phone {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user = new User();

}