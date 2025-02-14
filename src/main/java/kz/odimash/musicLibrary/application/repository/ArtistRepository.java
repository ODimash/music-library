package kz.odimash.musicLibrary.application.repository;

import kz.odimash.musicLibrary.domain.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, UUID> {
}
