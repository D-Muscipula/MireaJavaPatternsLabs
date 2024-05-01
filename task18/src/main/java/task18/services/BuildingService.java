package task18.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task18.objects.Address;
import task18.objects.Building;
import task18.objects.BuildingDTO;
import task18.repository.AddressRepository;
import task18.repository.BuildingRepository;

import java.util.Date;
import java.util.List;

@Service
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
        buildingRepository.save(building);
    }

    public void deleteBuilding(Long id) {
        buildingRepository.deleteById(id);
    }

    public Address getAddressByBuilding(Long buildingId) {
        Building building = buildingRepository.findById(buildingId).orElse(null);
        return (building != null) ? building.getAddress() : null;
    }

    public List<Building> getBuildings() {
        return buildingRepository.findAll();
    }

    public List<Building> getBuildingsByCreationDate(Date creationDate) {
        return buildingRepository.findAllByCreationDate(creationDate);
    }

    public List<Building> getBuildingsByType(String type) {
        return buildingRepository.findAllByType(type);
    }

}
