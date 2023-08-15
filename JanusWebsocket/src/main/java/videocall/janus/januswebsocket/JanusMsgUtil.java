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
}
