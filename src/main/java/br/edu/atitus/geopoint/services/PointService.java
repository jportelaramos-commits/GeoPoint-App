package br.edu.atitus.geopoint.services;

import br.edu.atitus.geopoint.dtos.PointRequest;
import br.edu.atitus.geopoint.entities.PointEntity;
import br.edu.atitus.geopoint.repositories.PointRepository;

import java.math.BigDecimal;
import java.util.UUID;


public class PointService {
    private final PointRepository repository;

    public PointService(PointRepository repository) {
        this.repository = repository;
    }

    public PointEntity insert(PointRequest pointRequest) {

        //TODO VALIDAR OS DADOS
        if (pointRequest == null)
            throw new RuntimeException("Objeto nulo");

        if (pointRequest.name() == null || pointRequest.name().isBlank())
            throw new RuntimeException("Nome invalido");

        if (pointRequest.latitude() == null
                || pointRequest.latitude().compareTo(BigDecimal.valueOf(-90)) < 0
                || pointRequest.latitude().compareTo(BigDecimal.valueOf(90)) > 0)
            throw new RuntimeException("Latitude invalida - intervalo aceito: -90 a 90");


        PointEntity point = new PointEntity();

        point.setId(UUID.randomUUID());
        point.setName(pointRequest.name().trim());
        point.setDescription(pointRequest.description().trim());
        point.setLatitude(pointRequest.latitude());
        point.setLongitude(pointRequest.longitude());

        return repository.insert(point);


    }
}
