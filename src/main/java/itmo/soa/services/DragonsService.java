package itmo.soa.services;

import itmo.soa.dao.DragonsDao;
import itmo.soa.dto.DragonDto;
import itmo.soa.entity.Dragon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class DragonsService {

    @Autowired
    DragonsDao dragonsDao;

    public List<Dragon> getAllDragons(){
        return dragonsDao.getAllDragons();
    }

    public DragonDto addNewDragon(DragonDto dragonDto) throws InstantiationException {
        if (dragonDto.getId()!=null){
            throw new InstantiationException();
        }
        Dragon dragon = new Dragon(dragonDto);
        if(dragonsDao.addDragon(dragon)){
            dragonDto.setId(dragon.getId());
            return dragonDto;
        }
        else {
            throw new InstantiationException();
        }
    }

    public String[] updateDragon(){
        return new String[]{"fd", "ddd"};
    }

    public String getDragonById( String id){
        return id;
    }

    public String deleteDragonById( String id){
        return id;
    }

    //    business logic
    public String getAverageAge(){
        return "0";
    }

    public String getAgeLessThan( int id){
        return String.valueOf(id);
    }

    public String getDragonByName( String name){
        return name;
    }


}
