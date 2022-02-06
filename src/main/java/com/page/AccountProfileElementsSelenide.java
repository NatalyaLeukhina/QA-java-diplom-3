package com.page;


import com.UserOperations;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class AccountProfileElementsSelenide {

    public static String accountProfileURL = "https://stellarburgers.nomoreparties.site/account/profile";

    //кнопка "Выход" в личном кабинете
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    public static SelenideElement exitButton;

    //нажать на кнопку "Выход"
    public static LoginPageElementsSelenide clickExitButton() {
        exitButton.shouldBe(Condition.enabled).click();
        LoginPageElementsSelenide.enterHeaderVisible();
        return page(LoginPageElementsSelenide.class);
    }

    //выход из личного кабинета
    public static AccountProfileElementsSelenide successExit(UserOperations userOperations) {
        open(HomePageElementsSelenide.homeUrl, HomePageElementsSelenide.class).clickLogInAccountButton();
        LoginPageElementsSelenide.successLogin(userOperations);
        HomePageElementsSelenide.clickPersonalAccountButton();
        return page(AccountProfileElementsSelenide.class);


    }

}

