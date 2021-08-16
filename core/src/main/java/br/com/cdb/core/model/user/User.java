package br.com.cdb.core.model.user;

import br.com.cdb.core.model.audit.DateAudit;
import br.com.cdb.core.model.catalog.Catalog;
import br.com.cdb.core.model.city.City;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"user\"", uniqueConstraints = {@UniqueConstraint(name = "uc_cpf", columnNames = "cpf"),
        @UniqueConstraint(name = "uc_email", columnNames = "email")})
@Getter
@Setter
public class User extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<UserPhone> phones = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "USER_CATALOG",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "catalog_id"))
    private Set<Catalog> catalogs = new HashSet<>();

    public void addPhone(UserPhone phone) {
        this.phones.add(phone);
        phone.setUser(this);
    }

    public void addCatalog(Catalog catalog) {
        this.catalogs.add(catalog);
        catalog.getUsers().add(this);
    }

    public void removeCatalog(Catalog catalog) {
        this.catalogs.remove(catalog);
        catalog.getUsers().remove(this);
    }
}
