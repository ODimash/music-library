package kz.odimash.musicLibrary.infrastructure.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import kz.odimash.musicLibrary.application.dto.SongDTO;
import kz.odimash.musicLibrary.application.service.SongService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/songs")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;
    
    @GetMapping("/{id}")
    public SongDTO getSong(@PathVariable UUID id) {
        return songService.getSong(id);
    }

    @GetMapping
    public List<SongDTO> getSongs() {
        return songService.getSongs(); 
    }

    @PostMapping
    public SongDTO createSong(@RequestBody SongDTO song) {
        return songService.createSong(song);
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable UUID id) {
        songService.deleteSong(id);
    }

    @PutMapping("/rename")
    public SongDTO renameSong(@RequestParam UUID id, @RequestParam String name) {
        return songService.renameSong(id, name);
    }

}
