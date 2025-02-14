package kz.odimash.musicLibrary.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import kz.odimash.musicLibrary.application.dto.PlaylistDTO;
import kz.odimash.musicLibrary.domain.entity.Playlist;

@Mapper(componentModel = "spring")
public interface PlaylistMapper {
    public PlaylistDTO toDto(Playlist artist);
    public Playlist toEntity(PlaylistDTO artistDTO);

    public List<PlaylistDTO> toDtoList(List<Playlist> artists);
    public List<Playlist> toEntityList (List<PlaylistDTO> artistDTOs);
}