package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
@Profile("notdummy")
public class TrackServiceImpl implements TrackService {

    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track)  throws TrackAlreadyExistsException {
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public List<Track> displayTrack() {
        return trackRepository.findAll();
    }

    @Override
    public Track updateTrack(Track track) {
        Optional<Track> updatedTrack = trackRepository.findById(track.getTrackId());
        if (updatedTrack.isPresent()) {
            Track trackRecords = updatedTrack.get();
            trackRecords.setTrackName(track.getTrackName());
            trackRecords.setTrackComments(track.getTrackComments());
            trackRecords.setYearOfRelease(track.getYearOfRelease());
            trackRecords = trackRepository.save(trackRecords);
            return trackRecords;
        } else {
            track = trackRepository.save(track);
            return track;
        }
    }

    @Override
    public void removeTrackById(long trackId) throws Exception,TrackNotFoundException {
        Optional<Track> remTrack = trackRepository.findById((long) trackId);
        if (remTrack.isPresent()) {
            trackRepository.deleteById((long) trackId);
        } else {
            throw new Exception("No track record exist for given trackId");

        }
    }

    @Override
    public List<Track> trackByName(String trackName) throws TrackNotFoundException {
            try {
                System.out.println("check in service" + trackRepository.trackByName(trackName));
                if(trackRepository.trackByName(trackName).isEmpty())
                { throw new TrackNotFoundException("track not found");}
                return trackRepository.trackByName(trackName);

            }
            catch (Exception e)
            {
                throw new TrackNotFoundException("track not found");
            }
    }

}
