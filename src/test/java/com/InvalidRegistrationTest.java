package com;

import com.page.RegisterElementsSelenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;



public class InvalidRegistrationTest extends RegistrationTest{
    public InvalidRegistrationTest(String browser) {
        super(browser);
    }


        @Test
        @DisplayName("Check invalid user registration")
        @Description("Registration with invalid password")
        public void invalidUserRegistration() {
            boolean messageIncorrectPassword = open(RegisterElementsSelenide.registerURL, RegisterElementsSelenide.class).invalidRegistration().messageIncorrectPassword();
            Assert.assertTrue("Сообщения о невалидном пароле нет", messageIncorrectPassword);
        }
}
