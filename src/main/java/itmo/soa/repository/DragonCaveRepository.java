package itmo.soa.repository;

import itmo.soa.entity.DragonCave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface DragonCaveRepository extends JpaRepository<DragonCave, Long> {

}
