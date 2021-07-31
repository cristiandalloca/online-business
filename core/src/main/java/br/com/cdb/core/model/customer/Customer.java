package br.com.cdb.core.model.customer;

import br.com.cdb.core.model.audit.DateAudit;
import br.com.cdb.core.model.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Table(name = "customer", indexes =
        {@Index(name = "idx_name", columnList = "name"),
                @Index(name = "idx_birthday", columnList = "birthday")})
@Entity
@Getter
@Setter
public class Customer extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_generator")
    @SequenceGenerator(name = "customer_generator", sequenceName = "customer_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private CustomerType type = CustomerType.DEFAULT;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private Set<CustomerPhone> phones = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}