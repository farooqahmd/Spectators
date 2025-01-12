package com.spectator.bo;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Match {

    @Id
    private int id;

    @Column(nullable = false)
    private LocalDate mdate;

    @Column(nullable = false)
    private LocalTime startsat;

    @Column(precision = 10, scale = 2)
    private double ticketprice;

    @Enumerated(EnumType.STRING)
    private MatchType mtype;
}

