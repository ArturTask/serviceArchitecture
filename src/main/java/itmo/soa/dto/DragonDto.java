package itmo.soa.dto;

import itmo.soa.entity.Coordinates;
import itmo.soa.entity.Dragon;
import itmo.soa.entity.DragonCave;
import itmo.soa.enums.Color;
import itmo.soa.enums.DragonCharacter;
import itmo.soa.enums.DragonType;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Data
@NoArgsConstructor
public class DragonDto {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private Long id;
    private String name;
    private Coordinates coordinates;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private java.time.ZonedDateTime creationDate;
    private Long age;
    private Color color;
    private DragonType type;
    private DragonCharacter character;
    private DragonCave cave;

    public DragonDto(Long id, String name, Coordinates coordinates, String creationDate, long age, String color, String type, String character, DragonCave cave) throws InstantiationException {

        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        setCreationDate(creationDate);
        this.age = age;
        this.color = Color.valueOf(color);
        this.type = DragonType.valueOf(type);
        this.character = DragonCharacter.valueOf(character);
        this.cave = cave;
    }

    public DragonDto(String name, Coordinates coordinates, String creationDate, long age, Color color, DragonType type, DragonCharacter character, DragonCave cave) {
        this.name = name;
        this.coordinates = coordinates;
        setCreationDate(creationDate);
        this.age = age;
        this.color = color;
        this.type = type;
        this.character = character;
        this.cave = cave;
    }

    public DragonDto(Dragon dragon) {
        this.id = dragon.getId();
        this.name = dragon.getName();
        this.coordinates = dragon.getCoordinates();
        setCreationDate(dragon.getCreationDate());
        this.age = dragon.getAge();
        this.color = dragon.getColor();
        this.type = dragon.getType();
        this.character = dragon.getCharacter();
        this.cave = dragon.getCave();
    }

    public String getCreationDate() {
        return FORMAT.format(this.creationDate);
    }

    public void setCreationDate(String creationDateUsingFormat) throws DateTimeParseException {
        LocalDateTime ldt = LocalDate.parse(creationDateUsingFormat, FORMAT).atStartOfDay();
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
            LocalDateTime ldt = LocalDate.parse(creationDateUsingFormat, FORMAT).atStartOfDay();
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean checkInputValues(Long id, String name, Coordinates coordinates, String creationDate, long age, Color color, DragonType type, DragonCharacter character, DragonCave cave) {
        if (id <= 0 || name == null || name.equals("") || age <= 0) {
            return false;
        }
        return checkCreationDate(creationDate);
    }

}


