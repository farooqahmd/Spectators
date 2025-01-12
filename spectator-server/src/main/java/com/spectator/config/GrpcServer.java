package com.spectator.config;

import com.spectator.service.SpectatorServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class GrpcServer {

    private final SpectatorServiceImpl spectatorService;
    private Server server;

    public GrpcServer(SpectatorServiceImpl spectatorService) {
        this.spectatorService = spectatorService;
    }

    @PostConstruct
    public void startServer() {
        try {
            server = ServerBuilder.forPort(9090)
                    .addService(spectatorService)
                    .build()
                    .start();
            System.out.println("gRPC server started on port 9090");

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.err.println("Shutting down gRPC server...");
                this.stopServer();
                System.err.println("gRPC server shut down.");
            }));

        } catch (Exception e) {
            throw new RuntimeException("Failed to start gRPC server", e);
        }
    }

    @PreDestroy
    public void stopServer() {
        if (server != null) {
            server.shutdown();
        }
    }
}
