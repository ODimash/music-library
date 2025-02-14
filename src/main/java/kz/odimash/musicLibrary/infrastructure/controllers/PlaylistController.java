package kz.odimash.musicLibrary.infrastructure.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import kz.odimash.musicLibrary.application.dto.PlaylistDTO;
import kz.odimash.musicLibrary.application.service.PlaylistService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/playlists")
@RequiredArgsConstructor
public class PlaylistController {

    private final PlaylistService playlistService;

    @GetMapping("/{id}")
    public PlaylistDTO getPlaylist(@PathVariable UUID id) {
        return playlistService.getPlaylist(id);
    }

    @GetMapping
    public List<PlaylistDTO> getPlaylists() {
        return playlistService.getPlaylists();
    }

    @PostMapping
    public PlaylistDTO createPlaylist(@RequestBody PlaylistDTO playlist) {
        return playlistService.createPlaylist(playlist);
    }

    @PutMapping("/add-song")
    public PlaylistDTO addSongToPlaylist(@RequestParam UUID playlistId, @RequestParam UUID songId) {
        return playlistService.addSongToPlaylist(playlistId, songId);
    }

    @PutMapping("/remove-song")
    public PlaylistDTO removeSongToPlaylist(@RequestParam UUID playlistId, @RequestParam UUID songId) {
        return playlistService.removeSongFromPlaylist(playlistId, songId);
    }

    @DeleteMapping("/{id}") 
    public void deletePlaylist(@PathVariable UUID id) {
        playlistService.deletePlaylist(id);
    } 

    @PutMapping("/rename")
    public PlaylistDTO renamePlaylist(@RequestParam UUID playlistId, @RequestParam String name) {
        return playlistService.renamePlaylist(playlistId, name);
    }

}
