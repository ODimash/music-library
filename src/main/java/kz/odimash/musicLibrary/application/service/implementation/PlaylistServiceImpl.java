package kz.odimash.musicLibrary.application.service.implementation;

import kz.odimash.musicLibrary.application.dto.PlaylistDTO;
import kz.odimash.musicLibrary.application.mapper.PlaylistMapper;
import kz.odimash.musicLibrary.application.repository.PlaylistRepository;
import kz.odimash.musicLibrary.application.repository.SongRepository;
import kz.odimash.musicLibrary.application.service.PlaylistService;
import kz.odimash.musicLibrary.domain.entity.Playlist;
import kz.odimash.musicLibrary.domain.entity.Song;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final SongRepository songRepository;
    private final PlaylistMapper playlistMapper;

    @Override
    public PlaylistDTO createPlaylist(PlaylistDTO playlistDTO) {
        Playlist playlist = playlistMapper.toEntity(playlistDTO);
        playlist = playlistRepository.save(playlist);
        return playlistMapper.toDto(playlist);
    }

    @Override
    public PlaylistDTO addSongToPlaylist(UUID playlistId, UUID songId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));

        Song song = songRepository.findById(songId)
                .orElseThrow(() -> new RuntimeException("Song not found"));

        playlist.getSongs().add(song);
        playlist = playlistRepository.save(playlist);

        return playlistMapper.toDto(playlist);
    }

    @Override
    public PlaylistDTO removeSongFromPlaylist(UUID playlistId, UUID songId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));

        Song song = songRepository.findById(songId)
                .orElseThrow(() -> new RuntimeException("Song not found"));

        playlist.getSongs().remove(song);
        playlist = playlistRepository.save(playlist);

        return playlistMapper.toDto(playlist);
    }

    @Override
    public PlaylistDTO renamePlaylist(UUID playlistId, String newName) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));

        playlist.setName(newName);
        playlist = playlistRepository.save(playlist);

        return playlistMapper.toDto(playlist);
    }

    @Override
    public List<PlaylistDTO> getPlaylists() {
        return playlistMapper.toDtoList(playlistRepository.findAll());
    }

    @Override
    public PlaylistDTO getPlaylist(UUID id) {
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));

        return playlistMapper.toDto(playlist);
    }

    @Override
    public void deletePlaylist(UUID id) {
        playlistRepository.deleteById(id);
    }
}
