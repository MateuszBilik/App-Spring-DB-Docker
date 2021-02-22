package com.hw4.app.repository;

import com.hw4.app.model.DataForOneMinute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DataForOneMinuteRepository extends JpaRepository <DataForOneMinute, UUID> {
}
