package br.com.cdb.core.model.phone;

import br.com.cdb.core.model.phone.network.Network;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_generator")
    @SequenceGenerator(name = "phone_generator", sequenceName = "phone_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "number", nullable = false, length = 40)
    private String number;

    @Column(name = "description")
    private String description;

    @Column(name = "main", nullable = false)
    private Boolean main = Boolean.FALSE;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private PhoneType type = PhoneType.MOBILE;

    @ManyToOne
    @JoinColumn(name = "network_id")
    private Network network = new Network();

}