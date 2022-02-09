package com.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordElementsSelenide {
    public static String forgotPasswordURL = "https://stellarburgers.nomoreparties.site/forgot-password";

    //кнопка «Войти»
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    public SelenideElement loginButton;

    //нажать кнопку "Войти"
    @Step
    public LoginPageElementsSelenide clickLoginButton() {
        loginButton.click();
        return page(LoginPageElementsSelenide.class);
    }


}
