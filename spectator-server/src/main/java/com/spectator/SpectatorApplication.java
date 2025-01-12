package com.spectator;

import com.spectator.config.GrpcServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpectatorApplication implements CommandLineRunner {

	private final GrpcServer grpcServer;

    public SpectatorApplication(GrpcServer grpcServer) {
        this.grpcServer = grpcServer;
    }

    public static void main(String[] args) {
		SpringApplication.run(SpectatorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		grpcServer.start();
	}
}

