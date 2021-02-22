package com.hw4.app.repository;

import com.hw4.app.model.DataForOneMinute;
import com.hw4.app.model.MyDate;
import com.hw4.app.model.MyTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MyTimeRepo extends JpaRepository <MyTime, UUID> {
}
