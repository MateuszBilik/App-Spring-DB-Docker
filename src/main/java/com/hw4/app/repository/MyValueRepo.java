package com.hw4.app.repository;

import com.hw4.app.model.DataForOneMinute;
import com.hw4.app.model.MyValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MyValueRepo extends JpaRepository <MyValue, UUID> {
}
