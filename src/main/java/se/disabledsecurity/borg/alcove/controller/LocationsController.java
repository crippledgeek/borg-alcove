package se.disabledsecurity.borg.alcove.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import se.disabledsecurity.borg.alcove.model.internal.Locations;
import se.disabledsecurity.borg.alcove.service.LocationService;


@RequestMapping("api")
@RestController
public class LocationsController {

    private final LocationService locationService;

    public LocationsController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/locations")
    public Locations uploadLocations(@RequestParam("locations") MultipartFile file) {
        return locationService.handleFileUpload(file);
    }
}
