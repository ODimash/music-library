package kz.odimash.musicLibrary.infrastructure.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kz.odimash.musicLibrary.application.dto.ArtistDTO;
import kz.odimash.musicLibrary.application.service.ArtistService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/artists")
@RequiredArgsConstructor
public class ArtistController {

    private final ArtistService artistService;


    @GetMapping("/{id}")
    public ArtistDTO getArtist(@PathVariable UUID id) {
        return artistService.getArtist(id);
    }

    @GetMapping
    public List<ArtistDTO> getArtists() {
        return artistService.getArtists();
    }

    @PostMapping
    public ArtistDTO createArtist(@RequestBody ArtistDTO artist) {
        return artistService.createArtist(artist);
    }

    @DeleteMapping("/{id}")
    public void deleteArtist(@PathVariable UUID id) {
        artistService.deleteArtist(id);
    }


    @PutMapping("/rename")
    public ArtistDTO renamArtist(@RequestParam UUID artistId, @RequestParam String name) {
        return artistService.renameArtist(artistId, name);
    }
}
