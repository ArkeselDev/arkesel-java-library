package com.arkesel;

import com.arkesel.model.ContactObject;
import com.arkesel.model.GroupObject;
import com.arkesel.model.MessageObject;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

public interface IMessaging {
    public HttpResponse<String> getSMSDetails(String id) throws IOException, InterruptedException;

    public HttpResponse<String> getSMSBalance() throws IOException, InterruptedException;

    public HttpResponse<String> sendSMS(MessageObject messageObject) throws IOException, InterruptedException;

    public HttpResponse<String> sendSingleSMS(String message, String recipient) throws IOException, InterruptedException;
    public HttpResponse<String> sendSingleSMS(String message, String recipient,String callbackURL) throws IOException, InterruptedException;
    public HttpResponse<String> sendSingleSMS(String message, String recipient,String callbackURL,String scheduledDate) throws IOException, InterruptedException;

    public HttpResponse<String> sendBulkSMS(String message, List<String> recipients) throws IOException, InterruptedException;
    public HttpResponse<String> sendBulkSMS(String message, List<String> recipients,String callbackURL) throws IOException, InterruptedException;
    public HttpResponse<String> sendBulkSMS(String message, List<String> recipients,String callbackURL,String scheduledDate) throws IOException, InterruptedException;

    public HttpResponse<String> sendSMSToGroup(String message, String groupName) throws IOException, InterruptedException;

    public HttpResponse<String> createGroup(String name) throws IOException, InterruptedException;

    public HttpResponse<String> addContacts(GroupObject group) throws IOException, InterruptedException;
    public HttpResponse<String> addContacts(String groupName, List<ContactObject> contacts) throws IOException, InterruptedException;
}
