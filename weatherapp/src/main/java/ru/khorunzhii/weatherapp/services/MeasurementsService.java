package ru.khorunzhii.weatherapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.khorunzhii.weatherapp.models.Measurement;
import ru.khorunzhii.weatherapp.repositories.MeasurementsRepository;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementsService {

    private final MeasurementsRepository measurementsRepository;
    private final SensorsService sensorsService;

    @Autowired
    public MeasurementsService(MeasurementsRepository measurementsRepository, SensorsService sensorsService) {
        this.measurementsRepository = measurementsRepository;
        this.sensorsService = sensorsService;
    }

    public List<Measurement> findAll(){
        System.out.println("FIND ALL!!");
        return measurementsRepository.findAll();
    }

    public int calculateRainyDays(){
        return measurementsRepository.findByRainingEquals(true).size();
    }

    @Transactional
    public void save(Measurement measurement){
        measurement.setSensor(sensorsService.findByName(measurement.getSensor().getName()));
        measurement.setReceivedAt(new Date());
        measurementsRepository.save(measurement);
    }
}
