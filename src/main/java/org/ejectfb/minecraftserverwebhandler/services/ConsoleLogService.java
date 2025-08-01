package org.ejectfb.minecraftserverwebhandler.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ConsoleLogService {
    private final List<String> logs = Collections.synchronizedList(new ArrayList<>());
    private static final int MAX_LOG_SIZE = 500;

    public synchronized void addLog(String message) {
        logs.add(message);
        if (logs.size() > MAX_LOG_SIZE) {
            logs.subList(0, 100).clear();
        }
    }

    public synchronized List<String> getLogs() {
        return new ArrayList<>(logs);
    }

    public synchronized void clearLogs() {
        logs.clear();
    }
}