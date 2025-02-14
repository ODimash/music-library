package kz.odimash.musicLibrary.domain.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Song {
    private UUID id;
    private String name;
    private Artist artist;
    private UUID artistId;
    private String url;
}
