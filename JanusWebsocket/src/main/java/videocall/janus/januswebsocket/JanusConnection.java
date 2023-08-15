package videocall.janus.januswebsocket;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.extensions.IExtension;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.protocols.IProtocol;
import org.java_websocket.protocols.Protocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import videocall.janus.januswebsocket.utils.JsonUtil;

import java.net.URI;
import java.util.Collections;

public class JanusConnection {
    private static final Logger logger = LoggerFactory.getLogger(JanusConnection.class);


    private static WebSocketClient clientWs;

    static {
        init();
    }

    public static void init() {
        logger.info("init started correctly!!!");

        Draft_6455 draft = new Draft_6455(Collections.<IExtension>emptyList(),
                Collections.<IProtocol>singletonList(new Protocol("janus-protocol")));

        clientWs = new WebSocketClient(URI.create("ws://127.0.0.1:8188/"), draft) {

            @Override
            public void onOpen(ServerHandshake handshakedata) {
                logger.info("opened !!!");
            }

            @Override
            public void onMessage(String s) {

            }

            @Override
            public void onClose(int i, String s, boolean b) {

            }

            @Override
            public void onError(Exception e) {

            }

        };
        clientWs.connect();
        logger.info("clientws be connected : "+clientWs.toString());

        clientWs.send(JsonUtil.getJson(JanusMsgUtil.createSession()));
        logger.info("JsonUtil.getJson : "+JsonUtil.getJson((JanusMsgUtil.createSession())));
    }
}
