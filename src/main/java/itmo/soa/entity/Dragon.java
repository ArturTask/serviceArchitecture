package itmo.soa.entity;

import itmo.soa.enums.Color;
import itmo.soa.enums.DragonCharacter;
import itmo.soa.enums.DragonType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Data
public class Dragon {
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd MMM uuuu HH:mm");

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private final Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long age; //Значение поля должно быть больше 0
    private Color color; //Поле не может быть null
    private DragonType type; //Поле не может быть null
    private DragonCharacter character; //Поле может быть null
    private DragonCave cave; //Поле может быть null

    public Dragon(Long id, String name, Coordinates coordinates, String creationDate, long age, Color color, DragonType type, DragonCharacter character, DragonCave cave) throws InstantiationException {

        if (!checkInputValues(id, name, coordinates, creationDate, age, color, type, character, cave)) {
            throw new InstantiationException("Dragon cannot be instantiated : wrong arguments");
        }
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        setCreationDate(creationDate);
        this.age = age;
        this.color = color;
        this.type = type;
        this.character = character;
        this.cave = cave;
    }

    public String getCreationDate() {
        return FORMAT.format(this.creationDate);
    }

    public void setCreationDate(String creationDateUsingFormat) throws DateTimeParseException {
        LocalDateTime ldt = LocalDateTime.parse(creationDateUsingFormat, FORMAT);
        this.creationDate = ldt.atZone(ZoneId.of("Europe/Moscow"));
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

    private boolean checkCreationDate(String creationDateUsingFormat) {
        try {
            LocalDateTime ldt = LocalDateTime.parse(creationDateUsingFormat, FORMAT);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean checkInputValues(Long id, String name, Coordinates coordinates, String creationDate, long age, Color color, DragonType type, DragonCharacter character, DragonCave cave) {
        if (id <= 0 || name.equals("") || age <= 0) {
            return false;
        }
        return checkCreationDate(creationDate);
    }

}

