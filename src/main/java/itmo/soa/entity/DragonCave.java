package itmo.soa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cave")
public class DragonCave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным
    @Column(name = "treasures")
    private Integer numberOfTreasures; //Поле не может быть null, Значение поля должно быть больше 0

    public DragonCave(Integer numberOfTreasures) {
        this.numberOfTreasures = numberOfTreasures;
    }
}

