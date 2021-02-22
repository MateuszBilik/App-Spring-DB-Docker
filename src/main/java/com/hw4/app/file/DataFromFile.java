package com.hw4.app.file;

import com.hw4.app.model.DataForOneMinute;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataFromFile {

    private final FileLoader fileLoader;
    private final Converter converter;

    public DataFromFile(FileLoader fileLoader, Converter converter) {
        this.fileLoader = fileLoader;
        this.converter = converter;
    }

    public List<DataForOneMinute> getData() {
        return converter.createListWithDataForOneMinutesLines(fileLoader.loadFile());
    }



}
