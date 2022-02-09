package com;

import com.codeborne.selenide.Configuration;
import com.page.ForgotPasswordElementsSelenide;
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


@RunWith(Parameterized.class)
public class LoginTest {


    private UserOperations userOperations;
    public String browser;

    public LoginTest(String browser) {
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
            userOperations = new UserOperations();
            Configuration.startMaximized = true;
        }

        @After
        public void tearDown() {
            userOperations.delete();
           // getWebDriver().close();
        }

        @Test
        @DisplayName("Check login by the account button at home page")
        @Description("Login by the account button at home page")
        public void loginAccountButtonHomePage() {
            open(HomePageElementsSelenide.homeUrl, HomePageElementsSelenide.class).clickLogInAccountButton();
            boolean createOrderButtonVisible = LoginPageElementsSelenide.successLogin(userOperations).createOrderButtonVisible();
            Assert.assertTrue("Кнопки Оформить заказ нет. Вход не выполнен.", createOrderButtonVisible);
        }

        @Test
        @DisplayName("Check login by the personal account button at home page")
        @Description("Login by the personal account button at home page")
        public void loginPersonalAccountButtonHomePage() {
           open(HomePageElementsSelenide.homeUrl, HomePageElementsSelenide.class);
           HomePageElementsSelenide.clickLogInPersonalAccount();
           boolean createOrderButtonVisible = LoginPageElementsSelenide.successLogin(userOperations).createOrderButtonVisible();
           Assert.assertTrue("Кнопки Оформить заказ нет. Вход не выполнен.", createOrderButtonVisible);
    }

        @Test
        @DisplayName("Check login in register form")
        @Description("Login in register form")
        public void loginRegisterForm() {
           open(RegisterElementsSelenide.registerURL, RegisterElementsSelenide.class).clickLogInButton();

           boolean createOrderButtonVisible = LoginPageElementsSelenide.successLogin(userOperations).createOrderButtonVisible();
           Assert.assertTrue("Кнопки Оформить заказ нет. Вход не выполнен.", createOrderButtonVisible);
    }

        @Test
        @DisplayName("Check login in forgot password form")
        @Description("Login in forgot password form")
           public void loginForgotPasswordForm() {
           open(ForgotPasswordElementsSelenide.forgotPasswordURL, ForgotPasswordElementsSelenide.class).clickLoginButton();

           boolean createOrderButtonVisible = LoginPageElementsSelenide.successLogin(userOperations).createOrderButtonVisible();
           Assert.assertTrue("Кнопки Оформить заказ нет. Вход не выполнен.", createOrderButtonVisible);
    }




}
