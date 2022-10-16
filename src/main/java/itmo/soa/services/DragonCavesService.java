package itmo.soa.services;

import itmo.soa.dto.DragonCaveDto;
import itmo.soa.dto.DragonDto;
import itmo.soa.entity.DragonCave;
import itmo.soa.entity.DragonDbo;
import itmo.soa.repository.DragonCaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class DragonCavesService {

    @Autowired
    private DragonCaveRepository caveRepository;

    public List<DragonCaveDto> getCaves(){
        List<DragonCave> allCaves = caveRepository.findAll();
        List<DragonCaveDto> dragonCaves = new LinkedList<>();
        for (DragonCave dragonCave : allCaves) {
            dragonCaves.add(new DragonCaveDto(dragonCave));
        }
        return dragonCaves;
    }
}
