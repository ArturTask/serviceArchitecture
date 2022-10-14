package itmo.soa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@AllArgsConstructor
public class Coordinates {
    private long x; //Поле не может быть null
    private long y; //Поле не может быть null
}

