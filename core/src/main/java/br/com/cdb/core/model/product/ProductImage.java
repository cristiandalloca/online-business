package br.com.cdb.core.model.product;

import br.com.cdb.core.model.image.Image;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "product_image")
@Entity
@Getter
@Setter
public class ProductImage extends Image {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product = new Product();
}