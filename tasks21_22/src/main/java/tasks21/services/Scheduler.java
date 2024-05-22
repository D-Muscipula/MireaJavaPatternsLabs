package tasks21.services;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tasks21.objects.Address;
import tasks21.objects.Building;
import tasks21.repository.AddressRepository;
import tasks21.repository.BuildingRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

@AllArgsConstructor
@Service
@Log4j2
@ManagedResource(objectName = "services:type=Scheduler")
public class Scheduler {
    private final AddressRepository addressRepository;
    private final BuildingRepository buildingRepository;

    @ManagedOperation
    @Scheduled(cron = "0 */30 * * * *")
    public void clearAndCreateFiles() throws IOException {
        List<Address> addresses = addressRepository.findAll();
        List<Building> buildings = buildingRepository.findAll();
        File entities = new File("tasks21_22/src/main/resources/entities");
        log.info("Очистка и создание");
        if (!entities.exists() || !entities.isDirectory()) {
            if (!entities.mkdirs()) {
                log.error("Не удалось создать каталог entities");
                return;
            }
        }

        File[] files = entities.listFiles();
        if (files != null) {

            for (File f : files) {
                if (f.isFile()) {
                    f.delete();
                }
            }
        } else {
            log.error("Массив файлов равен null");
            return;
        }

        for (Address address : addresses) {
            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream("tasks21_22/src/main/resources/entities/address" + address.getId() + ".txt"),
                    StandardCharsets.UTF_8);
            writer.write(address.toString());
            writer.close();
        }
        for (Building building : buildings) {
            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream("tasks21_22/src/main/resources/entities/building" + building.getId() + ".txt"),
                    StandardCharsets.UTF_8);
            writer.write(building.toString());
            writer.close();
        }
        log.info("Конец");
    }

}
