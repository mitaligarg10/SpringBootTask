package com.stackroute.muzix.controller;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class TrackController {
    private ResponseEntity responseEntity;
    private TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException {
        try {
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("tracks")
    public ResponseEntity<?> displayTracks() {

        try {
            List<Track> listOfTracks = trackService.displayTrack();
            responseEntity = new ResponseEntity<List<Track>>(listOfTracks, HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("track/{id}")
    public void removeTrackById(@PathVariable long id) throws Exception {
        trackService.removeTrackById(id);
    }

    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) {
        try {
            trackService.updateTrack(track);
            responseEntity = new ResponseEntity<String>("Successfully Updated", HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("track/{trackName}")
    public ResponseEntity<?> getTrackByName(@PathVariable String trackName) throws TrackNotFoundException {
        System.out.println("request handling check" + trackName);
        List<Track> retrieveTrackByNAme = trackService.trackByName(trackName);
        return new ResponseEntity<>(retrieveTrackByNAme, HttpStatus.FOUND);
    }

}
