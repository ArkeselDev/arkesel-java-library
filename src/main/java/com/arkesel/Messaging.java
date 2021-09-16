package com.arkesel;

import com.arkesel.model.ContactObject;
import com.arkesel.model.GroupObject;
import com.arkesel.model.MessageObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class Messaging implements IMessaging{

    private final String version = "v2";

    private static Messaging instance;

    private Messaging(){ }

    public static Messaging getInstance(){
        instance = instance == null ? new Messaging(): instance;
        return instance;
    }

    private HttpResponse<String> sendMessage(String body) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(SMS.baseURL+version+"/sms/send"))
                .header("api-key",SMS.getInstance().getApiKey())
                .header("Content-Type","application/json")
                .header("accept","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        return HttpClient.newHttpClient().send(request,HttpResponse.BodyHandlers.ofString());
    }

    @Override
    public HttpResponse<String> getSMSDetails(String id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(SMS.baseURL+version+"/sms/"+id))
                .header("api-key",SMS.getInstance().getApiKey())
                .header("Content-Type","application/json")
                .header("accept","application/json")
                .GET()
                .build();
        return HttpClient.newHttpClient().send(request,HttpResponse.BodyHandlers.ofString());
    }

    @Override
    public HttpResponse<String> getSMSBalance() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(SMS.baseURL+version+"/clients/balance-details"))
                .header("api-key",SMS.getInstance().getApiKey())
                .header("Content-Type","application/json")
                .header("accept","application/json")
                .GET()
                .build();
        return HttpClient.newHttpClient().send(request,HttpResponse.BodyHandlers.ofString());
    }

    @Override
    public HttpResponse<String> sendSMS(MessageObject messageObject) throws IOException, InterruptedException {
        return this.sendMessage(messageObject.toString());
    }

    @Override
    public HttpResponse<String> sendSingleSMS(String message, String recipient) throws IOException, InterruptedException {
        MessageObject body = new MessageObject(message);
        body.setRecipients(Collections.singletonList(recipient));
        return this.sendMessage(body.toString());
    }

    @Override
    public HttpResponse<String> sendSingleSMS(String message, String recipient,String callbackURL) throws IOException, InterruptedException {
        MessageObject body = new MessageObject(message);
        body.setRecipients(Collections.singletonList(recipient));
        body.setCallbackURL(callbackURL);

        return this.sendMessage(body.toString());
    }

    @Override
    public HttpResponse<String> sendSingleSMS(String message, String recipient,String callbackURL,String scheduledDate) throws IOException, InterruptedException {
        MessageObject body = new MessageObject(message);
        body.setRecipients(Collections.singletonList(recipient));
        body.setCallbackURL(callbackURL);
        body.setScheduledDate(scheduledDate);

        return this.sendMessage(body.toString());
    }

    @Override
    public HttpResponse<String> sendBulkSMS(String message, List<String> recipients) throws IOException, InterruptedException {
        return this.sendMessage(new MessageObject(message,recipients).toString());
    }

    @Override
    public HttpResponse<String> sendBulkSMS(String message, List<String> recipients,String callbackURL) throws IOException, InterruptedException {
        return this.sendMessage(new MessageObject(message,recipients,callbackURL).toString());
    }

    @Override
    public HttpResponse<String> sendBulkSMS(String message, List<String> recipients,String callbackURL,String scheduledDate) throws IOException, InterruptedException {
        return this.sendMessage(new MessageObject(message,recipients,callbackURL,scheduledDate).toString());
    }

    @Override
    public HttpResponse<String> sendSMSToGroup(String message, String groupName) throws IOException, InterruptedException {
        MessageObject body = new MessageObject(message);
        body.setGroupName(groupName);
        HttpRequest request = HttpRequest.newBuilder(URI.create(SMS.baseURL+version+"/sms/send/contact-group"))
                .header("api-key",SMS.getInstance().getApiKey())
                .header("Content-Type","application/json")
                .header("accept","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body.toStringGroup()))
                .build();
        return HttpClient.newHttpClient().send(request,HttpResponse.BodyHandlers.ofString());
    }

    @Override
    public HttpResponse<String> createGroup(String name) throws IOException, InterruptedException {
        GroupObject body = new GroupObject(name);
        System.out.println(body.toString());
        HttpRequest request = HttpRequest.newBuilder(URI.create(SMS.baseURL+version+"/contacts/groups"))
                .header("api-key",SMS.getInstance().getApiKey())
                .header("Content-Type","application/json")
                .header("accept","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body.toString()))
                .build();
        return HttpClient.newHttpClient().send(request,HttpResponse.BodyHandlers.ofString());
    }

    private HttpResponse<String> addContact(String body) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(SMS.baseURL+version+"/contacts"))
                .header("api-key",SMS.getInstance().getApiKey())
                .header("Content-Type","application/json")
                .header("accept","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        return HttpClient.newHttpClient().send(request,HttpResponse.BodyHandlers.ofString());
    }

    @Override
    public HttpResponse<String> addContacts(GroupObject group) throws IOException, InterruptedException {
        return this.addContact(group.toString());
    }

    @Override
    public HttpResponse<String> addContacts(String groupName, List<ContactObject> contacts) throws IOException, InterruptedException {
        GroupObject body = new GroupObject(groupName,contacts);
        return this.addContact(body.toString());
    }

}

