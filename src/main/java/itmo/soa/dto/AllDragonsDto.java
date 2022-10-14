package itmo.soa.dto;

import itmo.soa.entity.Dragon;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AllDragonsDto {

    private List<DragonDto> dragons;
}
