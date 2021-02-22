package com.hw4.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class DataForOneMinute {

    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MyDate date;

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MyTime time;

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MyValue value;

    public DataForOneMinute(MyDate date, MyTime time, MyValue value) {
        this.date = date;
        this.time = time;
        this.value = value;
    }
}
