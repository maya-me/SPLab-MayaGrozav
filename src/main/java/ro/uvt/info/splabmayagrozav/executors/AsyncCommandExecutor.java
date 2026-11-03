package ro.uvt.info.splabmayagrozav.executors;

import org.springframework.stereotype.Component;
import ro.uvt.info.splabmayagrozav.commands.Command;
import ro.uvt.info.splabmayagrozav.commands.CommandContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component("asyncCommandExecutor")
public class AsyncCommandExecutor implements CommandExecutor {
    private final ExecutorService pool = Executors.newFixedThreadPool(4);

    @Override
    public <T> CompletableFuture<T> execute(Command<T> command, CommandContext context) {
        return CompletableFuture.supplyAsync(() -> command.execute(context), pool);
    }
}
