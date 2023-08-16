package videocall.janus.januswebsocket.commandHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import videocall.janus.januswebsocket.chat.ChatHandler;
import videocall.janus.januswebsocket.dto.ReciveChatDto;

public class CommandHandler {
    private static Logger logger = LoggerFactory.getLogger(CommandHandler.class);
    private static CommandHandler instance;

    public static CommandHandler getInstance() {
        if(instance == null)
            instance = new CommandHandler();
        return instance;
    }

    public void messageHandler(ReciveChatDto dto) {
        try {
            switch (dto.getActionId()) {
                case 1001:
                    logger.info("case 1001 is ok");
                    handleCreateStream(dto);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleCreateStream(ReciveChatDto dto) {
        ChatHandler.getInstance().createChat(dto.getChatId(), dto.getChatDataDto(), 501);
    }
}
