package ro.uvt.info.splabmayagrozav.commands;

public class DeleteBookCommand implements Command<Boolean> {
    private final int id;

    public DeleteBookCommand(int id) {
        this.id = id;
    }

    @Override
    public Boolean execute(CommandContext context) {
        return context.getBooksService().delete(id);
    }
}
