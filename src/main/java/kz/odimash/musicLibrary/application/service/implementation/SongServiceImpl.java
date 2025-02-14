package kz.odimash.musicLibrary.application.service.implementation;

import kz.odimash.musicLibrary.application.dto.SongDTO;
import kz.odimash.musicLibrary.application.mapper.SongMapper;
import kz.odimash.musicLibrary.application.repository.SongRepository;
import kz.odimash.musicLibrary.application.service.SongService;
import kz.odimash.musicLibrary.domain.entity.Song;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final SongMapper songMapper;

    public SongServiceImpl(SongRepository songRepository, SongMapper songMapper) {
        this.songRepository = songRepository;
        this.songMapper = songMapper;
    }

    @Override
    public SongDTO createSong(SongDTO songDTO) {
        Song song = songMapper.toEntity(songDTO);
        song = songRepository.save(song);
        return songMapper.toDto(song);
    }

    @Override
    public void deleteSong(UUID id) {
        songRepository.deleteById(id);
    }

    @Override
    public SongDTO renameSong(UUID id, String name) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Song not found"));

        song.setName(name);
        song = songRepository.save(song);
        return songMapper.toDto(song);
    }

    @Override
    public List<SongDTO> getSongs() {
        return songMapper.toDtoList(songRepository.findAll());
    }

    @Override
    public SongDTO getSong(UUID id) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Song not found"));

        return songMapper.toDto(song);
    }
}
