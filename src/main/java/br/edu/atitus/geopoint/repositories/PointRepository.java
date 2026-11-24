package br.edu.atitus.geopoint.repositories;

import br.edu.atitus.geopoint.entities.PointEntity;
import org.springframework.jdbc.core.JdbcTemplate;

public class PointRepository {

    //Dependencia de classe
    private final JdbcTemplate jdbcTemplate;

//injecao de dependecia via construtor
    public PointRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }
    public PointEntity insert(PointEntity point) {

        String sql = """
        INSERT INTO points (
            id, name, description, latitude, longitude
        )
        VALUES (?, ?, ?, ?, ?)
        """;

        jdbcTemplate.update(
                sql,
                point.getId(),
                point.getName(),
                point.getDescription(),
                point.getLatitude(),
                point.getLongitude()
        );

        return point;
    }
}
