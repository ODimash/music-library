package kz.odimash.musicLibrary.application.service;

import java.util.List;
import java.util.UUID;

import kz.odimash.musicLibrary.application.dto.ArtistDTO;

public interface ArtistService {
    
    ArtistDTO createArtist(ArtistDTO artist); //

    void deleteArtist(UUID id); //

    ArtistDTO getArtist(UUID id); //

    List<ArtistDTO> getArtists(); //

    ArtistDTO renameArtist(UUID id, String newName); //

}
