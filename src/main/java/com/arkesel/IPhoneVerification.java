package com.arkesel;

import com.arkesel.model.OTPMedium;
import com.arkesel.model.OTPObject;
import com.arkesel.model.OTPType;

import java.io.IOException;
import java.net.http.HttpResponse;

public interface IPhoneVerification {

    public HttpResponse<String> sendOTPCode(OTPObject otpObject) throws IOException, InterruptedException;

    public HttpResponse<String> sendOTPCode(int length, OTPType type, int expiry, String message, String number,
                                            OTPMedium medium) throws IOException, InterruptedException;

    public HttpResponse<String> verifyOTPCode(OTPObject otpObject) throws IOException, InterruptedException;
    public HttpResponse<String> verifyOTPCode(String number,String code) throws IOException, InterruptedException;
}
