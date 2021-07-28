package com.arkesel;

public class SMS {

    public static final String baseURL = "https://sms.arkesel.com/api/";

    private String apiKey;
    private String senderID;
    private boolean sandbox = false;


    private static SMS instance = null;

    public final Messaging messagingInstance = Messaging.getInstance();

    public final PhoneVerification phoneVerificationInstance = PhoneVerification.getInstance();

    private SMS() { }

    private SMS(String apiKey) {
        this.apiKey = apiKey;
    }

    private SMS(String apiKey, String senderID) {
        this.apiKey = apiKey;
        this.senderID = senderID;
    }

    private SMS(String apiKey, String senderID, boolean sandbox) {
        this.apiKey = apiKey;
        this.senderID = senderID;
        this.sandbox = sandbox;
    }

    public static SMS getInstance() {
        instance = instance == null ? new SMS(): instance;
        return instance;
    }

    public static SMS getInstance(String apiKey) {
        instance = instance == null ? new SMS(apiKey): instance;
        return instance;
    }

    public static SMS getInstance(String apiKey, String senderID) {
        instance = instance == null ? new SMS(apiKey,senderID): instance;
        return instance;
    }

    public static SMS getInstance(String apiKey, String senderID, boolean sandbox) {
        instance = instance == null ? new SMS(apiKey,senderID,sandbox): instance;
        return instance;
    }

    public static Messaging getMessagingInstance() {
        return Messaging.getInstance();
    }

    public static Messaging getMessagingInstance(String apiKey) {
        getInstance().setApiKey(apiKey);
        return getMessagingInstance();
    }

    public static Messaging getMessagingInstance(String apiKey, String senderID) {
        getInstance().setApiKey(apiKey);
        getInstance().setSenderID(senderID);
        return getMessagingInstance();
    }

    public static Messaging getMessagingInstance(String apiKey, String senderID, boolean sandbox) {
        getInstance().setApiKey(apiKey);
        getInstance().setSenderID(senderID);
        getInstance().setSandbox(sandbox);
        return getMessagingInstance();
    }

    public static PhoneVerification getPhoneVerificationInstance() {
        return PhoneVerification.getInstance();
    }

    public static PhoneVerification getPhoneVerificationInstance(String apiKey) {
        getInstance().setApiKey(apiKey);
        return getPhoneVerificationInstance();
    }

    public static PhoneVerification getPhoneVerificationInstance(String apiKey,String senderID) {
        getInstance().setApiKey(apiKey);
        getInstance().setSenderID(senderID);
        return getPhoneVerificationInstance();
    }

    public static PhoneVerification getPhoneVerificationInstance(String apiKey,String senderID, boolean sandbox) {
        getInstance().setApiKey(apiKey);
        getInstance().setSenderID(senderID);
        getInstance().setSandbox(sandbox);
        return getPhoneVerificationInstance();
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public boolean isSandbox() {
        return sandbox;
    }

    public void setSandbox(boolean sandbox) {
        this.sandbox = sandbox;
    }
}
