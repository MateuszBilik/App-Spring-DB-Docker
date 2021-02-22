package com.hw4.app.service;

import com.hw4.app.file.DataFromFile;
import com.hw4.app.methods.MethodGet;
import com.hw4.app.model.DataForOneMinute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
public class GetService {

    MethodGet methodGet;
    DataFromFile dataFromFile;

    public GetService() {
    }

    @Autowired
    public GetService(MethodGet methodGet, DataFromFile dataFromFile) {
        this.methodGet = methodGet;
        this.dataFromFile = dataFromFile;
    }

    public String doGetForMinute(int year, int month, int day, int hour, int minute) {
        List<DataForOneMinute> listOfData = dataFromFile.getData();
         return String.valueOf(MethodGet.getForMinute(listOfData, day, month, year, hour, minute));
    }

    public String doGetForHour(int year, int month, int day, int hour) {
        List<DataForOneMinute> listOfData = dataFromFile.getData();
        return String.valueOf(MethodGet.getForHour(listOfData, day, month, year, hour));
    }

    public String doGetForDay(int year, int month, int day) {
        List<DataForOneMinute> listOfData = dataFromFile.getData();
        return String.valueOf(MethodGet.getForDay(listOfData, day, month, year));
    }

    public String doGetForMinuteWithType(String type, int year, int month, int day, int hour, int minute) {
        List<DataForOneMinute> listOfData = dataFromFile.getData();
        return String.valueOf(MethodGet.getTypeForMinute(listOfData, day, month, year, hour, minute, type));
    }

    public String doGetForHourWithType(String type, int year, int month, int day, int hour) {
        List<DataForOneMinute> listOfData = dataFromFile.getData();
        return String.valueOf(MethodGet.getTypeForHour(listOfData, day, month, year, hour, type));
    }

    public String doGetForDayWithType(String type, int year, int month, int day) {
        List<DataForOneMinute> listOfData = dataFromFile.getData();
        return String.valueOf(MethodGet.getTypeForDay(listOfData, day, month, year, type));
    }
}
