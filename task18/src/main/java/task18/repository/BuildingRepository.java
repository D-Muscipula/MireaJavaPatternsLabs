package task18.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task18.objects.Building;

import java.util.Date;
import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
    List<Building> findAllByCreationDate(Date creationDate);

    List<Building> findAllByType(String type);

}
