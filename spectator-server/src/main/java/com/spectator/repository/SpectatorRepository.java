package com.spectator.repository;

import com.spectator.bo.Spectator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpectatorRepository extends JpaRepository<Spectator, Integer> {
}

