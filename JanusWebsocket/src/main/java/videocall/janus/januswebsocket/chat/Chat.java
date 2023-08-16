package videocall.janus.januswebsocket.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Chat {
    private static final Logger logger = LoggerFactory.getLogger(Chat.class);

    private String chatId;

    public Chat(String chatId, ChatDataDto chatDataDto) {
        this.chatId = chatId;
    }

    public String getChatId() {
        return chatId;
    }


}
