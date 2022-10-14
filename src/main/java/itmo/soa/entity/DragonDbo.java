package itmo.soa.entity;

import itmo.soa.entity.Coordinates;
import itmo.soa.entity.Dragon;
import itmo.soa.entity.DragonCave;
import itmo.soa.enums.Color;
import itmo.soa.enums.DragonCharacter;
import itmo.soa.enums.DragonType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@Entity
@Table(name = "dragon")
public class DragonDbo { // entity for database
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @Column(name = "name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @Column(name = "X") //coordinates
    private Long x;
    @Column(name = "Y") //coordinates
    private Long y;
    @Column(name = "creation_date")
    private String creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @Column(name = "age")
    private Long age; //Значение поля должно быть больше 0
    @Column(name = "color", nullable = false)
    @Enumerated(EnumType.STRING)
    private Color color; //Поле не может быть null
    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private DragonType type; //Поле не может быть null
    @Column(name = "character", nullable = true)
    @Enumerated(EnumType.STRING)
    private DragonCharacter character; //Поле может быть null
    @OneToOne(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
    @JoinColumn(name = "cave_id")
    private DragonCave cave; //Поле может быть null

    public DragonDbo(String name, Long x, Long y, String creationDate, Long age, Color color, DragonType type, DragonCharacter character, DragonCave cave) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.creationDate = creationDate;
        this.age = age;
        this.color = color;
        this.type = type;
        this.character = character;
        this.cave = cave;
    }

    public DragonDbo(Dragon dragon) {
        this.name = dragon.getName();
        this.x = dragon.getCoordinates().getX();
        this.y = dragon.getCoordinates().getY();
        this.creationDate = dragon.getCreationDate();
        this.age = dragon.getAge();
        this.color = dragon.getColor();
        this.type = dragon.getType();
        this.character = dragon.getCharacter();
        this.cave = dragon.getCave();
    }



    public boolean setAge(long age) {
        if (age > 0) {
            this.age = age;
            return true;
        }
        return false;
    }

    public boolean setName(String name) {
        if (!name.equals("")) {
            this.name = name;
            return true;
        }
        return false;
    }

    public DragonDbo update(Dragon dragon){
        this.name = dragon.getName();
        this.x = dragon.getCoordinates().getX();
        this.y = dragon.getCoordinates().getY();
        this.creationDate = dragon.getCreationDate();
        this.age = dragon.getAge();
        this.color = dragon.getColor();
        this.type = dragon.getType();
        this.character = dragon.getCharacter();
        this.cave = dragon.getCave();
        return this;
    }


}


