package com;

import com.page.HomePageElementsSelenide;
import com.page.LoginPageElementsSelenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.page.HomePageElementsSelenide.clickPersonalAccountButton;


public class TransferPersonalAccountTest extends RegistrationTest{
    public TransferPersonalAccountTest(String browser) {
        super(browser);
    }


        @Test
        @DisplayName("Check transfer personal account")
        @Description("Transfer personal account is success")
        public void checkTransferPersonalAccount() {

            open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
            clickPersonalAccountButton();
            Assert.assertEquals("Переход в личный кабинет не произведен", LoginPageElementsSelenide.loginURL, url());
        }
}
