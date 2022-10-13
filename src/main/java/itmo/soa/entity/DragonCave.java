package itmo.soa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DragonCave {
    private final long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным
    private Integer numberOfTreasures; //Поле не может быть null, Значение поля должно быть больше 0
}

