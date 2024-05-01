package tasks19_20.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tasks19_20.objects.Address;
import tasks19_20.objects.Building;
import tasks19_20.objects.BuildingDTO;
import tasks19_20.repository.AddressRepository;
import tasks19_20.repository.BuildingRepository;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BuildingService {
    private final BuildingRepository buildingRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public BuildingService(BuildingRepository buildingRepository, AddressRepository addressRepository) {
        this.buildingRepository = buildingRepository;
        this.addressRepository = addressRepository;
    }

    public void addBuilding(BuildingDTO buildingDto) {
        Building building = new Building();
        building.setCreationDate(buildingDto.getCreationDate());
        Address address = addressRepository.getReferenceById(buildingDto.getAddressId());
        building.setAddress(address);
        building.setType(buildingDto.getType());
        log.info("add building " + building);
        buildingRepository.save(building);
    }

    public void deleteBuilding(Long id) {
        log.info("delete building " + id);
        buildingRepository.deleteById(id);
    }

    public Address getAddressByBuilding(Long buildingId) {
        log.info("get address by building " + buildingId);
        Building building = buildingRepository.findById(buildingId).orElse(null);
        return (building != null) ? building.getAddress() : null;
    }

    public List<Building> getBuildings() {
        log.info("get buildings");
        return buildingRepository.findAll();
    }

    public List<Building> getBuildingsByCreationDate(Date creationDate) {
        log.info("get buildings by creation date " + creationDate);
        return buildingRepository.findAllByCreationDate(creationDate);
    }

    public List<Building> getBuildingsByType(String type) {
        log.info("get buildings by type " + type);
        return buildingRepository.findAllByType(type);
    }

}
