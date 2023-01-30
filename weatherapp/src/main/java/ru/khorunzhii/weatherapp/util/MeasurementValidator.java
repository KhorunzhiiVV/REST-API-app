package ru.khorunzhii.weatherapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.khorunzhii.weatherapp.models.Measurement;
import ru.khorunzhii.weatherapp.services.SensorsService;

@Component
public class MeasurementValidator implements Validator {

    private SensorsService sensorsService;

    @Autowired
    public MeasurementValidator(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Measurement.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Measurement measurement = (Measurement) target;
        if (sensorsService.findByName(measurement.getSensor().getName()) == null)
            errors.rejectValue("sensor","","No sensor found in DB. Please register sensor before adding measurements.");
    }
}
