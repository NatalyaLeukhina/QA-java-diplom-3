package com.page;

import com.UserOperations;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class LoginPageElementsSelenide {

    public static String loginURL = "https://stellarburgers.nomoreparties.site/login";

    //поля «Email» и «Пароль»
    @FindBy(how = How.XPATH, using = ".//input")
    public static ElementsCollection emailAndPasswordFields;


    //кнопка «Войти»
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    public static SelenideElement logInButton;

    //кнопка «Оформить заказ»
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    public static SelenideElement createOrderButton;

    //заголовок "Вход"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Вход']")
    public static SelenideElement enterHeader;

    //авторизация пользователя
    public static HomePageElementsSelenide successLogin(UserOperations userOperations) {
        List<String> userData = new ArrayList<>(userOperations.register().values());
        String email = userData.get(2);
        String password = userData.get(0);
        emailAndPasswordFields.get(0).sendKeys(email);
        emailAndPasswordFields.get(1).sendKeys(password);
        logInButton.click();
        createOrderButton.shouldBe(Condition.visible);
        return page(HomePageElementsSelenide.class);
    }

    //заголовок "Вход"
    public static boolean enterHeaderVisible() {

        return enterHeader.shouldBe(Condition.visible).isDisplayed();
    }



    }







