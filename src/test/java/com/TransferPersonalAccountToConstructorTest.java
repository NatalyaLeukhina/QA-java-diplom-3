package com;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.page.HomePageElementsSelenide.*;


public class TransferPersonalAccountToConstructorTest extends RegistrationTest{
    public TransferPersonalAccountToConstructorTest(String browser) {
        super(browser);
    }


        @Before
        public void setUp() {

            openHomePage();
            clickPersonalAccountButton();
        }


        @Test
        @DisplayName("Check transfer personal account to constructor button")
        @Description("Transfer personal account to constructor button is success")
        public void checkTransferPersonalAccountToConstructorButton() {

            clickDesignerButton();
            Assert.assertEquals("Переход в конструктор не произведен", homeUrl, url());

        }

        @Test
        @DisplayName("Check transfer personal account to Stellar Burgers logo")
        @Description("Transfer personal account to Stellar Burgers logo is success")
        public void checkTransferPersonalAccountToStellarBurgersLogo() {

            clickStellarBurgersLogo();
            Assert.assertEquals("Переход в на главную страницу не произведен", homeUrl, url());

    }

}
