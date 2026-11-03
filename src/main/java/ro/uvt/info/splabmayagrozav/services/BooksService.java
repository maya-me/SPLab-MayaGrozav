package ro.uvt.info.splabmayagrozav.services;

import org.springframework.stereotype.Service;
import ro.uvt.info.splabmayagrozav.models.Book;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BooksService {
    private final Map<Integer, Book> books = new ConcurrentHashMap<>();
    private final AtomicInteger nextId = new AtomicInteger(1);

    public Map<Integer, Book> findAll() {
        return books;
    }

    public Book findById(int id) {
        return books.get(id);
    }

    public int create(Book book) {
        int id = nextId.getAndIncrement();
        books.put(id, book);
        return id;
    }

    public boolean update(int id, Book book) {
        return books.replace(id, book) != null;
    }

    public boolean delete(int id) {
        return books.remove(id) != null;
    }
}
