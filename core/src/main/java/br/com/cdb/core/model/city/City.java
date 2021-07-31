package br.com.cdb.core.model.city;

import br.com.cdb.core.model.state.State;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "city")
@Entity
@Getter
@Setter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_generator")
    @SequenceGenerator(name = "city_generator", sequenceName = "city_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "state_id", nullable = false)
    private State state;

}