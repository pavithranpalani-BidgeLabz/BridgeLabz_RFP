package org.example;

import java.io.IOException;
import java.nio.file.*;

public class UC3 {

    public static void main(String[] args) throws Exception {

        Path path = Paths.get(".");

        WatchService watchService =
                FileSystems.getDefault().newWatchService();

        path.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY
        );

        System.out.println("Watching Directory...");

        while (true) {

            WatchKey key = watchService.take();

            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println(event.kind()
                        + " : " + event.context());
            }

            key.reset();
        }
    }
}
