package com.arkesel;

import java.util.ArrayList;
import java.util.List;

public class MessageObject {
    private String message;
    private String groupName = "";
    private String callbackURL = "";
    private String scheduledDate = "";
    private List<String> recipients = new ArrayList<>();

    public MessageObject(String message){
        this.message = message;
    }

    public MessageObject(String message, List<String> recipients){
        this.message = message;
        this.recipients = recipients;
    }

    public MessageObject(String message, List<String> recipients, String callbackURL){
        this.message = message;
        this.recipients = recipients;
        this.callbackURL = callbackURL;
    }

    public MessageObject(String message, List<String> recipients, String callbackURL, String scheduledDate){
        this.message = message;
        this.recipients = recipients;
        this.callbackURL = callbackURL;
        this.scheduledDate = scheduledDate;
    }

    @Override
    public String toString() {
        String data = "{" +
                "\"sender\":\"" + SMS.getInstance().getSenderID() + '"' +
                ", \"message\":\"" + message + '"' +
                ", \"recipients\":" + listToString();
        if(!callbackURL.isEmpty()){
            data += ", \"callback_url\":\"" + callbackURL + '"';
        }
        if(!scheduledDate.isEmpty()){
            data += ", \"scheduled_date\":\"" + scheduledDate + '"';
        }
        data += ", \"sandbox\":" + SMS.getInstance().isSandbox() +"}";
        return data;
    }

    public String toStringGroup() {
        return "{" +
                "\"sender\":\"" + SMS.getInstance().getSenderID() + '"' +
                ", \"message\":\"" + message + '"' +
                ", \"group_name\":\"" + groupName + '"' +
                "}";
    }

    private String listToString(){
        StringBuilder result = new StringBuilder("[]");
        if (!recipients.isEmpty()) {
            result = new StringBuilder("[" + '"' + recipients.get(0) + '"');
            for (int i = 1; i < recipients.size(); i++) {
                result.append(", \"").append(recipients.get(i)).append('"');
            }
            result.append("]");
        }
        return result.toString();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCallbackURL() {
        return callbackURL;
    }

    public void setCallbackURL(String callbackURL) {
        this.callbackURL = callbackURL;
    }

    public String getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }
}
