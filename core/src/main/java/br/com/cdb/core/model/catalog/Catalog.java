package br.com.cdb.core.model.catalog;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "catalog")
@Entity
@Getter
@Setter
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalog_generator")
    @SequenceGenerator(name = "catalog_generator", sequenceName = "catalog_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "catalog_type")
    private CatalogType catalogType;

}