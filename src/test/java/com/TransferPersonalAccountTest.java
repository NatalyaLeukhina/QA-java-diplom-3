package com;

import com.page.HomePageElementsSelenide;
import com.page.LoginPageElementsSelenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.page.HomePageElementsSelenide.clickPersonalAccountButton;

@RunWith(Parameterized.class)
public class TransferPersonalAccountTest extends BaseTest {
    public String browser;

    public TransferPersonalAccountTest(String browser) {
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
        super.openInDifferentBrowsers(browser);
    }

    @After
    public void tearDown() {
        super.closeDriver();
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
