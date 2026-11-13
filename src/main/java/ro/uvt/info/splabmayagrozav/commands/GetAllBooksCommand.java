package ro.uvt.info.splabmayagrozav.commands;

import ro.uvt.info.splabmayagrozav.models.Book;

import java.util.List;

public class GetAllBooksCommand implements Command<List<Book>> {
    @Override
    public List<Book> execute(CommandContext context) {
        return context.getBooksRepository().findAll();
    }
}
