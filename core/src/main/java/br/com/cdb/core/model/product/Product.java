package br.com.cdb.core.model.product;

import br.com.cdb.core.model.audit.DateAudit;
import br.com.cdb.core.model.catalog.Catalog;
import br.com.cdb.core.model.supplier.Supplier;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Table(name = "product")
@Entity
@Getter
@Setter
public class Product extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
    @SequenceGenerator(name = "product_generator", sequenceName = "product_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_type", nullable = false)
    private ProductType productType = ProductType.PRODUCT;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "code", length = 40)
    private String code;

    @Column(name = "sale_value", precision = 19, scale = 2, nullable = false)
    private BigDecimal saleValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier = new Supplier();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catalog_id", nullable = false)
    private Catalog catalog = new Catalog();

    @OneToMany(mappedBy = "product", orphanRemoval = true)
    private Set<ProductImage> images = new HashSet<>();

    public void addImage(ProductImage image) {
        this.images.add(image);
        image.setProduct(this);
    }
}