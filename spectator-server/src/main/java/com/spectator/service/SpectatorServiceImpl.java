package com.spectator.service;

import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;
import spectator.*;

@Service
public class SpectatorServiceImpl extends SpectatorServiceGrpc.SpectatorServiceImplBase {

    private final SpectatorRepository spectatorRepository;
    private final MatchRepository matchRepository;

    public SpectatorServiceImpl(SpectatorRepository spectatorRepository, MatchRepository matchRepository) {
        this.spectatorRepository = spectatorRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public void getSpectatorById(SpectatorRequest request, StreamObserver<SpectatorResponse> responseObserver) {
        int id = request.getId();
        Spectator spectator = spectatorRepository.findById(id).orElse(null);

        if (spectator != null) {
            SpectatorResponse response = SpectatorResponse.newBuilder()
                    .setId(spectator.getId())
                    .setSname(spectator.getSname())
                    .setMale(spectator.isMale())
                    .setHaspass(spectator.isHaspass())
                    .build();
            responseObserver.onNext(response);
        }
        responseObserver.onCompleted();
    }

    @Override
    public void createMatch(MatchRequest request, StreamObserver<MatchResponse> responseObserver) {
        Match match = new Match();
        match.setId(request.getId());
        match.setMdate(request.getMdate());
        match.setStartsat(request.getStartsat());
        match.setTicketprice(request.getTicketprice());
        match.setMtype(MatchType.valueOf(request.getMtype().toUpperCase()));

        match = matchRepository.save(match);

        MatchResponse response = MatchResponse.newBuilder()
                .setId(match.getId())
                .setMdate(match.getMdate().toString())
                .setStartsat(match.getStartsat().toString())
                .setTicketprice(match.getTicketprice())
                .setMtype(match.getMtype().toString())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
