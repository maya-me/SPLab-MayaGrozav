package ro.uvt.info.splabmayagrozav.persistence;

import org.springframework.stereotype.Component;
import ro.uvt.info.splabmayagrozav.models.Book;

import java.util.List;
import java.util.Optional;

@Component
public class BooksRepositoryAdapter implements CrudRepository<Book, Integer> {
    private final BooksRepository booksRepository;

    public BooksRepositoryAdapter(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return booksRepository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return booksRepository.save(book);
    }

    @Override
    public void deleteById(Integer id) {
        booksRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return booksRepository.existsById(id);
    }
}
