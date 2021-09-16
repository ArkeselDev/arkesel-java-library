package com.arkesel;

import com.arkesel.model.OTPMedium;
import com.arkesel.model.OTPObject;
import com.arkesel.model.OTPType;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PhoneVerification implements IPhoneVerification {

    private static PhoneVerification instance;

    private PhoneVerification(){ }

    public static PhoneVerification getInstance(){
        instance = instance == null ? new PhoneVerification(): instance;
        return instance;
    }

    private HttpResponse<String> generateCode(String body) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(SMS.baseURL+"otp/generate"))
                .header("api-key",SMS.getInstance().getApiKey())
                .header("Content-Type","application/json")
                .header("accept","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        return HttpClient.newHttpClient().send(request,HttpResponse.BodyHandlers.ofString());
    }

    @Override
    public HttpResponse<String> sendOTPCode(OTPObject otpObject) throws IOException, InterruptedException {
        return this.generateCode(otpObject.toString());
    }

    @Override
    public HttpResponse<String> sendOTPCode(int length, OTPType OTPType, int expiry, String message, String number,
                                            OTPMedium medium) throws IOException, InterruptedException {
        OTPObject body = new OTPObject(length, OTPType,expiry,message,number,medium);
        return this.generateCode(body.toString());
    }

    private HttpResponse<String> verifyCode(String body) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(SMS.baseURL+"otp/verify"))
                .header("api-key",SMS.getInstance().getApiKey())
                .header("Content-Type","application/json")
                .header("accept","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        return HttpClient.newHttpClient().send(request,HttpResponse.BodyHandlers.ofString());
    }

    @Override
    public HttpResponse<String> verifyOTPCode(OTPObject otpObject) throws IOException, InterruptedException {
        return this.verifyCode(otpObject.toStringVerify());
    }

    @Override
    public HttpResponse<String> verifyOTPCode(String number,String code) throws IOException, InterruptedException {
        OTPObject body = new OTPObject(number,code);
        return this.verifyCode(body.toStringVerify());
    }
}
