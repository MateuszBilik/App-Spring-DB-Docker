package com.hw4.app.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Configuration
public class FileConfig {

    @Bean
    public BufferedReader getFile (@Value("${file.name}") String inputText) throws FileNotFoundException {
        return new BufferedReader(new FileReader(inputText));
    }
}
