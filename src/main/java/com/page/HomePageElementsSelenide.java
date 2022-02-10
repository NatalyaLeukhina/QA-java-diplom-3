package com.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;


public class HomePageElementsSelenide {

    public static String homeUrl = "https://stellarburgers.nomoreparties.site/";

    //кнопка «Войти в аккаунт»
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    public static SelenideElement logInAccountButton;

    //кнопка «Личный кабинет»
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    public static SelenideElement personalAccountButton;

    //кнопка «Конструктор»
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    public static SelenideElement designerButton;

    //логотип Stellar Burgers
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    public static SelenideElement stellarBurgersLogo;

    //раздел «Булки»
    @FindBy(how = How.XPATH, using = "//span[text()='Булки']")
    public static SelenideElement breadSection;


    //раздел «Соусы»
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    public static SelenideElement saucesSection;


    //раздел «Начинки»
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Начинки')]")
    public static SelenideElement fillingSection;

    // Активный таб ингридиентов
    @FindBy(xpath = "//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']")
    public static SelenideElement currentTabIngredients;


    //кнопка "Оформить заказ"
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    public SelenideElement createOrderButton;


    @Step ("Открыть главную страницу")
    public static void openHomePage() {
        Configuration.browser = "chrome";
        System.setProperty("selenide.browser", "chrome");
        open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
    }



    @Step("Нажать на кнопку Личный кабинет")
    public static void clickPersonalAccountButton() {

        personalAccountButton.click();
    }

    @Step("Нажать на кнопку Войти в аккаунт")
    public static LoginPageElementsSelenide clickLogInAccountButton() {
        logInAccountButton.click();
        return page(LoginPageElementsSelenide.class);
    }


    @Step("Нажать на кнопку Конструктор")
    public static void clickDesignerButton() {
        designerButton.click();

    }


    @Step("Нажать на логотип Stellar Burgers")
    public static void clickStellarBurgersLogo() {
        stellarBurgersLogo.click();
    }


    @Step("переход к разделу Булки")
    public static String clickBreadSection() {
        breadSection.click();
        breadSection.shouldHave(Condition.exactText("Булки"));
        return breadSection.getText();
   }


    @Step("переход к разделу Соусы")
    public static String clickSaucesSection() {
        saucesSection.click();
        saucesSection.shouldHave(Condition.exactText("Соусы"));
        return saucesSection.getText();

    }



    @Step("Переход к разделу Начинки")
    public static String clickFillingSection() {
        fillingSection.click();
        fillingSection.shouldHave(Condition.exactText("Начинки"));
        return fillingSection.getText();
    }



    @Step("Нажать на кнопку Войти в личном кабинете")
    public static LoginPageElementsSelenide clickLogInPersonalAccount() {
        clickPersonalAccountButton();
        return page(LoginPageElementsSelenide.class);
    }


    //видимость кнопки "Оформить заказ"
    public boolean createOrderButtonVisible() {
        return createOrderButton.isDisplayed();
    }


    }
