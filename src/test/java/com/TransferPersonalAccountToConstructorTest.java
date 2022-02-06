package com;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.page.HomePageElementsSelenide.*;

@RunWith(Parameterized.class)
public class TransferPersonalAccountToConstructorTest {

        public String browser;

        public TransferPersonalAccountToConstructorTest(String browser) {
            this.browser = browser;

        }

        @Parameterized.Parameters(name = "Выбран браузер {0}")
        public static Object[][] setBrowser() {
            return new Object[][] {
                    {"chrome"},
                    {"yandex"},

            };

        }

        @Before
        public void setUp() {
            openInDifferentBrowsers(browser);

        }

        @After
        public void tearDown() {

            getWebDriver().close();
        }


        @Test
        @DisplayName("Check transfer personal account to constructor button")
        @Description("Transfer personal account to constructor button is success")
        public void checkTransferPersonalAccountToConstructorButton() {

            openHomePage();
            clickPersonalAccountButton();
            clickDesignerButton();
            Assert.assertEquals("Переход в конструктор не произведен", homeUrl, url());

        }

        @Test
        @DisplayName("Check transfer personal account to Stellar Burgers logo")
        @Description("Transfer personal account to Stellar Burgers logo is success")
        public void checkTransferPersonalAccountToStellarBurgersLogo() {

            openHomePage();
            clickPersonalAccountButton();
            clickstellarBurgersLogo();
            Assert.assertEquals("Переход в на главную страницу не произведен", homeUrl, url());

    }

}
