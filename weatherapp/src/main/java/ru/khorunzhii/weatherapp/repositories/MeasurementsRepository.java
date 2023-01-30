package ru.khorunzhii.weatherapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.khorunzhii.weatherapp.models.Measurement;

import java.util.List;

@Repository
public interface MeasurementsRepository extends JpaRepository<Measurement, Integer> {
    public List<Measurement> findByRainingEquals(boolean isRaining);
}
