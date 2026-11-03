package ro.uvt.info.splabmayagrozav.commands;

import ro.uvt.info.splabmayagrozav.services.BooksService;

public class CommandContext {
    private final BooksService booksService;

    public CommandContext(BooksService booksService) {
        this.booksService = booksService;
    }

    public BooksService getBooksService() {
        return booksService;
    }
}
