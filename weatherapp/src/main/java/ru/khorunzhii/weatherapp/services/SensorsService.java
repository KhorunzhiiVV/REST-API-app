package ru.khorunzhii.weatherapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.khorunzhii.weatherapp.models.Sensor;
import ru.khorunzhii.weatherapp.repositories.SensorsRepository;

@Service
@Transactional(readOnly = true)
public class SensorsService {
    private SensorsRepository sensorsRepository;

    @Autowired
    public SensorsService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

    public Sensor findByName(String name) {
        return sensorsRepository.findByName(name);
    }

    @Transactional
    public void save(Sensor sensor){
        sensorsRepository.save(sensor);
    }
}
