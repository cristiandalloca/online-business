package br.com.cdb.core.model.state;

import br.com.cdb.core.util.converter.UpperCaseConverter;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;

@Table(name = "state", indexes = @Index(name = "idx_acronym", columnList = "acronym"),
        uniqueConstraints = @UniqueConstraint(name = "uc_acronym", columnNames = "acronym"))
@Entity
@Getter
@Setter
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "state_generator")
    @SequenceGenerator(name = "state_generator", sequenceName = "state_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "acronym", length = 2, nullable = false)
    @ColumnTransformer(read = "UPPER(acronym)")
    private String acronym;

}