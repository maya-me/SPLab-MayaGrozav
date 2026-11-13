package ro.uvt.info.splabmayagrozav.commands;

import ro.uvt.info.splabmayagrozav.models.Book;
import ro.uvt.info.splabmayagrozav.persistence.CrudRepository;

public class CommandContext {
    private final CrudRepository<Book, Integer> booksRepository;

    public CommandContext(CrudRepository<Book, Integer> booksRepository) {
        this.booksRepository = booksRepository;
    }

    public CrudRepository<Book, Integer> getBooksRepository() {
        return booksRepository;
    }
}
