package br.com.cdb.core.model.movement.output;

import br.com.cdb.core.model.movement.Movement;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "movement_output")
@Entity
@Getter
@Setter
public class MovementOutput extends Movement {

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private MovementOutputType type = MovementOutputType.MANUAL;

}