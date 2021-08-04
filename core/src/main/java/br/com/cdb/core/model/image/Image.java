package br.com.cdb.core.model.image;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_generator")
    @SequenceGenerator(name = "image_generator", sequenceName = "image_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "main", nullable = false)
    private Boolean main = Boolean.FALSE;

    @Column(name = "url", length = 1024)
    private String url;

}