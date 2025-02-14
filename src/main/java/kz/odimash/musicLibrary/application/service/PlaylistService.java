package kz.odimash.musicLibrary.application.service;

import java.util.List;
import java.util.UUID;

import kz.odimash.musicLibrary.application.dto.PlaylistDTO;

public interface PlaylistService {
    PlaylistDTO createPlaylist(PlaylistDTO playlist);
    PlaylistDTO addSongToPlaylist(UUID playlistId, UUID songId);
    
    PlaylistDTO removeSongFromPlaylist(UUID playlistId, UUID songId);
    PlaylistDTO renamePlaylist(UUID playlistId, String newName);

    List<PlaylistDTO> getPlaylists();
    PlaylistDTO getPlaylist(UUID id);
    void deletePlaylist(UUID id);
}
