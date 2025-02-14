package kz.odimash.musicLibrary.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import kz.odimash.musicLibrary.application.dto.ArtistDTO;
import kz.odimash.musicLibrary.domain.entity.Artist;

@Mapper(componentModel = "spring")
public interface ArtistMapper {
    public ArtistDTO toDto(Artist artist);
    public Artist toEntity(ArtistDTO artistDTO);

    public List<ArtistDTO> toDtoList(List<Artist> artists);
    public List<Artist> toEntityList (List<ArtistDTO> artistDTOs);
}
