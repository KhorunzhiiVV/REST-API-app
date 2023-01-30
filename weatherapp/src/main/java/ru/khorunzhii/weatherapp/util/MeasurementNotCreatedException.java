package ru.khorunzhii.weatherapp.util;

public class MeasurementNotCreatedException extends RuntimeException{
    public MeasurementNotCreatedException(String message){
        super(message);
    }
}
