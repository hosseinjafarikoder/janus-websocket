package videocall.janus.januswebsocket.dto;

//import com.example.demo.chat.ChatDataDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.socket.WebSocketSession;
import videocall.janus.januswebsocket.chat.ChatDataDto;

public class ReciveChatDto {
    String uniqeId;
    String chatId;
    int actionId;
    boolean done;
    ChatDataDto chatDataDto;
    @JsonIgnore
    private transient WebSocketSession session;
    Long ownerKafkaAdmin;

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }


    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isDone() {
        return done;
    }

    public String getUniqeId() {
        return uniqeId;
    }

    public void setUniqeId(String uniqeId) {
        this.uniqeId = uniqeId;
    }

        public ChatDataDto getChatDataDto() {
        return chatDataDto;
    }

    public void setChatDataDto(ChatDataDto chatDataDto) {
        this.chatDataDto = chatDataDto;
    }

    public Long getOwnerKafkaAdmin() {
        return ownerKafkaAdmin;
    }

    public void setOwnerKafkaAdmin(Long ownerKafkaAdmin) {
        this.ownerKafkaAdmin = ownerKafkaAdmin;
    }

    public WebSocketSession getSession() {
        return session;
    }

    public void setSession(WebSocketSession session) {
        this.session = session;
    }
}


