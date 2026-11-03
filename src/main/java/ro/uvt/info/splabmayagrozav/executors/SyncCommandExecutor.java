package ro.uvt.info.splabmayagrozav.executors;

import org.springframework.stereotype.Component;
import ro.uvt.info.splabmayagrozav.commands.Command;
import ro.uvt.info.splabmayagrozav.commands.CommandContext;

import java.util.concurrent.CompletableFuture;

@Component("syncCommandExecutor")
public class SyncCommandExecutor implements CommandExecutor {
    @Override
    public <T> CompletableFuture<T> execute(Command<T> command, CommandContext context) {
        try {
            return CompletableFuture.completedFuture(command.execute(context));
        } catch (Exception e) {
            return CompletableFuture.failedFuture(e);
        }
    }
}
