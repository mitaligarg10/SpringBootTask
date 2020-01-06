package com.stackroute.muzix.config;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.repository.TrackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupCommandLineRunner implements CommandLineRunner {

    TrackRepository trackRepository;

    public static final Logger log = LoggerFactory.getLogger(StartupCommandLineRunner.class);

    @Autowired
    public StartupCommandLineRunner(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Application started using CommandLineRunner Approach");
        trackRepository.save(new Track("Photo", "Lukka chippi"));
        trackRepository.save(new Track("Muqaabla", "StreetDancer 3"));
        trackRepository.save(new Track("Namo Namo", "From Kedarnath"));
        trackRepository.save(new Track("Qaafirana", "From Kedarnath"));

        log.info("CommandLineRunner ");
    }
}
