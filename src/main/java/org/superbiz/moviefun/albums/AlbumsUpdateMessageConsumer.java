package org.superbiz.moviefun.albums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AlbumsUpdateMessageConsumer {

    private final AlbumsUpdater albumsUpdater;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public AlbumsUpdateMessageConsumer(AlbumsUpdater albumsUpdater) {
        this.albumsUpdater = albumsUpdater;
    }

    public void consumeMessage(Message<?> message) {
        System.out.println("message = " + message);

        try {
            logger.debug("Starting albums update");
            albumsUpdater.update();
            logger.debug("Finished albums update");
        } catch (IOException e) {
            logger.error("Error while updating albums", e);
        }
    }
}
