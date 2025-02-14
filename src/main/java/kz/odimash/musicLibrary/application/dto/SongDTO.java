package kz.odimash.musicLibrary.application.dto;

import java.util.UUID;

import kz.odimash.musicLibrary.domain.entity.Artist;
import lombok.Data;

@Data
public class SongDTO {
    private UUID id;
    private String name;
    private Artist artist;
    private UUID artistId;
    private String url;
}
