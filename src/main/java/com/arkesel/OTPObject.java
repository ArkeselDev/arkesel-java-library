package com.arkesel;

public class OTPObject {

    private int length;
    private OTPType type;
    private int expiry;
    private String message;
    private String number;
    private OTPMedium medium;
    private String code;

    public OTPObject(int length, OTPType OTPType, int expiry, String message, String number, OTPMedium medium) {
        this.length = length;
        this.type = OTPType;
        this.expiry = expiry;
        this.message = message;
        this.number = number;
        this.medium = medium;
    }

    public OTPObject(String number, String code) {
        this.number = number;
        this.code = code;
    }

    @Override
    public String toString() {
        return "{" +
                "\"length\":" + length +
                ", \"type\":\"" + type.toString().toLowerCase() + '"' +
                ", \"expiry\":" + expiry +
                ", \"message\":\"" + message + '"' +
                ", \"number\":\"" + number + '"' +
                ", \"sender_id\":\"" + SMS.getInstance().getSenderID() + '"' +
                ", \"medium\":\"" + medium.toString().toLowerCase() + '"' +
                '}';
    }

    public String toStringVerify() {
        return "{" +
                "\"number\":\"" + number + '"' +
                ", \"code\":\"" + code + '"' +
                '}';
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public OTPType getType() {
        return type;
    }

    public void setType(OTPType type) {
        this.type = type;
    }

    public int getExpiry() {
        return expiry;
    }

    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public OTPMedium getMedium() {
        return medium;
    }

    public void setMedium(OTPMedium medium) {
        this.medium = medium;
    }
}

enum OTPType {
    ALPHANUMERIC,
    NUMERIC
}

enum OTPMedium {
    SMS,
    VOICE
}
