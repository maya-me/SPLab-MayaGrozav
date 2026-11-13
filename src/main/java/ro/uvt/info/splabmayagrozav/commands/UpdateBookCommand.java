package ro.uvt.info.splabmayagrozav.commands;

import ro.uvt.info.splabmayagrozav.models.Book;

public class UpdateBookCommand implements Command<Boolean> {
    private final int id;
    private final Book book;

    public UpdateBookCommand(int id, Book book) {
        this.id = id;
        this.book = book;
    }

    @Override
    public Boolean execute(CommandContext context) {
        if (!context.getBooksRepository().existsById(id)) {
            return false;
        }
        book.setId(id);
        context.getBooksRepository().save(book);
        return true;
    }
}
