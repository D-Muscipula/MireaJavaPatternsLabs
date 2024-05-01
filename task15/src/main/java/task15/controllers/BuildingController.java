package task15.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task15.objects.Building;
import task15.services.BuildingService;

import java.util.List;

@RestController
public class BuildingController {

    private final BuildingService buildingService;

    @Autowired public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }


    @PostMapping("/buildings")
    public void createBuilding(@RequestBody Building building) {
        buildingService.addBuilding(building);
    }
    /*
    {
            "creationDate": "2024-05-01T12:00:00Z",
            "type": "house"
        }
     */
    @GetMapping("/buildings")
    public List<Building> getAllBuildings() {
        return buildingService.getBuildings();
    }

    @DeleteMapping("/buildings/{index}")
    public void deleteBuilding(@PathVariable("index") long index) {
       buildingService.deleteBuilding(index);
    }
}
