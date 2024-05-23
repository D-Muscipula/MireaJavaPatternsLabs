package tasks23_24.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tasks23_24.objects.Address;
import tasks23_24.objects.Building;
import tasks23_24.objects.BuildingDTO;
import tasks23_24.repository.AddressRepository;
import tasks23_24.repository.BuildingRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuildingServiceTest {
    @Mock
    private BuildingRepository buildingRepository;

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private BuildingService buildingService;

    @Test
    void addBuilding() {
        BuildingDTO buildingDTO = new BuildingDTO();
        buildingDTO.setCreationDate(new Date());
        buildingDTO.setAddressId(1L);
        buildingDTO.setType("Office");

        Address address = new Address();
        address.setId(1L);

        when(addressRepository.getReferenceById(1L)).thenReturn(address);

        buildingService.addBuilding(buildingDTO);

        verify(emailService).sendEmail("temp_s_r@mail.ru", "add building", buildingDTO.toString());
        verify(buildingRepository).save(any(Building.class));
    }

    @Test
    void deleteBuilding() {
        buildingService.deleteBuilding(1L);
        verify(buildingRepository).deleteById(1L);
    }

    @Test
    void getAddressByBuilding() {
        Building building = new Building();
        Address address = new Address();
        building.setAddress(address);

        when(buildingRepository.findById(1L)).thenReturn(Optional.of(building));

        assertEquals(address, buildingService.getAddressByBuilding(1L));
    }

    @Test
    void getBuildings() {
        List<Building> buildings = new ArrayList<>();
        buildings.add(new Building());
        buildings.add(new Building());

        when(buildingRepository.findAll()).thenReturn(buildings);

        assertEquals(buildings, buildingService.getBuildings());
    }

    @Test
    void getBuildingsByCreationDate() {
        Date creationDate = new Date();
        List<Building> buildings = new ArrayList<>();
        buildings.add(new Building());
        buildings.add(new Building());

        when(buildingRepository.findAllByCreationDate(creationDate)).thenReturn(buildings);

        assertEquals(buildings, buildingService.getBuildingsByCreationDate(creationDate));
    }

    @Test
    void getBuildingsByType() {
        String type = "Office";
        List<Building> buildings = new ArrayList<>();
        buildings.add(new Building());
        buildings.add(new Building());

        when(buildingRepository.findAllByType(type)).thenReturn(buildings);

        assertEquals(buildings, buildingService.getBuildingsByType(type));
    }
}
