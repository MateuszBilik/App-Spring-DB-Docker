package com.hw4.app.file;

import com.hw4.app.model.DataForOneMinute;
import com.hw4.app.model.MyDate;
import com.hw4.app.model.MyTime;
import com.hw4.app.model.MyValue;
import com.hw4.app.repository.DataForOneMinuteRepository;
import com.hw4.app.repository.MyDateRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;

@Slf4j
@Service
public class UploadToDB {

    private final DataForOneMinuteRepository dataRepo;
    private final MyDateRepo myDateRepo;
    private final FileLoader fileLoader;

    public UploadToDB(DataForOneMinuteRepository dataRepo, MyDateRepo myDateRepo, FileLoader fileLoader) {
        this.dataRepo = dataRepo;
        this.myDateRepo = myDateRepo;
        this.fileLoader = fileLoader;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void uploadDateToDB() {
        log.info("Start load file to DB");
        BufferedReader myFile = fileLoader.loadFile();
        String line;
        try {
            boolean firstLineToSkip = true;
            while ((line = myFile.readLine()) != null) {
                if (firstLineToSkip) {
                    firstLineToSkip = false;
                } else {
                    String[] listSeparatedData = line.split(",");
                    String[] date = listSeparatedData[0].split("\\.");
                    String[] time = listSeparatedData[1].split(":");

                    DataForOneMinute data = new DataForOneMinute(     //YYYY.MM.DD,HH:MM,OPEN,HIGH,LOW,CLOSE,VOLUME
                            new MyDate(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])),
                            new MyTime(Integer.parseInt(time[0]), Integer.parseInt(time[1])),
                            new MyValue(
                                    BigDecimal.valueOf(Double.parseDouble(listSeparatedData[2])),
                                    BigDecimal.valueOf(Double.parseDouble(listSeparatedData[3])),
                                    BigDecimal.valueOf(Double.parseDouble(listSeparatedData[4])),
                                    BigDecimal.valueOf(Double.parseDouble(listSeparatedData[5]))));
                    addToDB(data);
                }
            }
        } catch (IOException e) {
            log.error("File not found" + e.getMessage());
        }
        log.info("File is loaded to DB");
    }

    void addToDB(DataForOneMinute data) {
        Optional<MyDate> myDateOpt = myDateRepo.findByYearAndMonthAndDay(data.getDate().getYear(), data.getDate().getMonth(), data.getDate().getDay());
        if (myDateOpt.isEmpty()) {
            dataRepo.save(data);
            log.info("Data for day {}", data.getDate().toString());
        } else {
            data.setDate(myDateOpt.get());
            dataRepo.save(data);
        }
    }
}
