package org.example;

import com.bl.advance.java.day21.exception.UserRegistrationWithExceptionHandling;
import com.bl.advance.java.day21.exception.UserValidationException;
import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class JunitEmailParameterizedTest {

    String email;
    boolean expected;

    public JunitEmailParameterizedTest(String email, boolean expected) {
        this.email = email;
        this.expected = expected;
    }

    @Test
    public void givenEmail_ShouldMatchExpectedResult() throws UserValidationException {
        Assert.assertEquals(
                UserRegistrationWithExceptionHandling.uc9(email),
                expected
        );
    }

    @Factory
    public static Object[] emailTestFactory() {
        return new Object[]{
                new JunitEmailParameterizedTest("abc@yahoo.com", true),
                new JunitEmailParameterizedTest("abc-100@yahoo.com", true),
                new JunitEmailParameterizedTest("abc.100@yahoo.com", true),
                new JunitEmailParameterizedTest("abc111@abc.com", true),
                new JunitEmailParameterizedTest("abc-100@abc.net", true),
                new JunitEmailParameterizedTest("abc.100@abc.com.au", true),
                new JunitEmailParameterizedTest("abc@1.com", true),
                new JunitEmailParameterizedTest("abc@gmail.com", true),
                new JunitEmailParameterizedTest("abc+100@gmail.com", true),

                new JunitEmailParameterizedTest("abc", false),
                new JunitEmailParameterizedTest("abc@.com.my", false),
                new JunitEmailParameterizedTest("abc123@gmail.a", false),
                new JunitEmailParameterizedTest("abc123@.com", false),
                new JunitEmailParameterizedTest("abc123@.com.com", false),
                new JunitEmailParameterizedTest(".abc@abc.com", false),
                new JunitEmailParameterizedTest("abc()*@gmail.com", false),
                new JunitEmailParameterizedTest("abc@%*.com", false),
                new JunitEmailParameterizedTest("abc..2002@gmail.com", false),
                new JunitEmailParameterizedTest("abc.@gmail.com", false),
                new JunitEmailParameterizedTest("abc@abc@gmail.com", false),
                new JunitEmailParameterizedTest("abc@gmail.com.1a", false),
                new JunitEmailParameterizedTest("abc@gmail.com.au.au", false)
        };
    }
}
