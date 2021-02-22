package com.hw4.app.repository;

import com.hw4.app.model.DataForOneMinute;
import com.hw4.app.model.MyDate;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;
import java.util.UUID;

public interface MyDateRepo extends JpaRepository <MyDate, UUID> {

    Optional<MyDate> findByYearAndMonthAndDay(Integer year, Integer month, Integer day);
}
