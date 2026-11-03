package ro.uvt.info.splabmayagrozav.commands;

import ro.uvt.info.splabmayagrozav.models.Book;

import java.util.Map;

public class GetAllBooksCommand implements Command<Map<Integer, Book>> {
    @Override
    public Map<Integer, Book> execute(CommandContext context) {
        return context.getBooksService().findAll();
    }
}
