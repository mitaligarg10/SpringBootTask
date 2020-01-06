package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    public List<Track> displayTrack();

    public void removeTrackById(long trackId) throws Exception, TrackNotFoundException;

    public Track updateTrack(Track track);

    public List<Track> trackByName(String trackName) throws TrackNotFoundException;
}
