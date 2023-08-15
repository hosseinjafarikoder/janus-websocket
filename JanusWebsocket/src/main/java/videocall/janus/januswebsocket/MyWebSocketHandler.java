package videocall.janus.januswebsocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebSocketHandler extends TextWebSocketHandler {

    static private final Logger logger = LoggerFactory.getLogger(MyWebSocketHandler.class);


    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Handle incoming WebSocket messages
        String payload = message.getPayload();
        logger.info("Received message: " + payload);

        // Send a response back to the client
        session.sendMessage(new TextMessage("###Response from server: " + payload));
    }
}