package com;

import com.page.RegisterElementsSelenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static com.codeborne.selenide.Selenide.open;


@RunWith(Parameterized.class)
public class InvalidRegistrationTest extends BaseTest {

    public String browser;

    public InvalidRegistrationTest(String browser) {
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
        @DisplayName("Check invalid user registration")
        @Description("Registration with invalid password")
        public void invalidUserRegistration() {
            boolean messageIncorrectPassword = open(RegisterElementsSelenide.registerURL, RegisterElementsSelenide.class).invalidRegistration().messageIncorrectPassword();
            Assert.assertTrue("Сообщения о невалидном пароле нет", messageIncorrectPassword);
        }
}
