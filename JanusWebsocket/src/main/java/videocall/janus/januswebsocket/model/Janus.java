package videocall.janus.januswebsocket.model;

import java.io.Serializable;

public class Janus implements Serializable {
    String janus;
    Long session_id;
    String opaque_id;
    Long handle_id;
    String transaction;
    String plugin;

    public String getJanus() {
        return janus;
    }

    public void setJanus(String janus) {
        this.janus = janus;
    }

    public Long getSession_id() {
        return session_id;
    }

    public void setSession_id(Long session_id) {
        this.session_id = session_id;
    }

    public String getOpaque_id() {
        return opaque_id;
    }

    public void setOpaque_id(String opaque_id) {
        this.opaque_id = opaque_id;
    }

    public Long getHandle_id() {
        return handle_id;
    }

    public void setHandle_id(Long handle_id) {
        this.handle_id = handle_id;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public String getPlugin() {
        return plugin;
    }

    public void setPlugin(String plugin) {
        this.plugin = plugin;
    }
}
