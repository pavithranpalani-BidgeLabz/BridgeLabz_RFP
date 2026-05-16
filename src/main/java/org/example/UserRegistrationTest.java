package org.example;

import com.bl.advance.java.day19.regex.UserRegistration;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UserRegistrationTest {
     @Test // UC1
    public void givenFirstName_WhenProperly_ShouldReturnTrue() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc1("Abcde");
        Assert.assertEquals(true, result);
    }

    @Test // UC1
    public void givenFirstName_WhenImproperly_ShouldReturnFalse() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc1("Ab");
        Assert.assertEquals(false, result);
    }

    @Test // UC2
    public void givenLastName_WhenProperly_ShouldReturnTrue() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc2("Abcde Abcd");
        Assert.assertEquals(true, result);
    }

    @Test // UC2
    public void givenLastName_WhenImproperly_ShouldReturnFalse() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc2("Abcd Ab");
        Assert.assertEquals(false, result);
    }

    @Test // UC3 mandatory
    public void givenMail_WhenProperly_ShouldReturnTrue() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc3("abcd@bl.co");
        Assert.assertEquals(true, result);
    }

    @Test // UC3 mandatory with optional
    public void givenMailWithOptional_WhenProperly_ShouldReturnTrue() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc3("abcd.ab@bl.co");
        Assert.assertEquals(true, result);
    }

    @Test // UC3 with error
    public void givenMail_WhenImProperly_ShouldReturnFalse() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc3("abcd@co.ac");
        Assert.assertEquals(false, result);
    }

    @Test // UC4
    public void givenPhone_WhenProperly_ShouldReturnTrue() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc4("91 1234567890");
        Assert.assertEquals(true, result);
    }

    @Test // UC4 invalid case 1
    public void givenPhone_WhenImProperly1_ShouldReturnFalse() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc4("90 123456789");
        Assert.assertEquals(false, result);
    }

    @Test // UC4 invalid case 2
    public void givenPhone_WhenImProperly2_ShouldReturnFalse() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc4("91 12345789");
        Assert.assertEquals(false, result);
    }

    @Test // UC5
    public void givenPassword_WhenProperly_ShouldReturnTrue() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc5("hello1234");
        Assert.assertEquals(true, result);
    }

    @Test // UC5
    public void givenPassword_WhenImProperly_ShouldReturnFalse() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc5("hel4");
        Assert.assertEquals(false, result);
    }

    @Test // UC6
    public void givenPasswordWithAtleast1Captial_WhenProperly_ShouldReturnTrue() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc6("Hello1234");
        Assert.assertEquals(true, result);
    }

    @Test // UC6
    public void givenPasswordWithAtleast1Captial_WhenImProperly_ShouldReturnFalse() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc6("hello1234");
        Assert.assertEquals(false, result);
    }

    @Test // UC7
    public void givenPasswordWithAtleast1Numeric_WhenProperly_ShouldReturnTrue() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc7("Hello1234");
        Assert.assertEquals(true, result);
    }

    @Test // UC7
    public void givenPasswordWithAtleast1Numeric_WhenImProperly_ShouldReturnFalse() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc7("helloHello");
        Assert.assertEquals(false, result);
    }

    @Test // UC8
    public void givenPasswordWithAtleast1SplCharacter_WhenProperly_ShouldReturnTrue() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc8("Hello@1234");
        Assert.assertEquals(true, result);
    }

    @Test // UC8
    public void givenPasswordWithAtleast1SplCharacter_WhenImProperly_ShouldReturnFalse() {
        UserRegistration registration = new UserRegistration();
        boolean result = registration.uc8("hello12345");
        Assert.assertEquals(false, result);
    }

    @Test // UC9
    public void givenValidEmails_ShouldReturnTrue() {
        Assert.assertEquals(true, UserRegistration.uc9("abc@yahoo.com"));
        Assert.assertEquals(true, UserRegistration.uc9("abc-100@yahoo.com"));
        Assert.assertEquals(true, UserRegistration.uc9("abc.100@yahoo.com"));
        Assert.assertEquals(true, UserRegistration.uc9("abc111@abc.com"));
        Assert.assertEquals(true, UserRegistration.uc9("abc-100@abc.net"));
        Assert.assertEquals(true, UserRegistration.uc9("abc.100@abc.com.au"));
        Assert.assertEquals(true, UserRegistration.uc9("abc@1.com"));
        Assert.assertEquals(true, UserRegistration.uc9("abc@gmail.com"));
        Assert.assertEquals(true, UserRegistration.uc9("abc+100@gmail.com"));
    }

    // INVALID EMAILS
    @Test // Uc9
    public void givenInvalidEmails_ShouldReturnFalse() {
        Assert.assertEquals(false, UserRegistration.uc9("abc"));
        Assert.assertEquals(false, UserRegistration.uc9("abc@.com.my"));
        Assert.assertEquals(false, UserRegistration.uc9("abc123@gmail.a"));
        Assert.assertEquals(false, UserRegistration.uc9("abc123@.com"));
        Assert.assertEquals(false, UserRegistration.uc9("abc123@.com.com"));
        Assert.assertEquals(false, UserRegistration.uc9(".abc@abc.com"));
        Assert.assertEquals(false, UserRegistration.uc9("abc()*@gmail.com"));
        Assert.assertEquals(false, UserRegistration.uc9("abc@%*.com"));
        Assert.assertEquals(false, UserRegistration.uc9("abc..2002@gmail.com"));
        Assert.assertEquals(false, UserRegistration.uc9("abc.@gmail.com"));
        Assert.assertEquals(false, UserRegistration.uc9("abc@abc@gmail.com"));
        Assert.assertEquals(false, UserRegistration.uc9("abc@gmail.com.1a"));
        Assert.assertEquals(false, UserRegistration.uc9("abc@gmail.com.au.au"));
    }
}
