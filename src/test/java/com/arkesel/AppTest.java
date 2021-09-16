package com.arkesel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.arkesel.model.ContactObject;
import com.arkesel.model.MessageObject;
import com.arkesel.model.OTPMedium;
import com.arkesel.model.OTPType;
import org.junit.Test;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Collections;

public class AppTest 
{
    private final SMS sms = SMS.getInstance("","test",true);
    /**
     * checkSMSDetails Test :-)
     */
    @Test
    public void checkSMSDetails() throws IOException, InterruptedException {
        HttpResponse<String> response = sms.messagingInstance.getSMSDetails("29c642c5-8826-44c0-98b4-abcf9243911d");
        assertEquals(200, response.statusCode());
    }

    @Test
    public void checkBalanceDetails() throws IOException, InterruptedException {
        HttpResponse<String> response = sms.messagingInstance.getSMSBalance();
        assertEquals(200, response.statusCode());
    }

    @Test
    public void sendSMS() throws IOException, InterruptedException {
        MessageObject messageObject = new MessageObject("Test Java");
        messageObject.setRecipients(Collections.singletonList("0205768728"));
        HttpResponse<String> response = sms.messagingInstance.sendSMS(messageObject);
        assertEquals(200, response.statusCode());
    }

    @Test
    public void sendSingleSMS() throws IOException, InterruptedException {
        HttpResponse<String> response = sms.messagingInstance.sendSingleSMS("Test Java","0205768728");
        assertEquals(200, response.statusCode());
    }

    @Test
    public void sendSingleSMSWithDeliveryWebhook() throws IOException, InterruptedException {
        HttpResponse<String> response = sms.messagingInstance
                .sendSingleSMS("Test Java","0205768728","https://arkesel.com");
        assertEquals(200, response.statusCode());
    }

    @Test
    public void sendSingleSMSWithScheduledDate() throws IOException, InterruptedException {
        HttpResponse<String> response = sms.messagingInstance
                .sendSingleSMS("Test Java","0205768728","","2021-04-09 07:30 AM");
        assertEquals(200, response.statusCode());
    }

    @Test
    public void sendSingleSMSWithDeliveryWebhookWithScheduledDate() throws IOException, InterruptedException {
        HttpResponse<String> response = sms.messagingInstance
                .sendSingleSMS("Test Java","0205768728","https://arkesel.com","2021-04-09 07:30 AM");
        assertEquals(200, response.statusCode());
    }

    @Test
    public void sendBulkSMS() throws IOException, InterruptedException {
        HttpResponse<String> response = sms.messagingInstance
                .sendBulkSMS("Test Java", Arrays.asList("0205768728","0557560032"));
        assertEquals(200, response.statusCode());
    }

    @Test
    public void sendBulkSMSWithDeliveryWebhook() throws IOException, InterruptedException {
        HttpResponse<String> response = sms.messagingInstance
                .sendBulkSMS("Test Java",Arrays.asList("0205768728","0557560032"),
                        "https://arkesel.com");
        assertEquals(200, response.statusCode());
    }

    @Test
    public void sendBulkSMSWithScheduledDate() throws IOException, InterruptedException {
        HttpResponse<String> response = sms.messagingInstance
                .sendBulkSMS("Test Java",Arrays.asList("0205768728","0557560032"),
                        "","2021-04-09 07:30 AM");
        assertEquals(200, response.statusCode());
    }

    @Test
    public void sendBulkSMSWithDeliveryWebhookWithScheduledDate() throws IOException, InterruptedException {
        HttpResponse<String> response = sms.messagingInstance
                .sendBulkSMS("Test Java",Arrays.asList("0205768728","0557560032"),"https://arkesel.com","2021-04-09 07:30 AM");
        assertEquals(200, response.statusCode());
    }

    @Test
    public void sendSMSToGroup() throws IOException, InterruptedException {
        HttpResponse<String> response = sms.messagingInstance
                .sendSMSToGroup("Test Java","Test Java");
        assertEquals(200, response.statusCode());
    }

    @Test
    public void createGroup() throws IOException, InterruptedException {
        HttpResponse<String> response = sms.messagingInstance.createGroup("Test Java");
        assertEquals(201, response.statusCode());
    }

    @Test
    public void addContacts() throws IOException, InterruptedException {
        HttpResponse<String> response = sms.messagingInstance.addContacts("Test Java",
                        Arrays.asList(new ContactObject("0205768728"),new ContactObject("0557560032")));
        assertEquals(201, response.statusCode());
    }

    @Test
    public void sendOTPCode() throws IOException, InterruptedException {
        HttpResponse<String> response = sms.phoneVerificationInstance
                .sendOTPCode(6, OTPType.NUMERIC,10,"%otp_code%","0205768728", OTPMedium.SMS);
        assertEquals(200, response.statusCode());
    }

    @Test
    public void verifyOTPCode() throws IOException, InterruptedException {
        HttpResponse<String> response = sms.phoneVerificationInstance
                .verifyOTPCode("0205768728","701395");
        assertEquals(200, response.statusCode());
    }
}
