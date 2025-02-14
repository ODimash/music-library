package kz.odimash.musicLibrary.application.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.odimash.musicLibrary.domain.entity.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, UUID> {

}
