package ro.uvt.info.splabmayagrozav.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.uvt.info.splabmayagrozav.models.Author;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, Integer> {
}
