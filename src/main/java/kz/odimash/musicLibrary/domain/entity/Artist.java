package kz.odimash.musicLibrary.domain.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Artist {
    private UUID id;
    private String name;
    private List<Song> songs;
}
