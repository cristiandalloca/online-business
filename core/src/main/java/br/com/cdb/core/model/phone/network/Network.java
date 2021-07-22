package br.com.cdb.core.model.phone.network;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "network")
@Entity
@Getter
@Setter
public class Network {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "network_generator")
    @SequenceGenerator(name = "network_generator", sequenceName = "network_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

}