package ro.uvt.info.splabmayagrozav.observer;

import org.springframework.stereotype.Component;
import ro.uvt.info.splabmayagrozav.models.Book;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class AllBooksSubject implements Subject {
    private final List<Observer> observers = new CopyOnWriteArrayList<>();
    private final List<Book> books = new CopyOnWriteArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Book book) {
        for (Observer observer : observers) {
            observer.update(book);
        }
    }

    public void add(Book book) {
        books.add(book);
        notifyObservers(book);
    }

    public List<Book> getBooks() {
        return books;
    }
}
