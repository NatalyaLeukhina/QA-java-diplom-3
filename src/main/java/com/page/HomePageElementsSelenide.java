package com.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
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

    //раздел «Соусы»
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    public SelenideElement saucesSection;

    //раздел «Начинки»
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    public SelenideElement fillingSection;


    //кнопка "Оформить заказ"
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    public SelenideElement createOrderButton;


    //открыть главную страницу
    public static void openHomePage() {
        Configuration.browser = "chrome";
        System.setProperty("selenide.browser", "chrome");
        HomePageElementsSelenide openHome = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
    }


        //открыть страницу в разных браузерах
        public static void openInDifferentBrowsers(String browser) {
        if (browser.equals("yandex")) {
            System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        } else if (browser.equals("chrome")) {
            System.setProperty("selenide.browser", "chrome");
        }
        }

        //нажать на кнопку Личный кабинет
    public static void clickPersonalAccountButton() {

        personalAccountButton.click();
    }

    //нажать на кнопку "Войти в аккаунт"
    public static LoginPageElementsSelenide clickLogInAccountButton() {
        logInAccountButton.click();
        return page(LoginPageElementsSelenide.class);
    }

    //нажать на кнопку Конструктор
    public static void clickDesignerButton() {
        designerButton.click();

    }

    //нажать на логотип Stellar Burgers
    public static void clickstellarBurgersLogo() {
        stellarBurgersLogo.click();
    }

    //переход к разделу "Булки"
    public HomePageElementsSelenide clickBreadSection() {
        breadSection.click();
        ingredientsSection.get(0).shouldBe(Condition.visible);
        return this;
    }

    //видимость раздела "Булки"
    public boolean breadSectionVisible() {
        return ingredientsSection.get(0).isDisplayed();
    }

    //переход к разделу "Соусы"
    public HomePageElementsSelenide clickSaucesSection() {
        saucesSection.click();
        ingredientsSection.get(1).shouldBe(Condition.visible);
        return this;
    }

    //видимость раздела "Соусы"
    public boolean saucesSectionVisible() {
        return ingredientsSection.get(1).isDisplayed();
    }

    //переход к разделу "Начинки"
    public HomePageElementsSelenide clickFillingSection() {
        fillingSection.click();
        ingredientsSection.get(1).shouldBe(Condition.visible);
        return this;
    }

    //видимость раздела "Начинки"
    public boolean fillingSectionVisible() {
        return ingredientsSection.get(2).isDisplayed();
    }


    //нажать на кнопку "Войти" в личном кабинете
    public static LoginPageElementsSelenide clickLogInPersonalAccount() {
        clickPersonalAccountButton();
        return page(LoginPageElementsSelenide.class);
    }


    //видимость кнопки "Оформить заказ"
    public boolean createOrderButtonVisible() {
        return createOrderButton.isDisplayed();
    }


    }
