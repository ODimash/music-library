package kz.odimash.musicLibrary.application.service;

import java.util.List;
import java.util.UUID;

import kz.odimash.musicLibrary.application.dto.SongDTO;

public interface SongService {
    SongDTO createSong(SongDTO song);
    void deleteSong(UUID id);

    SongDTO renameSong(UUID id, String name);
    List<SongDTO> getSongs();

    SongDTO getSong(UUID id);
}
