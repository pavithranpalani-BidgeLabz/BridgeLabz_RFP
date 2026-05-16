package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegistrationTestCases {
    UserRegistrationWithExceptionHandling registration =
            new UserRegistrationWithExceptionHandling();

    // ---------- UC1 ----------
    @Test
    public void givenFirstName_WhenProper_ShouldReturnTrue() throws Exception {
        Assert.assertTrue(registration.uc1("Abcde"));
    }

    @Test
    public void givenFirstName_WhenImproper_ShouldThrowException() {
        Assert.assertThrows(UserValidationException.class,
                () -> registration.uc1("Ab"));
    }

    // ---------- UC2 ----------
    @Test
    public void givenLastName_WhenProper_ShouldReturnTrue() throws Exception {
        Assert.assertTrue(registration.uc2("Abcde Abcd"));
    }

    @Test
    public void givenLastName_WhenImproper_ShouldThrowException() {
        Assert.assertThrows(UserValidationException.class,
                () -> registration.uc2("Abc Ab"));
    }

    // ---------- UC3 ----------
    @Test
    public void givenEmail_WhenProper_ShouldReturnTrue() throws Exception {
        Assert.assertTrue(registration.uc3("abcd@bl.co"));
    }

    @Test
    public void givenEmail_WhenImproper_ShouldThrowException() {
        Assert.assertThrows(UserValidationException.class,
                () -> registration.uc3("abcd@co.ac"));
    }

    // ---------- UC4 ----------
    @Test
    public void givenPhone_WhenProper_ShouldReturnTrue() throws Exception {
        Assert.assertTrue(registration.uc4("91 1234567890"));
    }

    @Test
    public void givenPhone_WhenImproper_ShouldThrowException() {
        Assert.assertThrows(UserValidationException.class,
                () -> registration.uc4("90 123456789"));
    }

    // ---------- UC5 ----------
    @Test
    public void givenPassword_WhenProper_ShouldReturnTrue() throws Exception {
        Assert.assertTrue(registration.uc5("hello1234"));
    }

    @Test
    public void givenPassword_WhenImproper_ShouldThrowException() {
        Assert.assertThrows(UserValidationException.class,
                () -> registration.uc5("hel4"));
    }

    // ---------- UC6 ----------
    @Test
    public void givenPasswordWithCapital_WhenProper_ShouldReturnTrue() throws Exception {
        Assert.assertTrue(registration.uc6("Hello1234"));
    }

    @Test
    public void givenPasswordWithCapital_WhenImproper_ShouldThrowException() {
        Assert.assertThrows(UserValidationException.class,
                () -> registration.uc6("hello1234"));
    }

    // ---------- UC7 ----------
    @Test
    public void givenPasswordWithNumber_WhenProper_ShouldReturnTrue() throws Exception {
        Assert.assertTrue(registration.uc7("Hello1234"));
    }

    @Test
    public void givenPasswordWithNumber_WhenImproper_ShouldThrowException() {
        Assert.assertThrows(UserValidationException.class,
                () -> registration.uc7("HelloHello"));
    }

    // ---------- UC8 ----------
    @Test
    public void givenPasswordWithSpecialChar_WhenProper_ShouldReturnTrue() throws Exception {
        Assert.assertTrue(registration.uc8("Hello@1234"));
    }

    @Test
    public void givenPasswordWithSpecialChar_WhenImproper_ShouldThrowException() {
        Assert.assertThrows(UserValidationException.class,
                () -> registration.uc8("hello12345"));
    }

    // ---------- UC9 ----------
    @Test
    public void givenValidEmails_ShouldReturnTrue() throws Exception {
        Assert.assertTrue(UserRegistrationWithExceptionHandling.uc9("abc@yahoo.com"));
        Assert.assertTrue(UserRegistrationWithExceptionHandling.uc9("abc-100@yahoo.com"));
        Assert.assertTrue(UserRegistrationWithExceptionHandling.uc9("abc.100@yahoo.com"));
    }

    @Test
    public void givenInvalidEmails_ShouldThrowException() {
        Assert.assertThrows(UserValidationException.class,
                () -> UserRegistrationWithExceptionHandling.uc9("abc@.com.my"));
    }
}
