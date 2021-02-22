package com.hw4.app.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;

@Component
@Slf4j
public class FileLoader {

    BufferedReader bufferedReader;

    public FileLoader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public BufferedReader loadFile() {
        BufferedReader myFile = null;
        boolean fileExist = true;

        while (fileExist) {
            myFile = bufferedReader;
            fileExist = false;
            log.info("File found.");
        }
        return myFile;
    }
}
