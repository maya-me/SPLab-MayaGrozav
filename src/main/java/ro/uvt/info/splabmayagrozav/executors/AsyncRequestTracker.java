package ro.uvt.info.splabmayagrozav.executors;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class AsyncRequestTracker {
    private final Map<String, CompletableFuture<?>> requests = new ConcurrentHashMap<>();

    public String track(CompletableFuture<?> future) {
        String id = UUID.randomUUID().toString();
        requests.put(id, future);
        return id;
    }

    public RequestStatus getStatus(String id) {
        CompletableFuture<?> future = requests.get(id);
        if (future == null) {
            return null;
        }
        if (!future.isDone()) {
            return RequestStatus.PENDING;
        }
        if (future.isCompletedExceptionally()) {
            return RequestStatus.FAILED;
        }
        return RequestStatus.COMPLETED;
    }
}
