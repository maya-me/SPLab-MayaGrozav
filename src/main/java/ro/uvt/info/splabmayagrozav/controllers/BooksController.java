package ro.uvt.info.splabmayagrozav.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.uvt.info.splabmayagrozav.commands.CommandContext;
import ro.uvt.info.splabmayagrozav.commands.CreateBookCommand;
import ro.uvt.info.splabmayagrozav.commands.DeleteBookCommand;
import ro.uvt.info.splabmayagrozav.commands.GetAllBooksCommand;
import ro.uvt.info.splabmayagrozav.commands.GetBookByIdCommand;
import ro.uvt.info.splabmayagrozav.commands.UpdateBookCommand;
import ro.uvt.info.splabmayagrozav.executors.AsyncRequestTracker;
import ro.uvt.info.splabmayagrozav.executors.CommandExecutor;
import ro.uvt.info.splabmayagrozav.executors.RequestStatus;
import ro.uvt.info.splabmayagrozav.models.Book;
import ro.uvt.info.splabmayagrozav.services.BooksService;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/books")
public class BooksController {
    private final CommandContext context;
    private final CommandExecutor syncExecutor;
    private final CommandExecutor asyncExecutor;
    private final AsyncRequestTracker tracker;

    public BooksController(BooksService booksService,
                           @Qualifier("syncCommandExecutor") CommandExecutor syncExecutor,
                           @Qualifier("asyncCommandExecutor") CommandExecutor asyncExecutor,
                           AsyncRequestTracker tracker) {
        this.context = new CommandContext(booksService);
        this.syncExecutor = syncExecutor;
        this.asyncExecutor = asyncExecutor;
        this.tracker = tracker;
    }

    @GetMapping
    public Map<Integer, Book> getAll() {
        return syncExecutor.execute(new GetAllBooksCommand(), context).join();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable int id) {
        return syncExecutor.execute(new GetBookByIdCommand(id), context).join();
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Book book) {
        CompletableFuture<Integer> future = asyncExecutor.execute(new CreateBookCommand(book), context);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(tracker.track(future));
    }

    @PutMapping("/{id}")
    public Boolean update(@PathVariable int id, @RequestBody Book book) {
        return syncExecutor.execute(new UpdateBookCommand(id, book), context).join();
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable int id) {
        return syncExecutor.execute(new DeleteBookCommand(id), context).join();
    }

    @GetMapping("/requests/{requestId}")
    public ResponseEntity<RequestStatus> getRequestStatus(@PathVariable String requestId) {
        RequestStatus status = tracker.getStatus(requestId);
        if (status == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(status);
    }
}
