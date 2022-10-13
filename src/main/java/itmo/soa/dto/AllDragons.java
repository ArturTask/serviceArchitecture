package itmo.soa.dto;

import itmo.soa.entity.Dragon;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AllDragons {

    private List<Dragon> dragons;
}
