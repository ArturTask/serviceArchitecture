package itmo.soa.dao;

import itmo.soa.entity.Coordinates;
import itmo.soa.entity.Dragon;
import itmo.soa.entity.DragonCave;
import itmo.soa.enums.Color;
import itmo.soa.enums.DragonCharacter;
import itmo.soa.enums.DragonType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Deprecated
@Component
public class DragonsDao {

//    private static List<Dragon> dragons = new LinkedList<>();
//    static {
//        try {
//            dragons.add(new Dragon(1L,"snoopie", new Coordinates(1,1), "13.10.2022", 2L, Color.BLACK, DragonType.AIR, DragonCharacter.CHAOTIC, new DragonCave(1,2)));
//            dragons.add(new Dragon(2L,"pupka", new Coordinates(0,0), "01.10.2022", 2L, Color.BLACK, DragonType.AIR, DragonCharacter.CHAOTIC, new DragonCave(2,3)));
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//            throw new RuntimeException("lol ты че");
//        }
//    }
//
//    public List<Dragon> getAllDragons(){
//        return dragons;
//    }

    private static Map<Long, Dragon> dragons = new HashMap<>();
    static {
        try {
            dragons.put(1L, new Dragon(1L,"snoopie", new Coordinates(1,1), "13.10.2022", 2L, Color.BLACK, DragonType.AIR, DragonCharacter.CHAOTIC, new DragonCave(1,2)));
            dragons.put(2L, new Dragon(2L,"pupka", new Coordinates(0,0), "01.10.2022", 2L, Color.BLACK, DragonType.AIR, DragonCharacter.CHAOTIC, new DragonCave(2,3)));
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException("lol ты че");
        }
    }

    public List<Dragon> getAllDragons(){
        List<Dragon> listDragons = new LinkedList<>();
        for (Map.Entry<Long, Dragon> entry : dragons.entrySet()){
            listDragons.add(entry.getValue());
        }
        return listDragons;
    }

    public boolean addDragon(Dragon dragon){
        try {
            dragon.setId((long) (dragons.size()+1));
            dragons.put((long) (dragons.size()+1), dragon);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Dragon getDragonById(Long id){
        return dragons.get(id);
    }

}
