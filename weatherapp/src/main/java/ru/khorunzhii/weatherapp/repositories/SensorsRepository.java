package ru.khorunzhii.weatherapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.khorunzhii.weatherapp.models.Sensor;

@Repository
public interface SensorsRepository extends JpaRepository<Sensor, Integer> {
    public Sensor findByName(String name);
}
