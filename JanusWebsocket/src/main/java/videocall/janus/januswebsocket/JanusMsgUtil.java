package videocall.janus.januswebsocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import videocall.janus.januswebsocket.model.Janus;

public class JanusMsgUtil {
    private static final Logger logger = LoggerFactory.getLogger(JanusMsgUtil.class);

    public static Janus createSession(){
        Janus janus = new Janus();
        janus.setJanus("create");
        janus.setTransaction("create-session");
        return janus;
    }

    public static Janus createAttachCreateRoom(String chatId, String transaction) {
        Janus janus = new Janus();
        janus.setJanus("attach");
        janus.setSession_id(JanusConnection.janusSessionId);
        janus.setPlugin("janus.plugin.videoroom");
        janus.setTransaction(transaction);
//        logJanusJson(janus);
        return janus;
    }
}
