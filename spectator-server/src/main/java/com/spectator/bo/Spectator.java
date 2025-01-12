package com.spectator.bo;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Spectator {

    @Id
    private int id;

    @Column(nullable = false)
    private String sname;

    @Column(nullable = false)
    private boolean male;

    @Column(nullable = false)
    private boolean haspass;
}

