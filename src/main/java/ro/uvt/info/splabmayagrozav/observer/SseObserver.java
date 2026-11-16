package ro.uvt.info.splabmayagrozav.observer;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.uvt.info.splabmayagrozav.models.Book;

import java.io.IOException;

public class SseObserver implements Observer {
    private final SseEmitter emitter;
    private final Subject subject;

    public SseObserver(SseEmitter emitter, Subject subject) {
        this.emitter = emitter;
        this.subject = subject;
        emitter.onCompletion(() -> subject.detach(this));
        emitter.onTimeout(() -> subject.detach(this));
        emitter.onError(e -> subject.detach(this));
    }

    @Override
    public void update(Book book) {
        try {
            emitter.send(book, MediaType.APPLICATION_JSON);
        } catch (IOException | IllegalStateException e) {
            subject.detach(this);
            emitter.completeWithError(e);
        }
    }
}
