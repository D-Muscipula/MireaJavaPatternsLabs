package task14.controllers;

import org.springframework.web.bind.annotation.*;
import task14.objects.Building;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BuildingController {

    private final List<Building> buildingList = new ArrayList<>();

    @PostMapping("/buildings")
    public void createBuilding(@RequestBody Building building) {
        buildingList.add(building);
    }
    /*
    {
            "creationDate": "2024-05-01T12:00:00Z",
            "type": "house"
        }
     */
    @GetMapping("/buildings")
    public List<Building> getAllBuildings() {
        return buildingList;
    }

    @DeleteMapping("/buildings/{index}")
    public void deleteBuilding(@PathVariable("index") int index) {
        if (index >= 0 && index < buildingList.size()) {
            buildingList.remove(index);
        }
    }
}
