Arkesel SMS Java Library
=
---

This is the official supported Java library for the Arkesel API. Please reach out to e-mail
[support@arkesel.com](<mailto:support@arkesel.com?subject=[Github] Java library issue>) with 
any issues that need attention.


##Documentation

General documentation can be found here: https://developers.arkesel.com/

[comment]: <> (Java client library documentation can be found here: )


[comment]: <> (Installation)

[comment]: <> (====================)


[comment]: <> (Manual installation)

[comment]: <> (-------------------)

[comment]: <> (Clone the repository, and use)

[comment]: <> (```)

[comment]: <> (    mvn package)

[comment]: <> (```)

[comment]: <> (to build the jar. Add the jar, located at a path similar to:)

[comment]: <> (```)

[comment]: <> (    target/java-client-<version>.jar)

[comment]: <> (```)

[comment]: <> (If you would like a copy of the javadocs, use)

[comment]: <> (```)

[comment]: <> (    mvn javadoc:javadoc)

[comment]: <> (```)


[comment]: <> (Maven Installation)

[comment]: <> (------------------)

[comment]: <> (Add the following to your pom.xml)

[comment]: <> (```xml)

[comment]: <> (    <!-- Urban Airship Library Dependency-->)

[comment]: <> (    <dependency>)

[comment]: <> (        <groupId>com.urbanairship</groupId>)

[comment]: <> (        <artifactId>java-client</artifactId>)

[comment]: <> (        <version>VERSION</version>)

[comment]: <> (        <!-- Replace VERSION with the version you want to use -->)

[comment]: <> (    </dependency>)

[comment]: <> (```)

## Usage

Setup `API key`, `SenderID` and `Sandox`

```java
//For Both Messaging and Phone Verification
SMS sms = SMS.getInstance();
        
//For Messaging
Messaging messaging = SMS.getMessagingInstance();

//For Phone Verification
PhoneVerification phoneVerification = SMS.getPhoneVerificationInstance();
```

| Parameters | Type  | Default | Required | Description |
|------------|-------|---------|----------|-------------|
| apiKey | String | null | true | Get your **API key** from [here](https://developers.arkesel.com/#section/Get-Started/API-Key) |
| senderID | String | null | true | Any words at most _11 characters_ |
| sandbox | boolean | false | false | For testing |


### Send Quick or Single Message
```java
//Using SMS instance
HttpResponse<String> response = sms.messagingInstance.sendSingleSMS();

//Using Messaging instance
HttpResponse<String> response = messaging.sendSingleSMS();
```
| Parameters | Type  | Default | Required | Description |
|------------|-------|---------|----------|-------------|
| message | String | null | true | Content to be sent |
| recipient | String | null | true | Contact to receive the message |
| callbackURL | String | null | false | When the message is _delivered_ **successful** this url will be triggered |
| scheduledDate | String | null | false | Must be in a date time format |

For more information visit the docs here, [here](https://developers.arkesel.com/#operation/send_sms)

#### Example
```java
//Using SMS instance
HttpResponse<String> response = sms.messagingInstance.sendSingleSMS("Hi snad", "0544919953");

//Using Messaging instance
HttpResponse<String> response = messaging.sendSingleSMS("Hi snad", "233544919953");
```
_**NB**_: Both `0544919953` and `233544919953` are valid number format, you can decide to either include or omit the country code.


### Send Bulk Message
```java
//Using SMS instance
HttpResponse<String> response = sms.messagingInstance.sendBulkSMS();

//Using Messaging instance
HttpResponse<String> response = messaging.sendBulkSMS();
```
| Parameters | Type  | Default | Required | Description |
|------------|-------|---------|----------|-------------|
| message | String | null | true | Content to be sent |
| recipient | List`<`String`>` | null | true | Contacts to receive the message |
| callbackURL | String | null | false | When the message is _delivered_ **successful** this url will be triggered |
| scheduledDate | String | null | false | Must be in a date time format |

For more information visit the docs here, [here](https://developers.arkesel.com/#operation/send_sms)

#### Example
```java
//Using SMS instance
HttpResponse<String> response = sms.messagingInstance.sendSingleSMS("Hi snad", Arrays.asList("0544919953", "233544919953"));

//Using Messaging instance
HttpResponse<String> response = messaging.sendSingleSMS("Hi snad", Arrays.asList("0544919953", "233544919953"));
```

### Send Message to Group
```java
//Using SMS instance
HttpResponse<String> response = sms.messagingInstance.sendSMSToGroup();

//Using Messaging instance
HttpResponse<String> response = messaging.sendSMSToGroup();
```
| Parameters | Type  | Default | Required | Description |
|------------|-------|---------|----------|-------------|
| message | String | null | true | Content to be sent |
| groupName | String | null | true | Contact Group to receive the message |

For more information visit the docs here, [here](https://developers.arkesel.com/#operation/send_sms_to_contact_group)

#### Example
```java
//Using SMS instance
HttpResponse<String> response = sms.messagingInstance.sendSMSToGroup("Hi snad","Arkesel");

//Using Messaging instance
HttpResponse<String> response = messaging.sendSMSToGroup("Hi snad","Arkesel");
```

### Send Messages using MessageObject
```java
//Using SMS instance
HttpResponse<String> response = sms.messagingInstance.sendSMS();

//Using Messaging instance
HttpResponse<String> response = messaging.sendSMS();
```
| Parameters | Type  | Default | Required |
|------------|-------|---------|----------|
| messageObject | MessageObject | null | true |

**MessageObject Parameters**

| Parameters | Type  | Default | Required | Description |
|------------|-------|---------|----------|-------------|
| message | String | null | true | Content to be sent |
| recipient | List`<`String`>` | null | true | Contacts to receive the message |
| callbackURL | String | null | false | When the message is _delivered_ **successful** this url will be triggered |
| scheduledDate | String | null | false | Must be in a date time format |

#### Example
```java
//initiate MessageObject
MessageObject messageObject = new MessageObject("Hi snad", Arrays.asList("0544919953", "233544919953"));

//Using SMS instance
HttpResponse<String> response = sms.messagingInstance.sendSMS(messageObject);

//Using Messaging instance
HttpResponse<String> response = messaging.sendSMS(messageObject);
```

### Create Group
```java
//Using SMS instance
HttpResponse<String> response = sms.messagingInstance.createGroup();

//Using Messaging instance
HttpResponse<String> response = messaging.createGroup();
```
| Parameters | Type  | Default | Required |
|------------|-------|---------|----------|
| groupName | String | null | true |

For more information visit the docs here, [here](https://developers.arkesel.com/#operation/create_contact_group)

#### Example
```java
//Using SMS instance
HttpResponse<String> response = sms.messagingInstance.createGroup("Arkesel");

//Using Messaging instance
HttpResponse<String> response = messaging.createGroup("Arkesel");
```

### Add Contacts
```java
//Using SMS instance
HttpResponse<String> response = sms.messagingInstance.addContacts();

//Using Messaging instance
HttpResponse<String> response = messaging.addContacts();
```
| Parameters | Type  | Default | Required | Description |
|------------|-------|---------|----------|-------------|
| groupName | String | null | true | Name of the group you will like to add these contacts |
| contacts | List`<`ContactObject`>` | null | true | Contacts that will be added to the group |

For more information visit the docs here, [here](https://developers.arkesel.com/#operation/create_contacts)

**ContactObject Parameters**

| Parameters | Type  | Default | Required |
|------------|-------|---------|----------|
| phoneNumber | String | null | true |
| firstname | String | null | false | 
| lastname | String | null | false |
| company | String | null | false | 
| email | String | null | false | 
| username | String | null | false | 

#### Example
```java
ContactObject contactObject1 = new ContactObject("0544919953");
ContactObject contactObject2 = new ContactObject("233544919953");

List<ContactObject> contacts = new ArrayList<>(){
    {
        add(contactObject1);
        add(contactObject2);
    }
};
//Using SMS instance
HttpResponse<String> response = sms.messagingInstance.addContacts("Arkesel",contacts);

//Using Messaging instance
HttpResponse<String> response = messaging.addContacts("Arkesel",contacts);
```

### SMS Balance
```java
//Using SMS instance
HttpResponse<String> response = sms.messagingInstance.getSMSBalance();

//Using Messaging instance
HttpResponse<String> response = messaging.getSMSBalance();
```
For more information visit the docs here, [here](https://developers.arkesel.com/#operation/check_client_balance)

### Send OTP Code
```java
//Using SMS instance
HttpResponse<String> response = sms.phoneVerificationInstance.sendOTPCode();

//Using Phone Verification instance
HttpResponse<String> response = phoneVerification.sendOTPCode();
```

| Parameters | Type  | Default | Required | Description |
|------------|-------|---------|----------|-------------|
| length | int | null | true | Number of characters in the generated code |
| type | enum `OTPType` | null | true | `ALPHANUMERIC` / `NUMERIC` |
| expiry | int | null | false | How long the code will be valid for minutes |
| message | String | null | false | Content of your message should go here. Include the slot `%otp_code%` where the **_generated code_** should be inserted in the message. `%expiry%` can also be included to show the expiry time |
| number | String | null | false | Contacts to receive the code |
| medium | enum `OTPMedium` | null | false | `SMS` / `VOICE` |

For more information visit the docs here, [here](https://developers.arkesel.com/#operation/otp_generate)

#### Example
```java
//Using SMS instance
HttpResponse<String> response = sms.phoneVerificationInstance.sendOTPCode(6, OTPType.NUMERIC, 2,"Code: %otp_code%","0544919953", OTPMedium.SMS);

//Using Phone Verification instance
HttpResponse<String> response = phoneVerification.sendOTPCode(6, OTPType.ALPHANUMERIC, 2,"Code: %otp_code%","0544919953. Code will expire in %expiry% minutes", OTPMedium.VOICE);
```

### Verify OTP Code
```java
//Using SMS instance
HttpResponse<String> response = sms.phoneVerificationInstance.verifyOTPCode();

//Using Phone Verification instance
HttpResponse<String> response = phoneVerification.verifyOTPCode();
```

| Parameters | Type  | Default | Required |
|------------|-------|---------|----------|
| number | String | null | true | 
| code | String | null | true | 

For more information visit the docs here, [here](https://developers.arkesel.com/#operation/otp_verify)

#### Example
```java
//Using SMS instance
HttpResponse<String> response = sms.phoneVerificationInstance.verifyOTPCode("0544919953", "16279");

//Using Phone Verification instance
HttpResponse<String> response = phoneVerification.verifyOTPCode("0544919953", "16279");
```


