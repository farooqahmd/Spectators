package com.example.grpcserver.controller;

import com.example.grpcserver.entity.Spectator;
import com.example.grpcserver.service.SpectatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SpectatorController {

    @Autowired
    private SpectatorService spectatorService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Example hardcoded username/password for now
    private final String USERNAME = "admin";
    private final String PASSWORD_HASH = "$2a$10$xxxxxxxxxxxxxxxxxxxxxxxxxxxx"; // Bcrypt hash of "password"

    // Login Endpoint
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        if (USERNAME.equals(username) && passwordEncoder.matches(password, PASSWORD_HASH)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

    // Create Spectator
    @PostMapping("/spectator")
    public ResponseEntity<Spectator> createSpectator(@RequestBody Spectator spectator) {
        Spectator created = spectatorService.createSpectator(spectator);
        return ResponseEntity.ok(created);
    }

    // Get Spectator by ID
    @GetMapping("/spectator/{id}")
    public ResponseEntity<Spectator> getSpectatorById(@PathVariable Long id) {
        Optional<Spectator> spectator = spectatorService.getSpectatorById(id);
        return spectator.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Update Spectator
    @PutMapping("/spectator/{id}")
    public ResponseEntity<Spectator> updateSpectator(@PathVariable Long id, @RequestBody Spectator spectator) {
        Optional<Spectator> updated = spectatorService.updateSpectator(id, spectator);
        return updated.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Delete Spectator
    @DeleteMapping("/spectator/{id}")
    public ResponseEntity<Void> deleteSpectator(@PathVariable Long id) {
        boolean deleted = spectatorService.deleteSpectator(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
