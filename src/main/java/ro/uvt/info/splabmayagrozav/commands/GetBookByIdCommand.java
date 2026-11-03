package ro.uvt.info.splabmayagrozav.commands;

import ro.uvt.info.splabmayagrozav.models.Book;

public class GetBookByIdCommand implements Command<Book> {
    private final int id;

    public GetBookByIdCommand(int id) {
        this.id = id;
    }

    @Override
    public Book execute(CommandContext context) {
        return context.getBooksService().findById(id);
    }
}
