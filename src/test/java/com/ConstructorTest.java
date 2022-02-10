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
import static com.page.HomePageElementsSelenide.*;

@RunWith(Parameterized.class)
public class ConstructorTest extends BaseTest{

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
        super.openInDifferentBrowsers(browser);
    }

    @After
    public void tearDown() {
        super.closeDriver();
    }




    @Test
        @DisplayName("Check transfer from constructor to sauces")
        @Description("Transfer from constructor to sauces")
        public void transferConstructorToSauces() {
        open(homeUrl, HomePageElementsSelenide.class);
        clickSaucesSection();

        String actualCurrentTabIngredientsText = HomePageElementsSelenide.currentTabIngredients.getText().trim();
        Assert.assertEquals("Соусы", actualCurrentTabIngredientsText);
        }

        @Test
        @DisplayName("Check transfer from constructor to bread")
        @Description("Transfer from constructor to bread")
        public void transferConstructorToBread() {

            open(HomePageElementsSelenide.homeUrl, HomePageElementsSelenide.class);
            clickFillingSection();
            clickBreadSection();

            String actualCurrentTabIngredientsText = HomePageElementsSelenide.currentTabIngredients.getText().trim();
            Assert.assertEquals("Булки", actualCurrentTabIngredientsText);

        }


        @Test
        @DisplayName("Check transfer from constructor to filling")
        @Description("Transfer from constructor to filling")
        public void transferConstructorToFilling() {
        open(homeUrl, HomePageElementsSelenide.class);
        clickFillingSection();
        String actualCurrentTabIngredientsText = HomePageElementsSelenide.currentTabIngredients.getText().trim();
        Assert.assertEquals("Начинки", actualCurrentTabIngredientsText);

    }
}
