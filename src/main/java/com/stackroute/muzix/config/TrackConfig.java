package com.stackroute.muzix.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("my-track")
public class TrackConfig {
    private long id;
    private String name;
    private String comment;
}
