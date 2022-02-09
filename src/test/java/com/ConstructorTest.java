package com;

import com.page.HomePageElementsSelenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;
import static com.page.HomePageElementsSelenide.homeUrl;


public class ConstructorTest extends RegistrationTest {
    public ConstructorTest(String browser) {
        super(browser);
    }


        @Test
        @DisplayName("Check transfer from constructor to sauces")
        @Description("Transfer from constructor to sauces")
        public void transferConstructorToSauces() {
           boolean saucesSectionVisible = open(homeUrl, HomePageElementsSelenide.class).clickSaucesSection();
           Assert.assertTrue("Раздела Соусы нет", saucesSectionVisible);
        }

        @Test
        @DisplayName("Check transfer from constructor to bread")
        @Description("Transfer from constructor to bread")
        public void transferConstructorToBread() {

            boolean breadSectionVisible = open(homeUrl, HomePageElementsSelenide.class).clickBreadSection();

            Assert.assertTrue("Раздела Булки нет", breadSectionVisible);


    }

        @Test
        @DisplayName("Check transfer from constructor to filling")
        @Description("Transfer from constructor to filling")
        public void transferConstructorToFilling() {
        boolean fillingSectionVisible = open(homeUrl, HomePageElementsSelenide.class).clickFillingSection();
        Assert.assertTrue("Раздела Начинки нет", fillingSectionVisible);
    }
}
