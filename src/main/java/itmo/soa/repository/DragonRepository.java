package itmo.soa.repository;

import itmo.soa.entity.DragonDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DragonRepository extends JpaRepository<DragonDbo, Long> {
    DragonDbo findByName(String name);
}
