package videocall.janus.januswebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@SpringBootApplication
@EnableWebSocket
public class JanusWebsocketApplication implements WebSocketConfigurer {

    @Bean
    public MyWebSocketHandler getRequestHandler() {
        return new MyWebSocketHandler();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("videocall.janus.januswebsocket.JanusConnection");
        SpringApplication.run(JanusWebsocketApplication.class, args);
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(getRequestHandler(),"/websocket").setAllowedOrigins("*");
    }
}
