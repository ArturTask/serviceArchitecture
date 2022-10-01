package itmo.soa;

import itmo.soa.entity.Coordinates;
import itmo.soa.entity.Dragon;
import itmo.soa.entity.DragonCave;
import itmo.soa.enums.Color;
import itmo.soa.enums.DragonCharacter;
import itmo.soa.enums.DragonType;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class test {
    public static void main(String[] args) {

//        LocalDateTime now = LocalDateTime.now();
//        ZonedDateTime europeDateTime = now.atZone(ZoneId.of("Europe/Kaliningrad"));
//        System.out.println(europeDateTime);

//        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd MMM uuuu HH:mm");
//        String date = "2016-08-22 14:30";
//        LocalDateTime ldt = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("dd MMM uuuu HH:mm"));
//        System.out.println("LocalDateTime : " + format.format(ldt));
//        ZonedDateTime parisDateTime = ldt.atZone(ZoneId.of("Europe/Moscow"));
//        System.out.println("ZonedDateTime : " + format.format(parisDateTime));
        try {
            Dragon d = new Dragon(-1L, "dd", new Coordinates(),"", 2, Color.BLACK, DragonType.AIR, DragonCharacter.CHAOTIC, new DragonCave());
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println();

    }
}
