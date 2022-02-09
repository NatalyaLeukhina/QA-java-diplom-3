package com.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindAll;
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

    //раздел с ингридиентами
    @FindAll({@FindBy(how = How.XPATH, using = ".//ul[@class='BurgerIngredients_ingredients__list__2A-mT']")})
    public static ElementsCollection ingredientsSection;

    //раздел «Булки»
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    public SelenideElement breadSection;

    //заголовок "Булки" в окне выбора ингридиентов
    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    public SelenideElement breadHeader;


    //раздел «Соусы»
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    public SelenideElement saucesSection;

    //заголовок "Соусы" в окне выбора ингридиентов
    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    public SelenideElement saucesHeader;

    //раздел «Начинки»
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    public SelenideElement fillingSection;

    //заголовок "Начинки" в окне выбора ингридиентов
    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    public SelenideElement fillingHeader;


    //кнопка "Оформить заказ"
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    public SelenideElement createOrderButton;


    //открыть главную страницу
    @Step
    public static void openHomePage() {
        Configuration.browser = "chrome";
        System.setProperty("selenide.browser", "chrome");
        HomePageElementsSelenide openHome = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
    }



        //открыть страницу в разных браузерах
        @Step
        public static void openInDifferentBrowsers(String browser) {
        if (browser.equals("yandex")) {
            System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
            Configuration.startMaximized = true;
        } else if (browser.equals("chrome")) {
            System.setProperty("selenide.browser", "chrome");
            Configuration.startMaximized = true;
        }
        }

        //нажать на кнопку Личный кабинет
        @Step
    public static void clickPersonalAccountButton() {

        personalAccountButton.click();
    }

    //нажать на кнопку "Войти в аккаунт"
    @Step
    public static LoginPageElementsSelenide clickLogInAccountButton() {
        logInAccountButton.click();
        return page(LoginPageElementsSelenide.class);
    }

    //нажать на кнопку Конструктор
    @Step
    public static void clickDesignerButton() {
        designerButton.click();

    }

    //нажать на логотип Stellar Burgers
    @Step
    public static void clickStellarBurgersLogo() {
        stellarBurgersLogo.click();
    }

    //переход к разделу "Булки"
    @Step
    public boolean clickBreadSection() {
        saucesSection.click();
        saucesHeader.shouldHave(Condition.exactText("Соусы"));
        breadSection.click();
        breadHeader.shouldHave(Condition.exactText("Булки"));
        return breadHeader.exists();
    }


    //переход к разделу "Соусы"
    @Step
    public boolean clickSaucesSection() {
        saucesSection.click();
        saucesHeader.shouldHave(Condition.exactText("Соусы"));
        return saucesHeader.exists();
        //return this;
    }


    //переход к разделу "Начинки"
    @Step
    public boolean clickFillingSection() {
        fillingSection.click();
        fillingHeader.shouldHave(Condition.exactText("Начинки"));
        return fillingHeader.exists();
    }


    //нажать на кнопку "Войти" в личном кабинете
    @Step
    public static LoginPageElementsSelenide clickLogInPersonalAccount() {
        clickPersonalAccountButton();
        return page(LoginPageElementsSelenide.class);
    }


    //видимость кнопки "Оформить заказ"
    @Step
    public boolean createOrderButtonVisible() {
        return createOrderButton.isDisplayed();
    }


    }
