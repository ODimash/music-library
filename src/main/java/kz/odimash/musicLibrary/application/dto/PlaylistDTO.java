package kz.odimash.musicLibrary.application.dto;

import java.util.List;
import java.util.UUID;

import kz.odimash.musicLibrary.domain.entity.Song;
import lombok.Data;

@Data
public class PlaylistDTO {
    private UUID id;
    private String name;
    private List<Song> songs;
}
