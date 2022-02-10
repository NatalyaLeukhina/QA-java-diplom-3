package com;


import com.page.AccountProfileElementsSelenide;
import com.page.LoginPageElementsSelenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class ExitAccountTest extends BaseTest {



        private UserOperations userOperations;
        public String browser;

        public ExitAccountTest(String browser) {
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
            userOperations = new UserOperations();

        }



        @After
        public void tearDown() {
            super.closeDriver();
            userOperations.delete();
        }

        @Test
        @DisplayName("Check exit from account")
        @Description("Exit from account")
        public void checkExitAccount() {
            AccountProfileElementsSelenide.successExit(userOperations);
            AccountProfileElementsSelenide.clickExitButton();

            boolean enterHeaderIsVisible = LoginPageElementsSelenide.enterHeaderVisible();

            Assert.assertTrue("Кнопка Выход отсутствует. Выход невозможен.", enterHeaderIsVisible);
        }

}
