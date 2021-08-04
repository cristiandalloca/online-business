package br.com.cdb.core.model.product;

import br.com.cdb.core.model.image.Image;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "product_image")
@Entity
@Getter
@Setter
public class ProductImage extends Image {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product = new Product();
}