package com.hw4.app.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class MyValue {

    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;

    public MyValue(BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close) {
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
    }
}
