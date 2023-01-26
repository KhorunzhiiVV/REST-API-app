package ru.khorunzhii.weatherapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.khorunzhii.weatherapp.models.Sensor;
import ru.khorunzhii.weatherapp.services.SensorService;

@Component
public class SensorValidator implements Validator {

    private SensorService sensorService;

    @Autowired
    public SensorValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Sensor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor = (Sensor) target;

        if (sensorService.findByName(sensor.getName()) != null)
            errors.rejectValue("name","", "This name is already taken");
    }
}
