package com;

import com.page.HomePageElementsSelenide;
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
import static com.page.HomePageElementsSelenide.homeUrl;

@RunWith(Parameterized.class)
public class ConstructorTest {

        public String browser;

        public ConstructorTest(String browser) {
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
        @DisplayName("Check transfer from constructor to sauces")
        @Description("Transfer from constructor to sauces")
        public void transferConstructorToSauces() {
            boolean saucesSectionVisible = open(homeUrl, HomePageElementsSelenide.class).clickSaucesSection().saucesSectionVisible();
            Assert.assertTrue("Кнопки Вход нет", saucesSectionVisible);
        }

        @Test
        @DisplayName("Check transfer from constructor to bread")
        @Description("Transfer from constructor to bread")
        public void transferConstructorToBread() {
        boolean breadSectionVisible = open(homeUrl, HomePageElementsSelenide.class).clickSaucesSection().clickBreadSection().breadSectionVisible();
        Assert.assertTrue("Кнопки Вход нет", breadSectionVisible);
    }

        @Test
        @DisplayName("Check transfer from constructor to filling")
        @Description("Transfer from constructor to filling")
        public void transferConstructorToFilling() {
        boolean fillingSectionVisible = open(homeUrl, HomePageElementsSelenide.class).clickFillingSection().fillingSectionVisible();
        Assert.assertTrue("Кнопки Вход нет", fillingSectionVisible);
    }
}
