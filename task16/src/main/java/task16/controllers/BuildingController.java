package task16.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import task16.objects.Address;
import task16.objects.Building;
import task16.objects.BuildingDTO;
import task16.services.BuildingService;

import java.util.Date;
import java.util.List;

@RestController
public class BuildingController {

    private final BuildingService buildingService;

    @Autowired public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }


    @PostMapping("/buildings")
    public void createBuilding(@RequestBody BuildingDTO building) {
        buildingService.addBuilding(building);
    }
    /*
    {
            "creationDate": "2024-05-01T12:00:00Z",
            "type": "house",
            "address_id" : "1"
        }
     */
    @GetMapping("/buildings")
    public List<Building> getAllBuildings() {
        return buildingService.getBuildings();
    }
    @GetMapping(value = "/buildings/{buildingId}/address")
    public @ResponseBody Address getBuildingAddress(@PathVariable("buildingId")
                                         Long buildingId){
        return buildingService.getAddressByBuilding(buildingId);
    }

    @GetMapping("/buildings/creationDate")
    public List<Building> getBuildingsByCreationDate(@RequestParam("creationDate") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date creationDate) {
        return buildingService.getBuildingsByCreationDate(creationDate);
    }

    @GetMapping("/buildings/type")
    public List<Building> getBuildingsByType(@RequestParam("type") String type) {
        return buildingService.getBuildingsByType(type);
    }

    @DeleteMapping("/buildings/{index}")
    public void deleteBuilding(@PathVariable("index") long index) {
       buildingService.deleteBuilding(index);
    }
}
