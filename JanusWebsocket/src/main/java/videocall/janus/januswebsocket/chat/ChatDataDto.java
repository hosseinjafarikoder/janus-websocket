package videocall.janus.januswebsocket.chat;


public class ChatDataDto {

    private String metaData;
    private String screenShare;
    private String brokerAddress;
    private String brokerAddressWeb;
    private String turnAddress;
    private String internalTurnAddress;
    private String kurentoAddress;
    private String screenShareUser;
    private String recordingUser;

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }

    public String getScreenShare() {
        return screenShare;
    }

    public void setScreenShare(String screenShare) {
        this.screenShare = screenShare;
    }

    public String getBrokerAddress() {
        return brokerAddress;
    }

    public void setBrokerAddress(String brokerAddress) {
        this.brokerAddress = brokerAddress;
    }

    public String getBrokerAddressWeb() {
        return brokerAddressWeb;
    }

    public void setBrokerAddressWeb(String brokerAddressWeb) {
        this.brokerAddressWeb = brokerAddressWeb;
    }

    public String getTurnAddress() {
        return turnAddress;
    }

    public void setTurnAddress(String turnAddress) {
        this.turnAddress = turnAddress;
    }

    public String getKurentoAddress() {
        return kurentoAddress;
    }

    public void setKurentoAddress(String kurentoAddress) {
        this.kurentoAddress = kurentoAddress;
    }

    public String getInternalTurnAddress() {
        return internalTurnAddress;
    }

    public void setInternalTurnAddress(String internalTurnAddress) {
        this.internalTurnAddress = internalTurnAddress;
    }

    public String getScreenShareUser() {
        return screenShareUser;
    }

    public void setScreenShareUser(String screenShareUser) {
        this.screenShareUser = screenShareUser;
    }

    public String getRecordingUser() {
        return recordingUser;
    }

    public void setRecordingUser(String recordingUser) {
        this.recordingUser = recordingUser;
    }
}
