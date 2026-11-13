package ro.uvt.info.splabmayagrozav.commands;

import ro.uvt.info.splabmayagrozav.models.Book;

public class CreateBookCommand implements Command<Book> {
    private final Book book;

    public CreateBookCommand(Book book) {
        this.book = book;
    }

    @Override
    public Book execute(CommandContext context) {
        return context.getBooksRepository().save(book);
    }
}
