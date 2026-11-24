package br.edu.atitus.geopoint.controllers;

import br.edu.atitus.geopoint.dtos.PointRequest;
import br.edu.atitus.geopoint.entities.PointEntity;
import br.edu.atitus.geopoint.services.PointService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/api/points")
@CrossOrigin(origins = "*")

public class PointController {
    private final PointService service;

    public PointController(PointService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PointEntity> insertPoint(
            @RequestBody PointRequest pointRequest) {
        PointEntity point = service.insert(pointRequest);
        return ResponseEntity.status(201).body(point);

    }

}
