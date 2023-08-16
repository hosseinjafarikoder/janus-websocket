package videocall.janus.januswebsocket.chat;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import videocall.janus.januswebsocket.JanusConnection;
import videocall.janus.januswebsocket.JanusMsgUtil;
import videocall.janus.januswebsocket.utils.JsonUtil;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ChatHandler {
    private static final Logger log = LoggerFactory.getLogger(ChatHandler.class);
    private static ChatHandler instance;
    private final Map<String, Chat> chatMap = new ConcurrentHashMap<>();

    public static synchronized ChatHandler getInstance() {
        if (instance == null)
            instance = new ChatHandler();
        return instance;
    }

    public Chat getChat(String chatId){
        return chatMap.get(chatId);
    }

    public Chat createChat(String chatId, ChatDataDto chatDataDto, long maxAllowedPublishers){
        Chat chat=new Chat(chatId, chatDataDto);
        Chat old = chatMap.putIfAbsent(chatId,chat);//here notice
        if (old==null){
            String t1 = UUID.randomUUID().toString();
            JanusConnection.sendToJanus(JsonUtil.getJson(JanusMsgUtil.createAttachCreateRoom(chatId, t1)));

        }
        return chat;
    }
}
