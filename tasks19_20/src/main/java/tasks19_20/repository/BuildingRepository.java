package tasks19_20.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tasks19_20.objects.Building;

import java.util.Date;
import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
    List<Building> findAllByCreationDate(Date creationDate);

    List<Building> findAllByType(String type);

}
