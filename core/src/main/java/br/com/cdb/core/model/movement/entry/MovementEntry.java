package br.com.cdb.core.model.movement.entry;

import br.com.cdb.core.model.movement.Movement;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "movement_entry")
@Entity
@Getter
@Setter
public class MovementEntry extends Movement {

    @Column(name = "discount_percentage", precision = 5, scale = 2)
    private BigDecimal discountPercentage;

    @Column(name = "cost_per_unit", precision = 19, scale = 2)
    private BigDecimal costPerUnit;

}