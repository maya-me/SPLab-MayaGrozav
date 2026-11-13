package ro.uvt.info.splabmayagrozav.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.uvt.info.splabmayagrozav.models.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
}
