package com.stackroute.muzix.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "TRACK")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long trackId;
    String trackName;
    String trackComments;
    int yearOfRelease;

    public Track(String trackName, String trackComments) {
        this.trackName = trackName;
        this.trackComments = trackComments;
    }


    @Override
    public String toString() {
        return "Muzix{" +
                "trackId=" + trackId +
                ", trackName='" + trackName + '\'' +
                ", trackComments='" + trackComments + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                '}';
    }
}
