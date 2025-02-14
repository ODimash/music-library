package kz.odimash.musicLibrary.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import kz.odimash.musicLibrary.application.dto.SongDTO;
import kz.odimash.musicLibrary.domain.entity.Song;

@Mapper(componentModel = "spring")
public interface SongMapper {
    SongDTO toDto(Song song);
    Song toEntity(SongDTO songDTO);
    
    List<SongDTO> toDtoList(List<Song> songs);
    List<Song> toEntityList(List<SongDTO> songDTOs);
}
