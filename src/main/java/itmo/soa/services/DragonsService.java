package itmo.soa.services;

import itmo.soa.dto.AgeDto;
import itmo.soa.dto.AllDragonsDto;
import itmo.soa.entity.DragonDbo;
import itmo.soa.dto.DragonDto;
import itmo.soa.entity.Dragon;
import itmo.soa.repository.DragonCaveRepository;
import itmo.soa.repository.DragonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class DragonsService {

    @Autowired
    private DragonRepository dragonRepository;

    @Autowired
    private DragonCaveRepository caveRepository;

    public List<DragonDto> getAllDragons(){
        Iterable<DragonDbo> all = dragonRepository.findAll();
        List<DragonDto> dragonLinkedList = new LinkedList<>();
        for (DragonDbo dragonDbo : all) {
            dragonLinkedList.add(new DragonDto(dragonDbo));
        }
        return dragonLinkedList;
    }

    public DragonDto addNewDragon(DragonDto dragonDto) throws InstantiationException {
        if (dragonDto.getId()!=null){
            throw new InstantiationException();
        }
        Dragon dragon = new Dragon(dragonDto); // if something is wrong throw new InstantiationException()
        DragonDbo dragonDbo = new DragonDbo(dragon);
        caveRepository.save(dragonDbo.getCave());
        dragonRepository.save(dragonDbo);
        dragonRepository.flush();
        dragonDto.setId(dragonDbo.getId());
        return dragonDto;
    }

    public DragonDto updateDragon(DragonDto dragonDto) throws InstantiationException {

        Optional<DragonDbo> dragonDbo = dragonRepository.findById(dragonDto.getId());
        if (!dragonDbo.isPresent()){
            throw new NullPointerException();
        }
        Dragon dragon = new Dragon(dragonDto);
        dragonRepository.save(dragonDbo.get().update(dragon));
        return dragonDto;
    }

    public DragonDto getDragonById( String id) throws IllegalArgumentException, NullPointerException{
        try {
            Optional<DragonDbo> dragon = dragonRepository.findById(Long.parseLong(id));
            if (!dragon.isPresent()){
                throw new NullPointerException();
            }
            return new DragonDto(dragon.get());
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public void deleteDragonById( String id) throws NullPointerException, IllegalArgumentException{
        try {
            Optional<DragonDbo> dragon = dragonRepository.findById(Long.parseLong(id));
            if (!dragon.isPresent()){
                throw new NullPointerException();
            }
            dragonRepository.deleteById(Long.parseLong(id));
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    //    business logic
    public AgeDto getAverageAge(){
        List<DragonDbo> allDragons = dragonRepository.findAll();
        if (allDragons.isEmpty()){
            return new AgeDto((float) 0.0);
        }
        Long summAge = 0L;
        for (DragonDbo dragonDbo : allDragons) {
            summAge += dragonDbo.getAge();
        }
        return new AgeDto((float) (summAge/allDragons.size()));
    }

    public List<DragonDto> getDragonsAgeLessThan(String age) throws NumberFormatException{
        long lessThanAge = Long.parseLong(age);
        List<DragonDbo> allDragons = dragonRepository.findAll();
        if (allDragons.isEmpty()){
            return new LinkedList<>(); // empty list
        }

        List<DragonDto> currentDragons = new LinkedList<>();
        for (DragonDbo dragonDbo : allDragons) {
            if (dragonDbo.getAge() < lessThanAge){
                currentDragons.add(new DragonDto(dragonDbo));
            }
        }
        return currentDragons;
    }

    public String getDragonByName( String name){
        return name;
    }


}
