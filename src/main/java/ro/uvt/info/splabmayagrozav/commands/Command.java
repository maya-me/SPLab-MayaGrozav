package ro.uvt.info.splabmayagrozav.commands;

public interface Command<T> {
    T execute(CommandContext context);
}
