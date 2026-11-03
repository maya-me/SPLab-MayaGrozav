package ro.uvt.info.splabmayagrozav.executors;

import ro.uvt.info.splabmayagrozav.commands.Command;
import ro.uvt.info.splabmayagrozav.commands.CommandContext;

import java.util.concurrent.CompletableFuture;

public interface CommandExecutor {
    <T> CompletableFuture<T> execute(Command<T> command, CommandContext context);
}
