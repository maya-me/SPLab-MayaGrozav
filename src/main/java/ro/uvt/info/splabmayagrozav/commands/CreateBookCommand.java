package ro.uvt.info.splabmayagrozav.commands;

import ro.uvt.info.splabmayagrozav.models.Book;

public class CreateBookCommand implements Command<Integer> {
    private final Book book;

    public CreateBookCommand(Book book) {
        this.book = book;
    }

    @Override
    public Integer execute(CommandContext context) {
        return context.getBooksService().create(book);
    }
}
