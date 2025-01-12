package com.spectator.bo;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Entry {

    @Id
    @ManyToOne
    @JoinColumn(name = "spectatorid")
    private Spectator spectator;

    @Id
    @ManyToOne
    @JoinColumn(name = "matchid")
    private Match match;

    @Column(nullable = false)
    private LocalDateTime timestamp;
}

