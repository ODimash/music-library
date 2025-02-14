package kz.odimash.musicLibrary.application.service.implementation;

import kz.odimash.musicLibrary.application.dto.ArtistDTO;
import kz.odimash.musicLibrary.application.mapper.ArtistMapper;
import kz.odimash.musicLibrary.application.service.ArtistService;
import kz.odimash.musicLibrary.domain.entity.Artist;
import lombok.RequiredArgsConstructor;
import kz.odimash.musicLibrary.application.repository.ArtistRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;
    private final ArtistMapper artistMapper;

    @Override
    public ArtistDTO createArtist(ArtistDTO artistDTO) {
        Artist artist = new Artist();
        artist.setName(artistDTO.getName());
        artist = artistRepository.save(artist);
        return artistMapper.toDto(artist);
    }

    @Override
    public void deleteArtist(UUID id) {
        artistRepository.deleteById(id);
    }

    @Override
    public ArtistDTO getArtist(UUID id) {
        Artist artist = artistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artist not found"));
        return artistMapper.toDto(artist);
    }

    @Override
    public List<ArtistDTO> getArtists() {
        return artistMapper.toDtoList(artistRepository.findAll());
    }

    @Override
    public ArtistDTO renameArtist(UUID id, String newName) {
        Artist artist = artistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artist not found"));
        artist.setName(newName);
        artist = artistRepository.save(artist);
        return artistMapper.toDto(artist);
    }
}
