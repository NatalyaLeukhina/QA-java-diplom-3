package com;

import com.page.HomePageElementsSelenide;
import com.page.LoginPageElementsSelenide;
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
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


@RunWith(Parameterized.class)
public class RegistrationTest {
    public String browser;

    public RegistrationTest(String browser) {
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
        HomePageElementsSelenide.openInDifferentBrowsers(browser);
    }

    @After
    public void tearDown() {
        getWebDriver().close();
    }

    @Test
    @DisplayName("Check success user registration")
    @Description("User registration is success")
    public void userRegistrationSuccess() {
        open(RegisterElementsSelenide.registerURL, RegisterElementsSelenide.class).successRegistration();
        boolean logInButtonRegisterVisible = LoginPageElementsSelenide.enterHeaderVisible();
        Assert.assertTrue("Кнопки Вход нет", logInButtonRegisterVisible);
    }




}
